package Codes2;

public class Camera {

	private boolean carLeftLine;

	private boolean carLeftSide;

	private boolean carRightSide;

	public void setCarLeftSide(boolean carLeftS) {
		carLeftSide = carLeftS;

	}

	public void setCarLeftLine(boolean carLeftL) {
		carLeftLine = carLeftL;

	}

	public void setCarRightSide(boolean carRightS) {
		carRightSide = carRightS;

	}

	public boolean getCarLeftSide() {
		return carLeftSide;
	}

	public boolean getCarLeftLine() {
		return carLeftLine;
	}

	public boolean getCarRightSide() {
		return carRightSide;
	}

}
