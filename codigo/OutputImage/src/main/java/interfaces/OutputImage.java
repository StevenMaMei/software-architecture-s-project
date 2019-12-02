package interfaces;

import org.osoa.sca.annotations.Service;

@Service
public interface OutputImage {

	public void saveImage(byte[] image, String route);
	
}
