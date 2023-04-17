package Codes2;


public class TrafficLightTwo extends TrafficLight {

	private int counter = 0;
	
	public TrafficLightTwo() {
		TrafficLight trafficTwo=new TrafficLight();
		trafficTwo.setLightId(2);
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
//			counter += 1;
			status = "red";
		}
			
		else status = "notRed";
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
	
	
	public String goGreen() {
		String status;
		if (counter < 55)
		{
			counter += 1;
			status = "green";
		}
			
		else status = "notGreen";
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
