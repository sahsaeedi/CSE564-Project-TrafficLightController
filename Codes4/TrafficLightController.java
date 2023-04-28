package Codes4;

public interface TrafficLightController {

	public abstract void controllerMainLight(boolean mainRoadPedestrian, boolean minorRoadTraffic, int minorLightSignal, boolean mainLeftTurnTraffic);

	public abstract void controllerMinorLight(boolean minorLeftTurnTraffic, int mainLightSignal);

}
