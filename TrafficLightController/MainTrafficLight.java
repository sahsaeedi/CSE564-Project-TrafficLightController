package TrafficLightController;

public class MainTrafficLight {

	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCounter(int count) {
		this.count = count;

	}

	public int goRed() {
		count++;
		return 4;
	}

	public int goGreen() {
		count++;
		return 1;
	}

	public int goYellow() {
		count++;
		return 3;
	}

	public int goPending() {
		count++;
		return 2;
	}

	public int goLeftTurn() {
		count++;
		return 5;
	}

}
