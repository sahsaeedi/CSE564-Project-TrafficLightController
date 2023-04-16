package Codes2;

public class PedestrianLights implements PedestrainLightController {

	private String pedLightTwoStatus = "green";

	private String pedLightOneStatus = "red";

	private boolean bePedOne;

	private boolean bePedTwo;
	
	PedestrianLightOne lightPedOne = new PedestrianLightOne();
	PedestrianLightTwo lightPedTwo = new PedestrianLightTwo();

	public void setPedLightOneStatus(String s) {
		pedLightOneStatus = s;

	}

	public void setPedLightTwoStatus(String s) {
		pedLightTwoStatus = s;

	}

	public void setBePedOne(boolean p) {
		bePedOne = p;

	}

	public void setBePedTwo(boolean p) {
		bePedTwo = p;

	}

	public String getPedLighOneStatus() {
		return pedLightOneStatus;
	}

	public String getPedLightTwoStatus() {
		return pedLightTwoStatus;
	}

	public boolean getBePedOne() {
		return bePedOne;
	}

	public boolean getBePedTwo() {
		return bePedTwo;
	}


	/**
	 * @see PedestrainLightController#controlPedLightOne()
	 */
	public void controlPedLightOne(String lightOneStatus) {
		
		String state = "none";
		
		switch (state)
		{
		case "none":
			if (bePedOne == false)
			{
				state = lightPedOne.pedestrianWaiting();
				setPedLightOneStatus("red");
			}
			else
			{
				state = lightPedOne.carWaiting();
				setPedLightOneStatus("red");
			}
			break;
			
		case "waiting":
			if (lightOneStatus == "green")
			{
				state = lightPedOne.carWaiting();
				setPedLightOneStatus("red");
			}
			else
			{
				state = lightPedOne.pedestrianCrossing();
				setPedLightOneStatus("green");
			}
			break;
			
		case "crossing":
			if (lightOneStatus == "red")
			{
				state = lightPedOne.pedestrianCrossing();
				setPedLightOneStatus("green");
			}
			else
			{
				state = lightPedOne.pedestrianWaiting();
				setPedLightOneStatus("red");
			}
			break;
		}

	}


	/**
	 * @see PedestrainLightController#controlPedLightTwo()
	 */
	public void controlPedLightTwo(String lightOneStatus) {
		String state = "crossing";
		
		switch (state)
		{
		case "crossing":
			if (lightOneStatus == "green" && lightPedTwo.getCounter() < 20)
			{
				state = lightPedTwo.pedestrianCrossing();
				setPedLightTwoStatus("green");
			}
			else
			{
				state = lightPedTwo.pedestrinaWaiting();
				setPedLightTwoStatus("red");
			}
			break;
		case "none":
			if (getBePedTwo() == false)
			{
				state = lightPedTwo.pedestrinaWaiting();
				setPedLightTwoStatus("red");
			}
			else
			{
				state = lightPedTwo.carWaiting();
				setPedLightTwoStatus("red");
			}
			break;
		case "waiting":
			if (lightOneStatus == "red")
			{
				state = lightPedTwo.carWaiting();
				setPedLightTwoStatus("red");
			}
			else
			{
				state = lightPedTwo.pedestrianCrossing();
				setPedLightTwoStatus("green");
			}
			break;
			
		}

	}

}
