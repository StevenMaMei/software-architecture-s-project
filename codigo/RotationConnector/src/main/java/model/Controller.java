package model;

import java.rmi.RemoteException;

import org.osoa.sca.annotations.Reference;

import interfaces.Observer;
import interfaces.Subject;

public class Controller implements Runnable {

	@Reference(name="subject")
	private Subject subject;

	@Reference(name="observer")
	private Observer rotation;

	public void run() {
		try {
			rotation.attach();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("attach sent");
	}
	

}
