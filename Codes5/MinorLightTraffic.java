package Codes4;

public class MinorLightTraffic implements TrafficLightController {

	private int count = 0;

	private int state = 3;

	private int minorRoadLight;
	
	private int minorLightSignal;
	
	private int minorLeftTurnSignal;

	public int getCount() {
		return count;
	}

	public int getState() {
		return state;
	}

	public int getMinorRoadLight() {
		return minorRoadLight;
	}
	
	public int getMinorLightSignal() {
		return minorLightSignal;
	}
	public int getMinorLeftTurnSignal() {
		return minorLeftTurnSignal;
	}

	public void setCount(int count) {
		this.count = count;

	}

	public void setState(int state) {
		this.state = state;

	}

	public void setMinorRoadLight(int minorRoadLight) {
		this.minorRoadLight = minorRoadLight;

	}
	
	public void setMinorLeftTurnSignal(int minorLeftTurnSignal) {
		this.minorLeftTurnSignal = minorLeftTurnSignal;

	}
	
	public void setMinorLightSignal(int minorLightSignal) {
		this.minorLightSignal = minorLightSignal;

	}

	public void outputState() {
		setMinorRoadLight(getState());
		
		if (getState() == 3)
			setMinorLightSignal(1);
		else
			setMinorLightSignal(0);
		
		if (getState() == 4)
			setMinorLeftTurnSignal(1);
		else
			setMinorLeftTurnSignal(0);
		

	}

	public void changeState(boolean minorLeftTurnTraffic, int mainLightSignal) {
		if (getState() == 3)
		{
//			System.out.println(mainLightSignal);
			if (mainLightSignal == 1)
			{
				if (minorLeftTurnTraffic == true)
					setState(4);
				else
					setState(1);
				count++;
			}


		}
		else if (getState() == 4)
		{
			if (getCount() >= 10)
				setState(1);
			count++;
		}
		else if (getState() == 1)
		{
				
			if (getCount() < 55)
				count++;
			else
			{
				setCount(0);
				setState(2);
			}
		}
		else
		{
			if (getCount() < 5)
				count++;
			else
			{
				setState(3);
				setCount(0);
			}
		}
		

	}


	/**
	 * @see TrafficLightController#controllerMainLight(boolean)
	 */
	public void controllerMainLight(boolean mainRoadPedestrian, boolean minorRoadTraffic, int minorLightSignal, boolean mainLeftTurnTraffic) {
//		return 0;
	}


	/**
	 * @see TrafficLightController#controllerMinorLight(int)
	 */
	public void controllerMinorLight(boolean minorLeftTurnTraffic, int mainLightSignal) {
		outputState();
		changeState(minorLeftTurnTraffic, mainLightSignal);

	}
	

}
