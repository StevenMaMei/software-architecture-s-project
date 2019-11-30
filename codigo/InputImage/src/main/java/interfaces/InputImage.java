package interfaces;

import java.awt.image.BufferedImage;

import org.osoa.sca.annotations.Service;

@Service
public interface InputImage {
	public BufferedImage uploadImage(String route);
}
