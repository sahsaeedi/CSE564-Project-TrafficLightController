package TrafficLightController;

import java.util.ArrayList;

import TrafficLightController.PedestrianLights;
import TrafficLightController.TrafficLights;
import TrafficLightController.Camera;
import TrafficLightController.MainPedLightSensor;
import TrafficLightController.MinorPedLightSensor;

public class Controller {

	private static String PATH;
	private static int TIME_STAMP;
	
	public static final String YELLOW = "\u001B[43m" + "YELLOW" + "\u001B[0m";
	public static final String RED = "\u001B[41m" + "RED" + "\u001B[0m";
	public static final String GREEN = "\u001B[42m"+ "GREEN" + "\u001B[0m";
	public static final String LEFTTURN = "\u001B[42m"+ "Left Turn Light is GREEN" + "\u001B[0m";

	public static void main(String args[]) throws Throwable {
		PATH = "C:\\Users\\HP\\eclipse-workspace\\CSE564-Project\\TrafficLightController\\src\\TrafficLightController\\data.csv";
		TIME_STAMP = 217;
		
		Camera camera=new Camera(PATH);
		MainPedLightSensor mainPedLightSensor = new MainPedLightSensor(PATH);
		MinorPedLightSensor minorPedLightSensor = new MinorPedLightSensor(PATH);
		
		TrafficLights trafficLights = new TrafficLights();
		PedestrianLights pedestrianLights = new PedestrianLights();
		
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
//		System.out.println(mainPB);
		
		for (int i = 0; i < TIME_STAMP; i++)
		{
			System.out.println("\n\n ==============   Time stamp  " + i + "    =================== \n\n");
			trafficLights.setMainLeftTurnTraffic(mainLLT.get(i));
			trafficLights.setMinorLeftTurnTraffic(minorLLT.get(i));
			trafficLights.setMinorRoadTraffic(minorRT.get(i));
			
			pedestrianLights.setMainPedButton(mainPB.get(i));
			
			pedestrianLights.setMinorPedButton(minorPB.get(i));
			
			trafficLights.controlMainLight(pedestrianLights.getMainPedLightStatus());
			trafficLights.controlMinorLight();
			
			pedestrianLights.controlMainPedLight(trafficLights.getMainLightStatus());
			pedestrianLights.controlMinorPedLight(trafficLights.getMainLightStatus());
			
			 int slo = trafficLights.getMainLightStatus();
			 int slt = trafficLights.getMinorLightStatus();
			 int plo = pedestrianLights.getMainPedLightStatus();
			 int plt = pedestrianLights.getMinorPedLightStatus();
			 
			 String o_slo = "", o_slt = "", o_plo = "", o_plt = "";
			  if (slo == 3)
				  o_slo = RED;
			  else if (slo == 1)
				  o_slo = GREEN;
			  else if (slo == 2)
				  o_slo = YELLOW;
			  else if (slo == 4)
				  o_slo = LEFTTURN;
			  
			  if (slt == 3)
				  o_slt = RED;
			  else if (slt == 1)
				  o_slt = GREEN;
			  else if (slt == 2)
				  o_slt = YELLOW;
			  else if (slt == 4)
				  o_slt = LEFTTURN;
			  
			  if (plo == 1)
				  o_plo = GREEN;
			  else
				  o_plo = RED;
			  
			  if (plt == 1)
				  o_plt = GREEN;
			  else
				  o_plt = RED;
			
			
			System.out.println("\t main road light  :  " + o_slo);		
			System.out.println("\t minor road light : " + o_slt);
			System.out.println("\t main ped light :  " + o_plo);
			System.out.println("\t minor ped light :  " + o_plt);
			
			
			
			
			
			
		}

	}



}
