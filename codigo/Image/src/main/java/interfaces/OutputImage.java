package interfaces;

import java.awt.image.BufferedImage;

import org.osoa.sca.annotations.Service;

import model.ImageWrapper;
@Service
public interface OutputImage {

	public void saveImage(ImageWrapper image, String route);
}
