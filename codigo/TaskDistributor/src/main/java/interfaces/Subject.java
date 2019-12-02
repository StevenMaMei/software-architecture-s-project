package interfaces;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import org.osoa.sca.annotations.Remotable;
import org.osoa.sca.annotations.Service;

import model.CoordinatesDTO;
@Service
@Remotable
public interface Subject extends Serializable, Remote{

	public ICoordinatesDTO getState() throws RemoteException;
	public void noti()throws RemoteException;
	public void attach(Observer obs)throws RemoteException;
	public void detach(Observer obs)throws RemoteException;
	public int distribute(long idImage, int height, int width, double radians)throws RemoteException;
}
