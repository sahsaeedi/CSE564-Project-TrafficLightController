package Codes4;

public class MainPedestrianLight implements PedestrianLightController {

	private int count = 0;

	private int state = 1;

	private boolean mainPedestrianLight;
	
	private boolean mainRoadPedestrian;

	public int getCount() {
		return count;
	}

	public int getState() {
		return state;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public boolean getMainPedestrianLight() {
		return mainPedestrianLight;
	}
	public boolean getMainRoadPedestrian() {
		return mainRoadPedestrian;
	}

	public void setMainPedestrianLight(boolean mainPedestrianLight) {
		this.mainPedestrianLight = mainPedestrianLight;
	}
	
	public void setMainRoadPedestrian(boolean mainRoadPedestrian) {
		this.mainRoadPedestrian = mainRoadPedestrian;
	}

	public void outputState(boolean mainPedButton) {
		if (getState() == 3)
			setMainPedestrianLight(true);
		else
			setMainPedestrianLight(false);
		
		setMainRoadPedestrian(mainPedButton);
		
	}

	public void changeState(int minorLeftTurnSignal, int mainLightSignal, int mainLightCount, boolean mainPedButton) {
		if (getState() == 1)
		{
			if (mainPedButton == true)
				setMainRoadPedestrian(true);
				setState(2);
		}
		else if (getState() == 2)
		{
			if (mainLightSignal == 1 && minorLeftTurnSignal == 0 && mainLightCount >= 20)
				setState(3);
		}
		else if (getState() == 3)
		{
			if (getCount() < 20)
				count++;
			else
			{
				setState(1);
				setCount(0);
			}
		}

	}




	/**
	 * @see PedestrianLightController#controllerMainPedLight(int, boolean, boolean)
	 */
	public void controllerMainPedLight(int minorLeftTurnSignal, int mainLightSignal, int mainLightCount, boolean mainPedButton) {
		outputState(mainPedButton);
		changeState(minorLeftTurnSignal, mainLightSignal, mainLightCount, mainPedButton);
	}


	/**
	 * @see PedestrianLightController#controllerMinorPedLight(int, boolean, boolean)
	 */
	public void controllerMinorPedLight(int mainLeftTurnSignal, int mainLightSignal, int mainLightCount, boolean minorPedButton) {

	}

}
