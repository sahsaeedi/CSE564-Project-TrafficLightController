package TrafficLightController;

public class MainPedestrianLight {

	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int carWaiting() {
		return 2;
	}

	public int pedestrianWaiting() {
		return 1;
	}

	public int pedestrianCrossing() {
		return 3;
	}

}
