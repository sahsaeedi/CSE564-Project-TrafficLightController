package Codes2;


public class TrafficLights implements TrafficLightController {

	private String lightOneStatus = "green";

	private String lightTwoStatus = "red";

	private boolean beCarRightSide;

	private boolean beCarLeftSide;
	
	private boolean beCarLeftLine;
	
	TrafficLightOne lightOne = new TrafficLightOne();
	TrafficLightTwo lightTwo = new TrafficLightTwo();
	
	public TrafficLights() {
		
	}

	public String getLightOneStatus() {
		return lightOneStatus;
	}

	public boolean getBeCarLeftLine() {
		return beCarLeftLine;
	}
	
	public String getLightTwoStatus() {
		return lightTwoStatus;
	}

	public boolean getBeCarLeftSide() {
		return beCarLeftSide;
	}

	public boolean getBeCarRightSide() {
		return beCarRightSide;
	}

	public void setLightOneStatus(String lightOneS) {
		lightOneStatus = lightOneS;

	}

	public void setLightTwoStatus(String lightTwoS) {
		lightTwoStatus = lightTwoS;

	}

	public void setBeCarRightSide(boolean carRightSide) {
		beCarRightSide = carRightSide;

	}

	public void setBeCarLeftSide(boolean carLeftSide) {
		beCarLeftSide = carLeftSide;

	}
	
	public void setBeCarLeftLine(boolean carLeftL) {
		beCarLeftLine = carLeftL;

	}


	/**
	 * @see TrafficLightController#controlLightTwo()
	 */
	public void controlLightTwo() {
//		String state = getLightTwoStatus();	
		String state = "red";
		switch (state)
		{
		case "red":
			if (getLightOneStatus() == "green")
			{
				state = lightTwo.goRed();
				if (state == "red")
					setLightTwoStatus("red");
			}
			else if (getLightOneStatus() == "red" && getBeCarLeftLine() == true)
			{
				state = lightTwo.goLeftTurn();
				if (state == "leftTurn")
					setLightTwoStatus("leftTurn");
			}
			else if (getLightOneStatus() == "red" && getBeCarLeftLine() == false)
			{
				state = lightTwo.goGreen();
				if (state == "green")
					setLightTwoStatus("green");
			}
			break;
		case "yellow":
			if (lightTwo.getCounter() < 5)
			{
				state = lightTwo.goYellow();
				if (state == "yellow")
					setLightTwoStatus("yellow");
			}
			else
			{
				lightTwo.setCounter(0);
				state = lightTwo.goRed();
				setLightTwoStatus("red");
			}
			
			break;
		case "leftTurn":
			if (lightTwo.getCounter() < 10)
			{
				state = lightTwo.goLeftTurn();
				if (state == "leftTurn")
					setLightTwoStatus("leftTurn");
			}
			else
			{
				state = lightTwo.goGreen();
				if (state == "green")
					setLightTwoStatus("green");
			}
			break;
		case "green":
			if (lightTwo.getCounter() < 55)
			{
				state = lightTwo.goGreen();
				if (state == "green")
					setLightTwoStatus("green");
			}
			else
			{
				lightTwo.setCounter(0);
				state = lightTwo.goYellow();
				setLightTwoStatus("yellow");
			}
			break;
		}

	}


	/**
	 * @see TrafficLightController#controlLightOne()
	 */
	public void controlLightOne(boolean pedLightOne) {
		
//		String state = getLightOneStatus();	
		String state = "green";
		switch (state)
		{
		case "green":
			if (pedLightOne == false && getBeCarRightSide() == false)
			{
				state = lightOne.goGreen();
				if (state == "green")
//					System.out.println(lightOne.getCounter());
					setLightOneStatus("green");

			}
			else if ((pedLightOne == true || getBeCarRightSide() == true) && lightOne.getCounter() >= 60)
			{
				state = lightOne.goYellow();
				lightOne.setCounter(0);
				setLightOneStatus("yellow");
			}
			else if ((pedLightOne == true && lightOne.getCounter() < 60) || (getBeCarRightSide() == true && lightOne.getCounter() < 60))
			{
				state = lightOne.goPending();
				if (state == "pending")
					setLightOneStatus("green");
			}
				
				
			break;
			
		case "yellow":
			if (lightOne.getCounter() < 5)
			{
				state = lightOne.goYellow();
				if (state == "yellow")
					setLightOneStatus("yellow");
			}
			else
			{
				state = lightOne.goRed();
				if (state == "red")
				{
					setLightOneStatus("red");
					lightOne.setCounter(0);
				}
					
			}
			break;
			
		case "red":
			if (lightOne.getCounter() < 60)
			{
				state = lightOne.goRed();
				if (state == "red")
					setLightOneStatus("red");
			}
			else if (getBeCarLeftLine() == true)
			{
				state = lightOne.goLeftTurn();
				lightOne.setCounter(0);
				if (state == "leftTurn")
					setLightOneStatus("leftTurn");
			}
			else if (getBeCarLeftLine() == false)
			{
				state = lightOne.goGreen();
				if (state == "green")
					setLightOneStatus("green");
			}
			break;
			
		case "leftTurn":
			if (lightOne.getCounter() < 10)
			{
				state = lightOne.goLeftTurn();
				if (state == "leftTurn")
					setLightOneStatus("leftTurn");
			}
			else
			{
				state = lightOne.goGreen();
				if (state == "green")
					setLightOneStatus("green");
			}
			break;	
		case "pending":
			if (lightOne.getCounter() < 60)
			{
				state = lightOne.goPending();
				if (state == "pending")
					setLightOneStatus("green");
			}
			else
			{
				lightOne.setCounter(0);
				state = lightOne.goYellow();
				if (state == "yellow")
					setLightOneStatus("yellow");
			}
		}
		
		
			
		
		
		
		
		

	}

}
