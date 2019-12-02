package interfaces;

import java.io.Serializable;

public interface ICoordinatesDTO extends Serializable{

	public int getInitialPositionWithinOriginalMatrix();
	public void setInitialPositionWithinOriginalMatrix(int initialPositionWithinOriginalMatrix);
	public int[][] getCoordinates();
	public void setCoordinates(int[][] coordinates);
	public double getRadians();
	public void setRadians(double radians);
	public long getIdImage();
	public void setIdImage(long idImage);
}
