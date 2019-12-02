package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import interfaces.InputImage;

public class InputImageImp implements InputImage {

	//code got from moodle
	public byte[] uploadImage(String route) {
		System.out.println("leyendo imagen...");
		BufferedImage image = null;
		try {
			ImageInputStream input = ImageIO.createImageInputStream(new File(route));
			Iterator<ImageReader> readers = ImageIO.getImageReaders(input);
			if (!readers.hasNext()) {
		        System.out.println("Error images");
		    }else {
		    	ImageReader reader = null;
		    	
		    	//1.545.785.280 (pixels)
		    	//4.637.355.840 (channels)(3 RGB)
		    	//2.147.483.648 (Max Integer)
		    		
	    		reader = readers.next();
	    		reader.setInput(input);
	    		
	    		ImageReadParam param = reader.getDefaultReadParam();
	    		param.setDestinationType(reader.getRawImageType(0));
	    		
	    		
	    		image = reader.read(0,param);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
	     try {
			ImageIO.write(image, "jpg", bos );
		} catch (IOException e) {
			e.printStackTrace();
		}
	     byte [] data = bos.toByteArray();
	     return data;
		
	}

}
