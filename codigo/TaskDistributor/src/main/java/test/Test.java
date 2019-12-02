package test;

import java.rmi.RemoteException;

import interfaces.ICoordinatesDTO;
import model.CoordinatesDTO;
import model.TaskDistributorImp;

public class Test {

	public static void main(String[] args) throws RemoteException {
		TaskDistributorImp task= new TaskDistributorImp();
		int height = 500;
		int width = 40;
		int midHeight = height/2;
		int midWidth = width/2;
		task.distribute(1, height, width, 1.0);
		ICoordinatesDTO curr = task.getTaskQueue().poll();
		while(curr != null) {
			int[][] coors = curr.getCoordinates();
			
			for(int i = 0; i < coors.length; i++) {
				System.out.println((coors[i][0]+midWidth) +" "+ (coors[i][1]+midHeight));
			}
			
			curr = task.getTaskQueue().poll();
		}
	}
}
