package interfaces;

import java.awt.image.BufferedImage;

import org.osoa.sca.annotations.Service;

@Service
public interface InputImage {
	public byte[] uploadImage(String route);
}
