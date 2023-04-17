package Codes2;


public class PedestrianLightTwo extends PedestrianLight {

	private int counter = 0;

	public String pedestrinaWaiting() {
		return "none";

	}

	public String carWaiting() {
		return "waiting";

	}

	public String pedestrianCrossing() {
		counter += 1;
		return "crossing";

	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int c) {
		counter = c;

	}

}
