package TrafficLightController;

public class PedestrianLights implements PedestrainLightController {

	private int mainPedLightStatus = 0;

	private int minorPedLightStatus = 0;

	private boolean mainPedButton;

	private boolean minorPedButton;

	MainPedestrianLight mainPedLight = new MainPedestrianLight();
	
	MinorPedestrianLight minorPedLight = new MinorPedestrianLight();

	private int mainState = 1;

	private int minorState = 1;



	public int getMainPedLightStatus() {
		return mainPedLightStatus;
	}


	public void setMainPedLightStatus(int mainPedLightStatus) {
		this.mainPedLightStatus = mainPedLightStatus;
	}


	public int getMinorPedLightStatus() {
		return minorPedLightStatus;
	}


	public void setMinorPedLightStatus(int minorPedLightStatus) {
		this.minorPedLightStatus = minorPedLightStatus;
	}


	public boolean getMainPedButton() {
		return mainPedButton;
	}


	public void setMainPedButton(boolean mainPedButton) {
		this.mainPedButton = mainPedButton;
	}


	public boolean getMinorPedButton() {
		return minorPedButton;
	}


	public void setMinorPedButton(boolean minorPedButton) {
		this.minorPedButton = minorPedButton;
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
	 * @see PedestrainLightController#controlPedLightOne(int)
	 */
	public void controlMainPedLight(int mainLightStatus) {
//		System.out.println(getMainState() + "   =========    " + getMainPedButton() +"\n");
		switch (getMainState())
		{
		case 1:
			if (getMainPedButton() == false)
			{
				setMainState(mainPedLight.pedestrianWaiting());
				setMainPedLightStatus(0);
			}
			else
			{
				setMainState(mainPedLight.carWaiting());
				setMainPedLightStatus(0);
			}
			break;
			
		case 2:
			if (mainLightStatus == 1)
			{
				setMainState(mainPedLight.carWaiting());
				setMainPedLightStatus(0);
			}
			else if (mainLightStatus == 3)
			{
				setMainState(mainPedLight.pedestrianCrossing());
				setMainPedLightStatus(1);
			}
			break;
			
		case 3:
			if (mainLightStatus == 3)
			{
				if (mainPedLight.getCount() < 20)
				{
					setMainState(mainPedLight.pedestrianCrossing());
					setMainPedLightStatus(1);
				}

			}
			else
			{
				setMainState(mainPedLight.pedestrianWaiting());
				setMainPedLightStatus(0);
				mainPedLight.setCount(0);
			}
			break;
		}


	}


	/**
	 * @see PedestrainLightController#controlPedLightTwo(int)
	 */
	public void controlMinorPedLight(int mainLightStatus) {
		
		switch (getMinorState())
		{
		case 3:
			if (mainLightStatus == 1 && minorPedLight.getCount() < 20)
			{
				setMinorState(minorPedLight.pedestrianCrossing());
				setMinorPedLightStatus(1);
			}
			else
			{
				setMinorState(minorPedLight.pedestrinaWaiting());
				setMinorPedLightStatus(0);
			}
			break;
		case 1:
			if (getMinorPedButton() == false)
			{
				setMinorState(minorPedLight.pedestrinaWaiting());
				setMinorPedLightStatus(0);
			}
			else
			{
				setMinorState(minorPedLight.carWaiting());
				setMinorPedLightStatus(0);
			}
			break;
		case 2:
			if (mainLightStatus == 3)
			{
				setMinorState(minorPedLight.carWaiting());
				setMinorPedLightStatus(0);
			}
			else
			{
				setMinorState(minorPedLight.pedestrianCrossing());
				setMinorPedLightStatus(1);
			}
			break;
			
		}

	}

}
