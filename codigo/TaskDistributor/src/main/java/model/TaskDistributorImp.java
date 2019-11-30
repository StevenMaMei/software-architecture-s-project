package model;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;

import interfaces.Observer;
import interfaces.Subject;
import interfaces.TaskDistributor;

public class TaskDistributorImp implements TaskDistributor, Subject {

	private ConcurrentLinkedQueue<CoordinatesDTO> taskQueue;
	private TreeSet<Observer> observersSet;
	
	public TaskDistributorImp() {
		taskQueue = new ConcurrentLinkedQueue<CoordinatesDTO>();
		observersSet = new TreeSet<Observer>();
	}
	public CoordinatesDTO getState() {
		return taskQueue.poll();
	}

	public void noti() {
		Iterator<Observer> it = observersSet.iterator();
		int count = 0;
		int totalTasks = taskQueue.size();
		while(it.hasNext() && count < totalTasks) {
			it.next().update();
		}
	}

	public void attach(Observer obs) {
		if(taskQueue.size() > 0) {
			obs.update();
		}
	}

	public void detach(Observer obs) {
		observersSet.remove(obs);
	}

	public void distribute(long idImage, int height, int width, double radians) {
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
		
		noti();

	}

	public ConcurrentLinkedQueue<CoordinatesDTO> getTaskQueue() {
		return taskQueue;
	}

	public void setTaskQueue(ConcurrentLinkedQueue<CoordinatesDTO> taskQueue) {
		this.taskQueue = taskQueue;
	}

}
