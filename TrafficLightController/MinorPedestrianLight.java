package TrafficLightController;

public class MinorPedestrianLight {

	private int count = 0;

	public int pedestrinaWaiting() {
		return 1;
	}

	public int carWaiting() {
		return 2;
	}

	public int pedestrianCrossing() {
		count++;
		return 3;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;

	}

}
