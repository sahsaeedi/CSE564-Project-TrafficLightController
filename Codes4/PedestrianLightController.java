package Codes4;

public interface PedestrianLightController {

	public abstract void controllerMainPedLight(int minorLeftTurnSignal, int mainLightSignal, int mainLightCount, boolean mainPedButton);

	public abstract void controllerMinorPedLight(int mainLeftTurnSignal, int mainLightSignal, int mainLightCount, boolean minorPedButton);

}
