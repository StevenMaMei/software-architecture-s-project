package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.osoa.sca.annotations.Scope;

import interfaces.OutputImage;
@Scope("COMPOSITE")
public class OutputImageImp implements OutputImage {

	public void saveImage(byte[] image, String route) {
		System.out.println("guardando imagen");
		File outputFile = new File(route);
		ByteArrayInputStream bis = new ByteArrayInputStream(image);
	     BufferedImage imgToWrite = null;
		try {
			
			imgToWrite = ImageIO.read(bis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			ImageIO.write(imgToWrite, "jpg", outputFile);
			imgToWrite.flush();
			imgToWrite = null;
			System.out.println("image writed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
