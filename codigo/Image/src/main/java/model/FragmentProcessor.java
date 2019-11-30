package model;

import java.awt.image.BufferedImage;
import java.util.TreeMap;

import interfaces.ImageHandler;

public class FragmentProcessor implements Runnable {

	private BufferedImage originalImage;
	private BufferedImage processingImage;
	private TreeMap<Long, Integer> quantOfPartsOfAnImage;
	private TreeMap<Long, Integer> quantOfPartsRecieve;
	private CoordinatesDTO dto;
	private ImageHandlerImp imageHandler;
	public FragmentProcessor(BufferedImage origImage, BufferedImage procImage, TreeMap<Long, Integer> quantOfParts, TreeMap<Long, Integer> partsReceiv, CoordinatesDTO dto, ImageHandlerImp imgHandler) {
		originalImage = origImage;
		processingImage = procImage;
		quantOfPartsOfAnImage = quantOfParts;
		quantOfPartsRecieve = partsReceiv;
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
		for(int i = 0; i < coords.length; i++) {
			int x = coords[i][0] + mWidth;
			int y = coords[i][1] + mHeight;
			if(x > -1 && y > -1 && x < width && y < height ) {
				int xOrig = index%width;
				int yOrig = index/height;
				processingImage.setRGB(x, y, originalImage.getRGB(xOrig, yOrig));
			}
		}
		imageHandler.addProcessedFragment(dto.getIdImage());
	}

}
