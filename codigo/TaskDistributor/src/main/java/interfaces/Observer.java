package interfaces;

import java.io.Serializable;
import java.rmi.Remote;

import org.osoa.sca.annotations.Remotable;
import org.osoa.sca.annotations.Service;

@Service
@Remotable
public interface Observer extends Remote,Serializable {

	public void update()throws java.rmi.RemoteException;
	public void attach()throws java.rmi.RemoteException;
}
