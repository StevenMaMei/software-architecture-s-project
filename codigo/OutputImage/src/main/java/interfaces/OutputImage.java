package interfaces;

import org.osoa.sca.annotations.Scope;
import org.osoa.sca.annotations.Service;

@Service
@Scope("COMPOSITE")
public interface OutputImage {

	public void saveImage(byte[] image, String route);
	
}
