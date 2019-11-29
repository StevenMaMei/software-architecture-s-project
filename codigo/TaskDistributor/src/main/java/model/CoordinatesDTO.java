package model;

import java.io.Serializable;

public class CoordinatesDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private int initialPositionWithinOriginalMatrix;
	private int[][] coordinates;
	private double radians;
	private long idImage;
	

	public CoordinatesDTO(int pos, int[][] coor, double radians) {
		initialPositionWithinOriginalMatrix = pos;
		coordinates = coor;
		this.radians = radians;
	}

	public int getInitialPositionWithinOriginalMatrix() {
		return initialPositionWithinOriginalMatrix;
	}

	public void setInitialPositionWithinOriginalMatrix(int initialPositionWithinOriginalMatrix) {
		this.initialPositionWithinOriginalMatrix = initialPositionWithinOriginalMatrix;
	}

	public int[][] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(int[][] coordinates) {
		this.coordinates = coordinates;
	}

	public double getRadians() {
		return radians;
	}

	public void setRadians(double radians) {
		this.radians = radians;
	}
	
	public long getIdImage() {
		return idImage;
	}
	
	public void setIdImage(long idImage) {
		this.idImage = idImage;
	}
	
}
