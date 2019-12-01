package model;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.osoa.sca.annotations.Reference;

import interfaces.ImageHandler;
import interfaces.InputImage;

public class Controller implements Runnable {

	@Reference(name="inputImage")
	private InputImage input;
	
	@Reference(name="imageHandler")
	private ImageHandler imageToProcess;

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		try {
			bw.write("Ingrese la ruta de la imagen\n");
			bw.flush();
			String inputRoute = br.readLine();
			bw.write("Ingrese la ruta de salida\n");
			bw.flush();
			String outputRoute = br.readLine();
			BufferedImage image = input.uploadImage(inputRoute);
			imageToProcess.setOutputRoute(outputRoute);
			bw.write("Ingrese los grados a rotar");
			bw.flush();
			imageToProcess.ProcessImage(new ImageWrapper(image), Double.parseDouble(br.readLine()));
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
