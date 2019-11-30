package model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.osoa.sca.annotations.Reference;

import interfaces.ImageHandler;
import interfaces.Observer;
import interfaces.Subject;

public class Rotation implements Observer{
	
	private CoordinatesDTO coordinatesAndInfo;
	@Reference
	private Subject subject;
	@Reference
	private ImageHandler image;
	
	@Override
	public void update() {
		coordinatesAndInfo = subject.getState();
		if(coordinatesAndInfo != null) {
			performRotation();
		}else {
			subject.attach(this);
		}
	}
	
	public void performRotation() {
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
	
	public CoordinatesDTO getCoordinatesAndInfo() {
		return coordinatesAndInfo;
	}

	public void setCoordinatesAndInfo(CoordinatesDTO coordinatesAndInfo) {
		this.coordinatesAndInfo = coordinatesAndInfo;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
}
