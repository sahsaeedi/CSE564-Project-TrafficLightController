package Codes2;

public class Camera {

	private boolean carLeftLine;
	
	private boolean carLeftLineTwo;


	private boolean carRightSide;


	public void setCarLeftLine(boolean carLeftL) {
		carLeftLine = carLeftL;

	}
	
	public void setCarLeftLineTwo(boolean carLeftLT) {
		carLeftLineTwo = carLeftLT;

	}

	public void setCarRightSide(boolean carRightS) {
		carRightSide = carRightS;

	}


	public boolean getCarLeftLine() {
		return carLeftLine;
	}
	
	public boolean getCarLeftLineTwo() {
		return carLeftLineTwo;
	}

	public boolean getCarRightSide() {
		return carRightSide;
	}

}
