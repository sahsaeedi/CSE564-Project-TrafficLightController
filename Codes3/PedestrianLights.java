package Codes2;

public class PedestrianLights implements PedestrainLightController {

	private String pedLightTwoStatus = "green";

	private String pedLightOneStatus = "red";
	
	private String stateOne = "none";
	
	private String stateTwo = "crossing";

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
	
	public void setStateOne(String s) {
		stateOne = s;

	}
	
	public void setStateTwo(String s) {
		stateTwo = s;

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
	
	public String getStateOne() {
		return stateOne;
	}
	
	public String getStateTwo() {
		return stateTwo;
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
		
//		String state = "none";
		
		switch (getStateOne())
		{
		case "none":
			if (bePedOne == false)
			{
				setStateOne(lightPedOne.pedestrianWaiting());
				setPedLightOneStatus("red");
			}
			else
			{
				setStateOne(lightPedOne.carWaiting());
				setPedLightOneStatus("red");
			}
			break;
			
		case "waiting":
			if (lightOneStatus == "green")
			{
				setStateOne(lightPedOne.carWaiting());
				setPedLightOneStatus("red");
			}
			else if (lightOneStatus == "red")
			{
				setStateOne(lightPedOne.pedestrianCrossing());
				setPedLightOneStatus("green");
			}
			break;
			
		case "crossing":
			if (lightOneStatus == "red")
			{
				setStateOne(lightPedOne.pedestrianCrossing());
				setPedLightOneStatus("green");
			}
			else
			{
				setStateOne(lightPedOne.pedestrianWaiting());
				setPedLightOneStatus("red");
			}
			break;
		}

	}


	/**
	 * @see PedestrainLightController#controlPedLightTwo()
	 */
	public void controlPedLightTwo(String lightOneStatus) {
//		String state = "crossing";
		
		switch (getStateTwo())
		{
		case "crossing":
			if (lightOneStatus == "green" && lightPedTwo.getCounter() < 20)
			{
				setStateTwo(lightPedTwo.pedestrianCrossing());
				setPedLightTwoStatus("green");
			}
			else
			{
				setStateTwo(lightPedTwo.pedestrinaWaiting());
				setPedLightTwoStatus("red");
			}
			break;
		case "none":
			if (getBePedTwo() == false)
			{
				setStateTwo(lightPedTwo.pedestrinaWaiting());
				setPedLightTwoStatus("red");
			}
			else
			{
				setStateTwo(lightPedTwo.carWaiting());
				setPedLightTwoStatus("red");
			}
			break;
		case "waiting":
			if (lightOneStatus == "red")
			{
				setStateTwo(lightPedTwo.carWaiting());
				setPedLightTwoStatus("red");
			}
			else
			{
				setStateTwo(lightPedTwo.pedestrianCrossing());
				setPedLightTwoStatus("green");
			}
			break;
			
		}

	}

}
