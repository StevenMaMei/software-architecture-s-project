package interfaces;

import java.awt.image.BufferedImage;

import org.osoa.sca.annotations.Service;

import model.CoordinatesDTO;
import model.ImageWrapper;
@Service
public interface ImageHandler {

	public void setProcessedFragment(CoordinatesDTO dto);
	public void ProcessImage(ImageWrapper image, double degrees);
	public void setOutputRoute(String route);
}
