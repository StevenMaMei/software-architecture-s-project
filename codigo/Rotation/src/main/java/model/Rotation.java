package model;

import java.rmi.Naming;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Scope;

import interfaces.ICoordinatesDTO;
import interfaces.ImageHandler;
import interfaces.Observer;
import interfaces.Subject;
@Scope("COMPOSITE")
public class Rotation implements Observer{
	

	private static final long serialVersionUID = 1L;
	private static int idSequence = 0;
	private ICoordinatesDTO coordinatesAndInfo;
	private int id = idSequence++;
	@Reference(name="subject")
	private Subject subject;
	@Reference(name="imageHandler")
	transient private ImageHandler image;
	
	static ExecutorService service;
	int threads;
	@Property(name="observer")
	String rmiBinding;
	

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public void update(Subject sub) {
		System.out.println("update method called");
		try {
			subject = (Subject)Naming.lookup(sub.getBinding());
			coordinatesAndInfo = subject.getState();
			System.out.println("llegó");
			subject.detach(this);
			performRotation();
			subject.attach(this);
			System.out.println("performed");
		}catch(Exception e) {
			e.printStackTrace();
			subject.attach(this);
			System.out.println("not performed");
		}
		
	}
	
	public void attach() {
		System.out.println("attaching observer");

		subject.attach(this);

	}
	
	public void performRotation() {
		System.out.println("haciendo rotacion");
		
		double[][] rotationMatrix = calculateRotateMatrix(coordinatesAndInfo.getRadians());
		int delta = 0;
		int quantOfCoords = coordinatesAndInfo.getCoordinates().length; 
		service = null;
		threads = Runtime.getRuntime().availableProcessors();
		service = Executors.newFixedThreadPool(threads);
		if(threads > quantOfCoords) {
			threads = quantOfCoords;
		}
		
		delta = (int) Math.ceil((quantOfCoords*1.0)/threads);
		
		int i = 0;
		while(i < quantOfCoords) {
			i += delta;
			Rotater r = null;
			if(i >= quantOfCoords) {
				r =	new Rotater(i - delta, quantOfCoords, coordinatesAndInfo.getCoordinates(), rotationMatrix);
			}else {
				r =	new Rotater(i - delta, i, coordinatesAndInfo.getCoordinates(), rotationMatrix);
				
			}
			service.execute(r);
			
		}
		service.shutdown();
		while(!service.isTerminated()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		image.setProcessedFragment(coordinatesAndInfo);
		coordinatesAndInfo = null;
		System.out.println("terminó de rotar");
	}
	
	/**
	 * method from moodle
	 * adapted by us
	 * @param radians
	 * @return
	 */
	private double[][] calculateRotateMatrix(double radians) {
		double cosPhi = Math.cos(radians);
		double sinPhi = Math.sin(radians);
		return new double[][] {{cosPhi, -sinPhi},
			{sinPhi, cosPhi}};
	}
	
	public ICoordinatesDTO getCoordinatesAndInfo() {
		return coordinatesAndInfo;
	}

	public void setCoordinatesAndInfo(CoordinatesDTO coordinatesAndInfo) {
		this.coordinatesAndInfo = coordinatesAndInfo;
	}

	

	public Observer getRotation() {
		System.out.println("get rotation method");
		return this;
	}

	public int getId() {
		return id;
	}
	public String getBinding() {
		return rmiBinding;
	}





	
}
