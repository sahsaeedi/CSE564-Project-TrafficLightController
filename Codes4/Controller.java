package Codes4;
import java.util.ArrayList;


public class Controller{

	private static String PATH;
	private static int TIME_STAMP;
	
	
	public static void main(String[] args) throws Throwable {
		PATH = "C:\\Users\\HP\\eclipse-workspace\\CSE564-Project\\TrafficLightController\\src\\Codes4\\data.csv";
		TIME_STAMP = 217;
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
		
		
		for (int i = 0; i < TIME_STAMP; i++)
		{
			System.out.println("==============   " + i + "    ===================");

			l1.controllerMainLight(p1.getMainRoadPedestrian(), minorRT.get(i), l2.getMinorLightSignal(), mainLLT.get(i));
			l2.controllerMinorLight(minorLLT.get(i), l1.getMainLightSignal());
			p1.controllerMainPedLight(l2.getMinorLeftTurnSignal(), l1.getMainLightSignal(), l1.getCount(), mainPB.get(i));
			p2.controllerMinorPedLight(l1.getMainLeftTurnSignal(), l1.getMainLightSignal(), l1.getCount(), minorPB.get(i));
//			
			System.out.println("main road light  ==  " + l1.getMainRoadLight());
			System.out.println("main road light state ==  " + l1.getState());
			System.out.println("main road light count ==  " + l1.getCount());
			
			System.out.println("minor road light == " + l2.getMinorRoadLight());
			System.out.println("main ped light ==  " + p1.getMainPedestrianLight());
			System.out.println("minor ped light ==  " + p2.getMinorPedestrianLight());
//			System.out.println("==============   ==============    ===================");
		}
		
		
				
		

	}

	public void readInput() {

	}


}
