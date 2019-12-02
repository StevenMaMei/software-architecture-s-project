package model;

import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.osoa.sca.annotations.Reference;

import interfaces.ICoordinatesDTO;
import interfaces.ImageHandler;
import interfaces.Observer;
import interfaces.Subject;

public class Rotation implements Observer{
	

	private static final long serialVersionUID = 1L;
	private ICoordinatesDTO coordinatesAndInfo;

	@Reference(name="subject")
	private Subject subject;
	@Reference(name="imageHandler")
	transient private ImageHandler image;
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public void update() {
		System.out.println("update method called");
		try {
			coordinatesAndInfo = subject.getState();
			System.out.println("llegó");
			performRotation();
			subject.detach(this);
			System.out.println("performed");
		}catch(Exception e) {
			try {
				subject.attach(this);
			} catch (RemoteException e1) {
			}
			System.out.println("not performed");
		}
		
	}
	
	public void attach() {
		System.out.println("attaching observer");
		try {
			subject.attach(this);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void performRotation() {
		System.out.println("haciendo rotacion");
		double[][] rotationMatrix = calculateRotateMatrix(coordinatesAndInfo.getRadians());
		int threads = Runtime.getRuntime().availableProcessors();
		System.out.println(threads);
		int delta = 0;
		int quantOfCoords = coordinatesAndInfo.getCoordinates().length; 
		
		if(threads > quantOfCoords) {
			threads = quantOfCoords;
		}
		
		delta = (int) Math.ceil((quantOfCoords*1.0)/threads);
		
		ExecutorService service = Executors.newFixedThreadPool(threads);
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
			image.setProcessedFragment(coordinatesAndInfo);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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

	
}
