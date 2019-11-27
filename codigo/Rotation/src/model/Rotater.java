package model;

public class Rotater implements Runnable{
	
	private int i1,i2;
	private double[][] rotateMatrix;
	private int[][] coord;
	public Rotater(int initIndex, int endIndex, int[][] coor, double[][] rotateMatrix) {
		i1 = initIndex;
		i2 = endIndex;
		coord = coor;
		this.rotateMatrix = rotateMatrix;
	}
	
	@Override
	public void run() {
		
		for(int i = i1; i < i2; i++) {
			int x1 = (int) Math.round(coord[i][0]*rotateMatrix[0][0] + coord[i][1]*rotateMatrix[0][1]);
			int y1 = (int) Math.round(coord[i][0]*rotateMatrix[1][0] + coord[i][1]*rotateMatrix[1][1]);
			
			coord[i][0] = x1;
			coord[i][1] = y1;
		}
	}

}
