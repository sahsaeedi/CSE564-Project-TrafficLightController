package Codes2;


public class TrafficLightOne extends TrafficLight {

	private int counter = 0;
	
	
	
	public TrafficLightOne() {
		TrafficLight trafficOne=new TrafficLight();
		trafficOne.setLightId(1);
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int c) {
		counter = c;

	}

	public String goRed() {
		String status;
		counter += 1;
		status = "red";
		
		return status;
	}

	public String goGreen() {
		String status;
		counter += 1;
		status = "green";
		return status;
	}

	public String goYellow() {
		String status;
		counter += 1;
		status = "yellow";
			
		return status;
	}

	public String goPending() {
		String status;
		counter += 1;
		status = "pending";

		return status;
	}

	public String goLeftTurn() {
		String status;
		counter += 1;
		status = "leftTurn";

		return status;
	}

}
