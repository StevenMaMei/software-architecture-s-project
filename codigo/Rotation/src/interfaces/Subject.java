package interfaces;

import model.CoordinatesDTO;

public interface Subject {

	public CoordinatesDTO getState();
	public void noti();
	public void attach(Observer obs);
	public void detach(Observer obs);
}
