package interfaces;

import java.io.Serializable;

import org.osoa.sca.annotations.Scope;
import org.osoa.sca.annotations.Service;

@Service
@Scope("COMPOSITE")
public interface Subject extends Serializable{

	public ICoordinatesDTO getState();
	public void noti();
	public void attach(Observer obs);
	public void detach(Observer obs);
	public int distribute(long idImage, int height, int width, double radians);
}
