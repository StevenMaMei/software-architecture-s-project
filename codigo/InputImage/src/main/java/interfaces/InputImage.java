package interfaces;


import org.osoa.sca.annotations.Service;

@Service
public interface InputImage {
	public byte[] uploadImage(String route);
}
