package interfaces;

import java.awt.image.BufferedImage;

import org.osoa.sca.annotations.Service;

import model.CoordinatesDTO;
@Service
public interface ImageHandler {

	public void setProcessedFragment(CoordinatesDTO dto);
	public void ProcessImage(BufferedImage image);
}
