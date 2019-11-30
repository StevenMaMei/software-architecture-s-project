package interfaces;

import java.awt.image.BufferedImage;

import org.osoa.sca.annotations.Service;
@Service
public interface OutputImage {

	public void saveImage(BufferedImage image, String route);
}
