package interfaces;

import org.osoa.sca.annotations.Scope;
import org.osoa.sca.annotations.Service;

@Service
@Scope("COMPOSITE")
public interface InputImage {
	public byte[] uploadImage(String route);
}
