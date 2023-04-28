package Codes4;
import java.util.ArrayList;


public class Controller{

	private static String PATH;
	private static int TIME_STAMP;
	
	
	public static void main(String[] args) throws Throwable {
		PATH = "C:\\Users\\HP\\eclipse-workspace\\CSE564-Project\\TrafficLightController\\src\\Codes4\\data.csv";
		TIME_STAMP = 200;
		Camera camera=new Camera(PATH);
		MainPedLightSensor mainPedLightSensor = new MainPedLightSensor(PATH);
		MinorPedLightSensor minorPedLightSensor = new MinorPedLightSensor(PATH);
		MainLightTraffic l1 = new MainLightTraffic(); 
		MinorLightTraffic l2 = new MinorLightTraffic();
		MainPedestrianLight p1 = new MainPedestrianLight();
		MinorPedestrianLight p2 = new MinorPedestrianLight();
		
		
		Thread cameraThread = new Thread(camera);
		Thread mainSensorThread = new Thread(mainPedLightSensor);
		Thread minorSensorThread = new Thread(minorPedLightSensor);
		
		cameraThread.start();
		cameraThread.join();
		mainSensorThread.start();
		mainSensorThread.join();
		minorSensorThread.start();
		minorSensorThread.join();
		
		ArrayList<Boolean> mainLLT = camera.getMainLeftTurnTraffic();
		ArrayList<Boolean> minorLLT = camera.getMinorLeftTurnTraffic();
		ArrayList<Boolean> minorRT = camera.getMinorRoadTraffic();
		ArrayList<Boolean> mainPB = mainPedLightSensor.getMainPedestrianButton();
		ArrayList<Boolean> minorPB = minorPedLightSensor.getMinorPedestrianButton();
		
		String mainL = "", minorL = "";

		
		for (int i = 0; i < TIME_STAMP; i++)
		{
			System.out.println("\n\n ==============   Time stamp  " + i + "    =================== \n\n");
			

//			l1.controllerMainLight(p1.getMainRoadPedestrian(), minorRT.get(i), l2.getMinorLightSignal(), mainLLT.get(i));
//			l2.controllerMinorLight(minorLLT.get(i), l1.getMainLightSignal());
//			p1.controllerMainPedLight(l2.getMinorLeftTurnSignal(), l1.getMainLightSignal(), l1.getCount(), mainPB.get(i));
//			p2.controllerMinorPedLight(l1.getMainLeftTurnSignal(), l1.getMainLightSignal(), l1.getCount(), minorPB.get(i));
			
			l1.outputState();
			l2.outputState();
			p1.outputState(mainPB.get(i));
			p2.outputState();
			
			l1.changeState(p1.getMainRoadPedestrian(), minorRT.get(i), l2.getMinorLightSignal(), mainLLT.get(i));
			l2.changeState(minorLLT.get(i), l1.getMainLightSignal());
			p1.changeState(l2.getMinorLeftTurnSignal(), l1.getMainLightSignal(), l1.getCount(), mainPB.get(i));
			p2.changeState(l1.getMainLeftTurnSignal(), l1.getMainLightSignal(), l1.getCount(), minorPB.get(i));
//			
			if (l1.getMainRoadLight() == 1)
			{
				mainL = "green";
//				minorL = "green";
			}
			if (l1.getMainRoadLight() == 2)
			{
				mainL = "yellow";
//				minorL = "yellow";
			}
			if (l1.getMainRoadLight() == 3)
			{
				mainL = "red";
//				minorL = "red";
			}
			if (l1.getMainRoadLight() == 4)
			{
				mainL = "green left turn";
//				minorL = "green left turn";
			}
			
			if (l2.getMinorRoadLight() == 1)
			{
//				mainL = "green";
				minorL = "green";
			}
			if (l2.getMinorRoadLight() == 2)
			{
//				mainL = "yellow";
				minorL = "yellow";
			}
			if (l2.getMinorRoadLight() == 3)
			{
//				mainL = "red";
				minorL = "red";
			}
			if (l2.getMinorRoadLight() == 4)
			{
//				mainL = "green left turn";
				minorL = "green left turn";
			}
			
			System.out.println("\t main road light  :  " + mainL + "\t\t Count : " + l1.getCount());		
			System.out.println("\t minor road light : " + minorL +  "\t\t Count : " + l2.getCount());
			System.out.println("\t main ped light :  " + p1.getMainPedestrianLight() +  "\t Count : " + p1.getCount());
			System.out.println("\t minor ped light :  " + p2.getMinorPedestrianLight() +  "\t Count : " + p2.getCount());

		}
		
		
				
		

	}

	public void readInput() {

	}


}
