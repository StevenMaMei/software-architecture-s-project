package test;

import model.CoordinatesDTO;
import model.Rotation;

public class Test {

	public static void main(String[] args) {
		int[][] coords = new int[][] {{2,2},{3,1},{5,8},{4,4}};
		double rad = Math.toRadians(39);
		
		CoordinatesDTO dto = new CoordinatesDTO(0, coords, rad);
		
		Rotation rot = new Rotation();
		rot.setCoordinatesAndInfo(dto);
		
		rot.performRotation();
		
		for(int i =0 ; i < coords.length ; i++) {
				System.out.println(coords[i][0]+ " " + coords[i][1]);
		}
		

	}

}
