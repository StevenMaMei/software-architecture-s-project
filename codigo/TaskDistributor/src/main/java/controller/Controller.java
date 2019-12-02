package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import interfaces.Subject;
import model.TaskDistributorImp;

public class Controller implements Runnable {

	public void run() {
		try {
			System.out.println("running");
			TaskDistributorImp orig = new TaskDistributorImp();
			Subject stub = (Subject) UnicastRemoteObject.exportObject(orig, 0);
			Registry registry = LocateRegistry.getRegistry(1104);
			registry.rebind("taskDistributor", stub);
			while(true) {
		        if (Thread.interrupted()) {
		            return;
		        }
		    }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
