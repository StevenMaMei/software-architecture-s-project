package model;

import java.awt.image.BufferedImage;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.osoa.sca.annotations.Reference;

import interfaces.ImageHandler;
import interfaces.OutputImage;
import interfaces.TaskDistributor;

public class ImageHandlerImp implements ImageHandler {
	
	@Reference
	TaskDistributor distributor;
	
	@Reference
	OutputImage outputImage;
	
	private TreeMap<Long, BufferedImage> originalImages;
	private TreeMap<Long, BufferedImage> processedImages;
	private TreeMap<Long, Integer> quantOfPartsOfAnImage;
	private TreeMap<Long, Integer> quantOfPartsRecieve;
	
	private long idSequence;
	
	private String route;
	
	private ExecutorService service;
	
	public ImageHandlerImp() {
		originalImages = new TreeMap<Long, BufferedImage>();
		processedImages = new TreeMap<Long, BufferedImage>();
		quantOfPartsOfAnImage = new TreeMap<Long, Integer>();
		quantOfPartsRecieve = new TreeMap<Long, Integer>();
		
		idSequence = 0;
		
		int threads = Runtime.getRuntime().availableProcessors();
		service = Executors.newFixedThreadPool(threads);
	}
	
	public void setProcessedFragment(CoordinatesDTO dto) {
		FragmentProcessor processor = new FragmentProcessor(originalImages.get(dto.getIdImage()), processedImages.get(dto.getIdImage()), quantOfPartsOfAnImage, quantOfPartsRecieve, dto, this);
		service.execute(processor);
	}

	public void ProcessImage(BufferedImage image, double degrees) {
		originalImages.put(idSequence, image);
		processedImages.put(idSequence, new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB));
		quantOfPartsOfAnImage.put(idSequence, distributor.distribute(idSequence, image.getHeight(), image.getWidth(), Math.toRadians(degrees)));
		idSequence++;
	}
	
	public void saveImage(long id, String route) {
		outputImage.saveImage(processedImages.get(id), route);
	}
	public synchronized void addProcessedFragment(long id) {
		quantOfPartsRecieve.put(id, quantOfPartsRecieve.get(id)+1);
		if(quantOfPartsRecieve.get(id) == quantOfPartsOfAnImage.get(id)) {
			saveImage(id, route);
		}
	}

	public void setOutputRoute(String route) {
		this.route = route;
	}

}
