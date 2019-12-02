package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;

import org.osoa.sca.annotations.Reference;

import interfaces.ICoordinatesDTO;
import interfaces.ImageHandler;
import interfaces.OutputImage;
import interfaces.Subject;

public class ImageHandlerImp implements ImageHandler {
	
	@Reference(name="subject")
	Subject distributor;
	
	@Reference(name="outputImage")
	OutputImage outputImage;
	
	private static TreeMap<Long, BufferedImage> originalImages;
	private static TreeMap<Long, BufferedImage> processedImages;
	private static TreeMap<Long, Integer> quantOfPartsOfAnImage;
	private static TreeMap<Long, Integer> quantOfPartsRecieve;
	
	private static long idSequence;
	
	private static String route;
	
	private static ExecutorService service;
	
	public ImageHandlerImp() {
		originalImages = new TreeMap<Long, BufferedImage>();
		processedImages = new TreeMap<Long, BufferedImage>();
		quantOfPartsOfAnImage = new TreeMap<Long, Integer>();
		quantOfPartsRecieve = new TreeMap<Long, Integer>();
		
		idSequence = 0;
		
		int threads = Runtime.getRuntime().availableProcessors();
		service = Executors.newFixedThreadPool(threads);
	}
	
	public void setProcessedFragment(ICoordinatesDTO dto) {
		System.out.println("poniendo un fragmento...");
		FragmentProcessor processor = new FragmentProcessor(originalImages.get(dto.getIdImage()), processedImages.get(dto.getIdImage()), quantOfPartsOfAnImage, quantOfPartsRecieve, dto, this);
		service.execute(processor);
	}

	public void ProcessImage(byte[] ima, double degrees) {
		System.out.println("recibiendo imagen para procesar");
		ByteArrayInputStream bis = new ByteArrayInputStream(ima);
	    
		BufferedImage image = null;
		try {
			image = ImageIO.read(bis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		originalImages.put(idSequence, image);
		processedImages.put(idSequence, new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB));
		try {
			quantOfPartsOfAnImage.put(idSequence, distributor.distribute(idSequence, image.getHeight(), image.getWidth(), Math.toRadians(degrees)));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idSequence++;
	}
	
	public void saveImage(long id, String route) {
		System.out.println("guardando imagen");
		BufferedImage image = processedImages.get(id);
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
	     try {
			ImageIO.write(image, "jpg", bos );
		} catch (IOException e) {
			e.printStackTrace();
		}
	     byte [] data = bos.toByteArray();
		outputImage.saveImage(data, route);
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
