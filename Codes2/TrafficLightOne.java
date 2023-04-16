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
		if (counter < 60)
		{
			counter += 1;
			status = "red";
		}
			
		else status = "notRed";
		return status;
	}

	public String goGreen() {
		String status;
		if (counter < 60)
		{
			counter += 1;
			status = "green";
		}
			
		else status = "notGreen";
		return status;
	}

	public String goYellow() {
		String status;
//		counter = 0;
		if (counter < 5)
		{
			counter += 1;
			status = "yellow";
		}
			
		else status = "notYellow";
		return status;
	}

	public String goPending() {
		String status;
		if (counter < 60)
		{
			counter += 1;
			status = "pending";
		}
			
		else status = "pending";
		return status;
	}

	public String goLeftTurn() {
		String status;
		if (counter < 10)
		{
			counter += 1;
			status = "leftTurn";
		}
			
		else status = "notLeftTurn";
		return status;
	}

}
