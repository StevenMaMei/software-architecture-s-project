package model;

import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

import interfaces.ICoordinatesDTO;
import interfaces.Observer;

public class Distributer implements Runnable {

	private static LinkedBlockingQueue<ICoordinatesDTO> taskQueue = new LinkedBlockingQueue<ICoordinatesDTO>();
	private static TreeMap<String, Observer> observersSet = new TreeMap<String, Observer>();
	long idImagen;
	int height;
	int width;
	double radians;
	public Distributer(LinkedBlockingQueue<ICoordinatesDTO> queue,TreeMap<String, Observer> set, long idImage, int height, int width, double radians) {
		this.idImagen = idImage;
		this.height = height;
		this.width = width;
		this.radians = radians;
		taskQueue = queue;
		observersSet = set;
	}
	public void run() {
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
					currDTO.setIdImage(idImagen);
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

	}

}
