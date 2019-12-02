package interfaces;


import org.osoa.sca.annotations.Service;

import model.CoordinatesDTO;
@Service
public interface ImageHandler {

	public void setProcessedFragment(ICoordinatesDTO dto);
	public void ProcessImage(byte[] image, double degrees);
	public void setOutputRoute(String route);
}
