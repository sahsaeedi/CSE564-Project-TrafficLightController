package Codes2;

public class PedestrianLightOne extends PedestrianLight {

	
	public PedestrianLightOne() {
		PedestrianLight  pedLightOne = new PedestrianLight();
		pedLightOne.setLightId(1);
	}
	public String carWaiting() {
		return "waiting";
	}

	public String pedestrianWaiting() {
		return "none";

	}

	public String pedestrianCrossing() {
		return "crossing";

	}

}
