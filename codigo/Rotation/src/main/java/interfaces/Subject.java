package interfaces;

import java.io.Serializable;

import org.osoa.sca.annotations.Service;

import model.CoordinatesDTO;
@Service
public interface Subject extends Serializable{

	public CoordinatesDTO getState();
	public void noti();
	public void attach(Observer obs);
	public void detach(Observer obs);
}
