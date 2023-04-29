package TrafficLightController;

public class TrafficLights implements TrafficLightController {

	private int mainLightStatus = 1;
	private int minorLightStatus = 3;

	private boolean minorRoadTraffic;

	private boolean mainLeftTurnTraffic;

	private boolean minorLeftTurnTraffic;

	private MainTrafficLight mainLight = new MainTrafficLight();

	private MinorTrafficLight minorLight = new MinorTrafficLight();

	private int mainState = 1;

	private int minorState = 3;

	public int getMainLightStatus() {
		return mainLightStatus;
	}


	public void setMainLightStatus(int mainLightStatus) {
		this.mainLightStatus = mainLightStatus;
	}


	public int getMinorLightStatus() {
		return minorLightStatus;
	}


	public void setMinorLightStatus(int minorLightStatus) {
		this.minorLightStatus = minorLightStatus;
	}


	public boolean getMinorRoadTraffic() {
		return minorRoadTraffic;
	}


	public void setMinorRoadTraffic(boolean minorRoadTraffic) {
		this.minorRoadTraffic = minorRoadTraffic;
	}


	public boolean getMainLeftTurnTraffic() {
		return mainLeftTurnTraffic;
	}


	public void setMainLeftTurnTraffic(boolean mainLeftTurnTraffic) {
		this.mainLeftTurnTraffic = mainLeftTurnTraffic;
	}


	public boolean getMinorLeftTurnTraffic() {
		return minorLeftTurnTraffic;
	}


	public void setMinorLeftTurnTraffic(boolean minorLeftTurnTraffic) {
		this.minorLeftTurnTraffic = minorLeftTurnTraffic;
	}


	public int getMainState() {
		return mainState;
	}


	public void setMainState(int mainState) {
		this.mainState = mainState;
	}


	public int getMinorState() {
		return minorState;
	}


	public void setMinorState(int minorState) {
		this.minorState = minorState;
	}




	


	/**
	 * @see TrafficLightController#controlminorLight()
	 */
	public void controlMinorLight() {
//		System.out.println(getMinorState() +"   ======   "+ getMainState() + "   =======   " + getMinorLightStatus());

		switch (getMinorState())
		{
		case 3:
			if (getMainState() == 1)
			{
				setMinorState(minorLight.goRed());
				setMinorLightStatus(3);
			}
			else if (getMainLightStatus() == 3 && getMinorLeftTurnTraffic() == true)
			{
				setMinorState(minorLight.goLeftTurn());
				setMinorLightStatus(4);
			}
//			else if (getMainState() == 5 && getMinorLeftTurnTraffic() == false)
//			{
//				setMinorState(minorLight.goRed());
//				setMinorLightStatus(3);
//			}
			else if (getMainLightStatus() == 3 && getMinorLeftTurnTraffic() == false)
			{
//				System.out.println("fdddddddddddddddddddd");
//				if (getMainState() == 4)
//				{
//					setMinorState(minorLight.goRed());
//					setMinorLightStatus(3);
//				}
//				else
//				{
				setMinorState(minorLight.goGreen());
				setMinorLightStatus(1);
//				}

			}
			break;
		case 2:
			if (minorLight.getCount() < 5)
			{
				setMinorState(minorLight.goYellow());
				setMinorLightStatus(2);
			}
			else
			{
				minorLight.setCount(0);
				setMinorState(minorLight.goRed());
				setMinorLightStatus(3);
			}
			
			break;
		case 4:
			if (minorLight.getCount() < 10)
			{
				if (getMainLightStatus() != 3)
				{
					minorLight.setCount(0);
					setMinorState(minorLight.goRed());
					setMinorLightStatus(3);
					
				}
				else
				{
					setMinorState(minorLight.goLeftTurn());
					setMinorLightStatus(4);
				}
			}
			else
			{
				setMinorState(minorLight.goGreen());
				setMinorLightStatus(1);
			}
			break;
		case 1:
			if (getMainState() == 5)
			{
				setMinorState(minorLight.goRed());
				minorLight.setCount(0);
				setMinorLightStatus(3);
			}
			else if (minorLight.getCount() < 55)
			{
				setMinorState(minorLight.goGreen());
				setMinorLightStatus(1);
			}
			else
			{
				minorLight.setCount(0);
				setMinorState(minorLight.goYellow());
				setMinorLightStatus(2);
			}
			break;
		}



	}


	/**
	 * @see TrafficLightController#controlmainLight(int)
	 */
	public void controlMainLight(int mainPedLightStatus) {
		
		switch (getMainState())
		{
		case 1:
			if (mainPedLightStatus == 0 && getMinorRoadTraffic() == false)
			{
				 setMainState(mainLight.goGreen());
				 setMainLightStatus(1);
//				 if (mainLight.getCount() == 60)
//				 {
//					 setMainState(mainLight.goYellow());
//					 mainLight.setCounter(0);
//					 setMainLightStatus(2);
//				 }

			}
			else if ((mainPedLightStatus == 1 || getMinorRoadTraffic() == true) && mainLight.getCount() >= 60)
			{
				setMainState(mainLight.goYellow());
				mainLight.setCounter(0);
				setMainLightStatus(2);
			}
			else if ((mainPedLightStatus == 1 && mainLight.getCount() < 60) || (getMinorRoadTraffic() == true && mainLight.getCount() < 60))
			{
				setMainState(mainLight.goPending());
				setMainLightStatus(1);
			}
			break;
			
		case 3:
			if (mainLight.getCount() < 5)
			{
				setMainState(mainLight.goYellow());
				setMainLightStatus(2);
			}
			else
			{
				setMainState(mainLight.goRed());
				setMainLightStatus(3);
				mainLight.setCounter(0);			
			}
			break;
			
		case 4:
			if (mainLight.getCount() < 60 && getMainLeftTurnTraffic() == false)
			{
//				System.out.println( getBeCarLeftLine());
				setMainState(mainLight.goRed());
				setMainLightStatus(3);
			}
			else if (getMainLeftTurnTraffic() == true)
			{
				setMainState(mainLight.goLeftTurn());
				mainLight.setCounter(0);
				setMainLightStatus(4);
			}
			else if (getMainLeftTurnTraffic() == false)
			{
				setMainState(mainLight.goGreen());
				setMainLightStatus(1);
			}
			break;
			
		case 5:
			if (mainLight.getCount() < 10)
			{
				setMainState(mainLight.goLeftTurn());
				setMainLightStatus(4);
			}
			else
			{
				setMainState(mainLight.goGreen());
				setMainLightStatus(1);
			}
			break;	
		case 2:
			if (mainLight.getCount() < 60)
			{
				setMainState(mainLight.goPending());
				setMainLightStatus(1);
			}
			else
			{
				mainLight.setCounter(0);
				setMainState(mainLight.goYellow());
				setMainLightStatus(2);
			}
		}
	}


	}


