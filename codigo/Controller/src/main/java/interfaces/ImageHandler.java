package interfaces;

import org.osoa.sca.annotations.Scope;
import org.osoa.sca.annotations.Service;

@Service
@Scope("COMPOSITE")
public interface ImageHandler {

	public void setProcessedFragment(ICoordinatesDTO dto);

	public void ProcessImage(byte[] image, double degrees);

	public void setOutputRoute(String route);
}
