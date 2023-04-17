package Codes2;


public class TrafficLights implements TrafficLightController {

	private String lightOneStatus = "green";

	private String lightTwoStatus = "red";
	
	private String stateOne = "green";
	
	private String stateTwo = "red";
	

	private boolean beCarRightSide;

	private boolean beCarLeftSide;
	
	private boolean beCarLeftLine;
	
	private boolean beCarLeftLineTwo;
	
	TrafficLightOne lightOne = new TrafficLightOne();
	TrafficLightTwo lightTwo = new TrafficLightTwo();
	


	public String getLightOneStatus() {
		return lightOneStatus;
	}

	public boolean getBeCarLeftLine() {
		return beCarLeftLine;
	}
	
	public boolean getBeCarLeftLineTwo() {
		return beCarLeftLineTwo;
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
	
	public String getStateOne() {
		return stateOne;
	}
	
	public String getStateTwo() {
		return stateTwo;
	}

	public void setLightOneStatus(String lightOneS) {
		lightOneStatus = lightOneS;

	}

	public void setLightTwoStatus(String lightTwoS) {
		lightTwoStatus = lightTwoS;

	}
	
	public void setStateOne(String state) {
		stateOne = state;

	}
	
	public void setStateTwo(String state) {
		stateTwo = state;

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
	
	public void setBeCarLeftLineTwo(boolean carLeftLeT) {
		beCarLeftLineTwo = carLeftLeT;

	}


	/**
	 * @see TrafficLightController#controlLightTwo()
	 */
	public void controlLightTwo() {
//		String state = getLightTwoStatus();	
		System.out.println("Counter Light Two:     " + lightTwo.getCounter());
		
//		String state = "red";
		switch (getStateTwo())
		{
		case "red":
			if (getLightOneStatus() == "green")
			{
				setStateTwo(lightTwo.goRed());
				setLightTwoStatus("red");
			}
			else if (getLightOneStatus() == "red" && getBeCarLeftLineTwo() == true)
			{
				setStateTwo(lightTwo.goLeftTurn());
				setLightTwoStatus("leftTurn");
			}
			else if (getLightOneStatus() == "red" && getBeCarLeftLineTwo() == false)
			{
				setStateTwo(lightTwo.goGreen());
				setLightTwoStatus("green");
			}
			break;
		case "yellow":
			if (lightTwo.getCounter() < 5)
			{
				setStateTwo(lightTwo.goYellow());
				setLightTwoStatus("yellow");
			}
			else
			{
				lightTwo.setCounter(0);
				setStateTwo(lightTwo.goRed());
				setLightTwoStatus("red");
			}
			
			break;
		case "leftTurn":
			if (lightTwo.getCounter() < 10)
			{
				if (getLightOneStatus() != "red")
				{
					lightTwo.setCounter(0);
					setStateTwo(lightTwo.goRed());
					setLightTwoStatus("red");
					
				}
				else
				{
					setStateTwo(lightTwo.goLeftTurn());
					setLightTwoStatus("leftTurn");
				}
			}
			else
			{
				setStateTwo(lightTwo.goGreen());
				setLightTwoStatus("green");
			}
			break;
		case "green":
			if (lightTwo.getCounter() < 55)
			{
				setStateTwo(lightTwo.goGreen());
				setLightTwoStatus("green");
			}
			else
			{
				lightTwo.setCounter(0);
				setStateTwo(lightTwo.goYellow());
				setLightTwoStatus("yellow");
			}
			break;
		}

	}


	/**
	 * @see TrafficLightController#controlLightOne()
	 */
	public void controlLightOne(String pedLightOne) {
		
		System.out.println("Counter Light One:     " + lightOne.getCounter());
		switch (getStateOne())
		{
		case "green":
			if (pedLightOne == "red" && getBeCarRightSide() == false)
			{
				 setStateOne(lightOne.goGreen());
				 setLightOneStatus("green");

			}
			else if ((pedLightOne == "green" || getBeCarRightSide() == true) && lightOne.getCounter() >= 60)
			{
				setStateOne(lightOne.goYellow());
				lightOne.setCounter(0);
				setLightOneStatus("yellow");
			}
			else if ((pedLightOne == "green" && lightOne.getCounter() < 60) || (getBeCarRightSide() == true && lightOne.getCounter() < 60))
			{
				setStateOne(lightOne.goPending());
				setLightOneStatus("green");
			}
			break;
			
		case "yellow":
			if (lightOne.getCounter() < 5)
			{
				setStateOne(lightOne.goYellow());
				setLightOneStatus("yellow");
			}
			else
			{
				setStateOne(lightOne.goRed());
				setLightOneStatus("red");
				lightOne.setCounter(0);			
			}
			break;
			
		case "red":
			if (lightOne.getCounter() < 60 && getBeCarLeftLine() == false)
			{
//				System.out.println( getBeCarLeftLine());
				setStateOne(lightOne.goRed());
				setLightOneStatus("red");
			}
			else if (getBeCarLeftLine() == true)
			{
				setStateOne(lightOne.goLeftTurn());
				lightOne.setCounter(0);
				setLightOneStatus("leftTurn");
			}
			else if (getBeCarLeftLine() == false)
			{
				setStateOne(lightOne.goGreen());
				setLightOneStatus("green");
			}
			break;
			
		case "leftTurn":
			if (lightOne.getCounter() < 10)
			{
				setStateOne(lightOne.goLeftTurn());
				setLightOneStatus("leftTurn");
			}
			else
			{
				setStateOne(lightOne.goGreen());
				setLightOneStatus("green");
			}
			break;	
		case "pending":
			if (lightOne.getCounter() < 60)
			{
				setStateOne(lightOne.goPending());
				setLightOneStatus("green");
			}
			else
			{
				lightOne.setCounter(0);
				setStateOne(lightOne.goYellow());
				setLightOneStatus("yellow");
			}
		}
	}

}
