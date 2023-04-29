package TrafficLightController;

public class MinorTrafficLight {

	private int count = 0;

	public int goRed() {
		count++;
		return 3;
	}

	public int goYellow() {
		count++;
		return 2;
	}

	public int goGreen() {
		count++;
		return 1;
	}

	public int goLeftTurn() {
		count++;
		return 4;
	}

	public int getCount() {
		count++;
		return count;
	}

	public void setCount(int count) {
		this.count = count;

	}

}
