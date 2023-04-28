package Codes4;

public class MainLightTraffic implements TrafficLightController {

	private int count = 0;

	private int state = 1;

	private int mainRoadLight;
	
	private int mainLightSignal;
	
	private int mainLeftTurnSignal;
	
	private int tempMainLightCount;
	
//	private boolean p1, mr, ml;
//	
//	private int l2;
//	
//	public MainLightTraffic(boolean p1, boolean mr, int l2, boolean ml)
//	{
//		this.p1 = p1; 
//		this.mr = mr;
//		this.l2 = l2;
//		this.ml = ml;
//	}

	public int getTempMainLightCount() {
		return tempMainLightCount;
	}

	public void setTempMainLightCount(int tempMainLightCount) {
		this.tempMainLightCount = tempMainLightCount;
	}

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

	public int getMainRoadLight() {
		return mainRoadLight;
	}
	
	public int getMainLeftTurnSignal() {
		return mainLeftTurnSignal;
	}
	
	
	public int getMainLightSignal() {
		return mainLightSignal;
	}

	public void setMainRoadLight(int mainRoadLight) {
		this.mainRoadLight = mainRoadLight;

	}
	
	public void setMainLightSignal(int mainLightSignal) {
		this.mainLightSignal = mainLightSignal;

	}
	
	public void setMainLeftTurnSignal(int mainLeftTurnSignal) {
		this.mainLeftTurnSignal = mainLeftTurnSignal;

	}
	
	public void outputState() {
		if (getState() == 1 || getState() == 2)
			setMainRoadLight(1);
		else if (getState() == 3)
			setMainRoadLight(2);
		else if (getState() == 4)
			setMainRoadLight(3);
		else
			setMainRoadLight(4);
		
		if (getState() == 4)
			setMainLightSignal(1);
		else
			setMainLightSignal(0);
		tempMainLightCount = getCount();
		
		if (getState() == 5)
			setMainLeftTurnSignal(1);
		else
			setMainLeftTurnSignal(0);

	}

	public void changeState(boolean mainRoadPedestrian, boolean minorRoadTraffic, int minorLightSignal, boolean mainLeftTurnTraffic) {

		if (getState() == 1)
		{
			if (minorRoadTraffic == false && mainRoadPedestrian == false)
				count++;
			else if (getCount() < 60)
			{
				setState(2);
				count++;
			}
			else
			{
				setState(3);
				setCount(0);
			}
//			if (minorLightSignal == 0)
//				setState(4);
//				
		}
		else if (getState() == 2)
		{
			
			if (getCount() < 60)
				count++;
			else
			{
				setState(3);
				setCount(0);
			}
				
		}
		else if (getState() == 3)
		{
			if (getCount() < 5)
				count++;
			else
			{
				setState(4);
				setCount(0);
			}
		}
		else if (getState() == 4)
		{
			if (minorLightSignal == 0)
				count++;
			else
			{
				if (mainLeftTurnTraffic == false)
					setState(1);
				else
					setState(5);
				setCount(0);
			}
		}
		else
		{
			if (getCount() >= 10)
				setState(1);
			count++;	
		}
		
		

	}




	/**
	 * @see TrafficLightController#controllerMainLight(boolean)
	 */
	public void controllerMainLight(boolean mainRoadPedestrian, boolean minorRoadTraffic, int minorLightSignal, boolean mainLeftTurnTraffic) {
		outputState();
		changeState(mainRoadPedestrian, minorRoadTraffic, minorLightSignal, mainLeftTurnTraffic);
//		return getMainRoadLight();
	}


	/**
	 * @see TrafficLightController#controllerMinorLight(int)
	 */
	public void controllerMinorLight(boolean minorLeftTurnTraffic, int mainLightSignal) {

	}


}
