package model;

import java.rmi.RemoteException;
import java.util.Iterator;

import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.osoa.sca.annotations.Remotable;

import interfaces.Observer;
import interfaces.Subject;
import interfaces.TaskDistributor;

public class TaskDistributorImp implements TaskDistributor, Subject {

	private static final long serialVersionUID = 1L;

	private ConcurrentLinkedQueue<CoordinatesDTO> taskQueue = new ConcurrentLinkedQueue<CoordinatesDTO>();
	
	private TreeSet<Observer> observersSet = new TreeSet<Observer>();



	public void noti() {
		Iterator<Observer> it = observersSet.iterator();
		System.out.println("Notify called");
		int count = 0;
		int totalTasks = taskQueue.size();
		while(it.hasNext() && count < totalTasks) {
			System.out.println("calling update");
			try {
				it.next().update();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void attach(Observer obs) {
		System.out.println("observer trying to attach");
		System.out.println("quants of observers: "+observersSet.size());
		if(taskQueue.size() > 0) {
			try {
				obs.update();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("observer update called");
		}else {
			System.out.println("observer added");
			System.out.println(observersSet.add(obs));
			
		}
	}

	public void detach(Observer obs) {
		observersSet.remove(obs);
	}

	public int distribute(long idImage, int height, int width, double radians) {
		System.out.println("orden de distribuir...");
		System.out.println("-----------------------------------------------------");
		System.out.println("Height: "+height + " width: " + width + " radians: " +radians);
		System.out.println("-----------------------------------------------------");
		int midHeight= height/2;
		int midWidth = width/2;
		int quantOfObservers = observersSet.size();
		
		if(quantOfObservers <= 4) {
			quantOfObservers = 4;
		}else {
			quantOfObservers *= 2;
		}
		
		int quantOfCoordinates = height * width;	
		int delta = (int) Math.ceil((quantOfCoordinates*1.0)/quantOfObservers);
		int counter = 0;
		
		int[][] currCords= null;
		int indexWithinCurrCords = 0;
		CoordinatesDTO currDTO =null;
		int quantOfDTOs = 0;

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				
				if(counter == 0 || (counter)%delta == 0) {
					
					int rows =delta;
					if(quantOfCoordinates - (counter) < delta) {
						rows = quantOfCoordinates - (counter);
					}
					
					if(currDTO != null) {
						taskQueue.add(currDTO);
					}
					
					currDTO = new CoordinatesDTO(counter, new int[rows][2], radians);
					quantOfDTOs++;
					currDTO.setIdImage(idImage);
					currCords = currDTO.getCoordinates();
					indexWithinCurrCords = 0;
					
				}
				
				currCords[indexWithinCurrCords][0] = j - midWidth;
				currCords[indexWithinCurrCords][1] = i - midHeight;
				indexWithinCurrCords++;
				counter++;
				
				if( i + 1 == height && j+1 == width)
					taskQueue.add(currDTO);
			}
		}
		System.out.println(taskQueue.size());
		noti();
		System.out.println(taskQueue.size());
		return quantOfDTOs;
	}

	public ConcurrentLinkedQueue<CoordinatesDTO> getTaskQueue() {
		return taskQueue;
	}

	public void setTaskQueue(ConcurrentLinkedQueue<CoordinatesDTO> taskQueue) {
		this.taskQueue = taskQueue;
	}

	public CoordinatesDTO getState() {
		System.out.println("returning state");
		return taskQueue.poll();
	}

}
