package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import interfaces.OutputImage;

public class OutputImageImp implements OutputImage {

	public void saveImage(ImageWrapper image, String route) {
		File outputFile = new File(route);
		try {
			ImageIO.write(image.getImage(), "jpg", outputFile);
			System.out.println("image writed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
