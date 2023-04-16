package Codes2;

public class PedestrianLightOne extends PedestrianLight {

	
	public PedestrianLightOne() {
		PedestrianLight  pedLightOne = new PedestrianLight();
		pedLightOne.setLightId(1);
	}
	public String carWaiting() {
		return "none";
	}

	public String pedestrianWaiting() {
		return "waiting";

	}

	public String pedestrianCrossing() {
		return "crossing";

	}

}
