package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.tree.FixedHeightLayoutCache;

import org.osoa.sca.annotations.Callback;
import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Scope;

import interfaces.ICoordinatesDTO;
import interfaces.Observer;
import interfaces.Subject;

@Scope("COMPOSITE")
public class TaskDistributorImp implements Subject {

	private static final long serialVersionUID = 1L;

	private static LinkedBlockingQueue<ICoordinatesDTO> taskQueue = new LinkedBlockingQueue<ICoordinatesDTO>();
	private static TreeMap<String, Observer> observersSet = new TreeMap<String, Observer>();

	@Property(name = "subject")
	String rmiBinding;


	public TaskDistributorImp() {
		Thread t = new Thread(new AutomatedNotifier(this));
		t.start();
	}
	public void noti() {
		System.out.println("Notify called");
		int count = 0;
		int totalTasks = taskQueue.size();
		for (Observer o : observersSet.values()) {
			if (count++ < totalTasks) {

				try {
					Observer currObser = (Observer) Naming.lookup(o.getBinding());
					currObser.update(this);
					observersSet.remove(currObser.getBinding());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				return;
			}
		}
	}


	public void attach(Observer obs) {
		System.out.println("observer trying to attach");
		System.out.println("quants of observers: " + observersSet.size());
		System.out.println("tasks: " + taskQueue.size());
		if (taskQueue.size() > 0) {

			Observer currObser;
			try {
				currObser = (Observer) Naming.lookup(obs.getBinding());
				currObser.update(this);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("observer update called");
		} else {
			System.out.println("observer added");

			System.out.println(observersSet.put(obs.getBinding(), obs));

		}
	}

	public void detach(Observer obs) {
		observersSet.remove(obs.getBinding());
	}

	public synchronized int distribute(long idImage, int height, int width, double radians) {
		System.out.println("orden de distribuir...");
		System.out.println("current tasks: " + taskQueue.size());
		System.out.println("-----------------------------------------------------");
		System.out.println("Height: " + height + " width: " + width + " radians: " + radians);
		System.out.println("-----------------------------------------------------");
		int midHeight = height / 2;
		int midWidth = width / 2;
		int quantOfObservers = observersSet.size();

		if (quantOfObservers <= 4) {
			quantOfObservers = 4;
		} else {
			quantOfObservers *= 2;
		}

		int quantOfCoordinates = height * width;
		int delta = (int) Math.ceil((quantOfCoordinates * 1.0) / quantOfObservers);
		int counter = 0;

		int[][] currCords = null;
		int indexWithinCurrCords = 0;
		CoordinatesDTO currDTO = null;
		int quantOfDTOs = 0;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				if (counter == 0 || (counter) % delta == 0) {

					int rows = delta;
					if (quantOfCoordinates - (counter) < delta) {
						rows = quantOfCoordinates - (counter);
					}

					if (currDTO != null) {
						taskQueue.add(currDTO);
					}
					currDTO = null;
					System.out.println(rows);
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

				if (i + 1 == height && j + 1 == width)
					taskQueue.add(currDTO);
			}
		}
		System.out.println(taskQueue.size());
//		noti();
		System.out.println(taskQueue.size());
		return quantOfDTOs;
		
	}


	public static LinkedBlockingQueue<ICoordinatesDTO> getTaskQueue() {
		return taskQueue;
	}
	public static void setTaskQueue(LinkedBlockingQueue<ICoordinatesDTO> taskQueue) {
		TaskDistributorImp.taskQueue = taskQueue;
	}
	public ICoordinatesDTO getState() {
		System.out.println("returning state");
		return taskQueue.poll();
	}

	public String getBinding() {
		return rmiBinding;
	}

}
