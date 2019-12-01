package interfaces;


import org.osoa.sca.annotations.Service;

import model.ImageWrapper;
@Service
public interface OutputImage {

	public void saveImage(ImageWrapper image, String route);
}
