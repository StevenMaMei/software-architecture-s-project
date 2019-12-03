package model;

import java.awt.image.BufferedImage;
import java.util.TreeMap;

import interfaces.ICoordinatesDTO;


public class FragmentProcessor implements Runnable {

	private BufferedImage originalImage;
	private BufferedImage processingImage;

	
	private ICoordinatesDTO dto;
	private ImageHandlerImp imageHandler;
	public FragmentProcessor(BufferedImage origImage, BufferedImage procImage, TreeMap<Long, Integer> quantOfParts, TreeMap<Long, Integer> partsReceiv, ICoordinatesDTO dto, ImageHandlerImp imgHandler) {
		originalImage = origImage;
		processingImage = procImage;
		this.dto = dto;
		imageHandler = imgHandler;
	}
	
	public void run() {
		
		int index = dto.getInitialPositionWithinOriginalMatrix();
		int[][] coords = dto.getCoordinates();
		int height = originalImage.getHeight();
		int width = originalImage.getWidth();
		int mHeight = height/2;
		int mWidth = width/2;
		System.out.println("index initial: "+index);
		for(int i = 0; i < coords.length; i++) {
			int x = coords[i][0] + mWidth;
			int y = coords[i][1] + mHeight;
			int xOrig = (int) Math.floor((index + i)%width);
			int yOrig = (int) Math.floor((index + i)/height);
			if(x > -1 && y > -1 && x < width && y < height && xOrig > -1 && yOrig > -1 && xOrig < width && yOrig < height ) {

				
				processingImage.setRGB(xOrig, yOrig, originalImage.getRGB(x, y));
			}
			
		}
		imageHandler.addProcessedFragment(dto.getIdImage());
	}

}
