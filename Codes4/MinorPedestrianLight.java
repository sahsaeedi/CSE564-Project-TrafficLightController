package Codes4;

public class MinorPedestrianLight implements PedestrianLightController {

	private int count;

	private int state = 1;

	private boolean minorPedestrianLight;

	public int getCount() {
		return count;

	}

	public int getState() {
		return state;

	}

	public boolean getMinorPedestrianLight() {
		return minorPedestrianLight;

	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setMinorPedestrianLight(boolean minorPedestrianLight) {
		this.minorPedestrianLight = minorPedestrianLight;

	}

	public void outputState() {
		if (getState() == 3)
			setMinorPedestrianLight(true);
		else
			setMinorPedestrianLight(false);
	}

	public void changeState(int mainLeftTurnSignal, int mainLightSignal, int mainLightCount, boolean minorPedButton) {
		if (getState() == 1)
		{
			if (minorPedButton == true)
				setState(2);
		}
		else if (getState() == 2)
		{
			if (mainLightSignal == 0 && mainLeftTurnSignal == 0 && mainLightSignal <= 40)
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

	}


	/**
	 * @see PedestrianLightController#controllerMinorPedLight(int, boolean, boolean)
	 */
	public void controllerMinorPedLight(int mainLeftTurnSignal, int mainLightSignal, int mainLightCount, boolean minorPedButton) {
		outputState();
		changeState(mainLeftTurnSignal, mainLightSignal, mainLightCount, minorPedButton);
	}

}
