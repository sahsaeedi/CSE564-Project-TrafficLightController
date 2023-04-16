package Codes2;

public class Controller {

	public static void main(String args[]) {
//		System.out.println("Hello");
		TrafficLights l1 = new TrafficLights();
		PedestrianLights p = new PedestrianLights(); 
		
//		for (int i = 0; i< 2; i++) {
		boolean pedOne = false;
		l1.setBeCarLeftLine(false);
		l1.setBeCarRightSide(false);
		l1.controlLightOne(pedOne);
		l1.controlLightTwo();
		p.controlPedLightOne(l1.getLightOneStatus());
		p.controlPedLightTwo(l1.getLightOneStatus());
		
		System.out.println("traffic light one " + l1.getLightOneStatus());
		System.out.println("traffic light two " + l1.getLightTwoStatus());
		System.out.println("ped light one " + p.getPedLighOneStatus());
		System.out.println("ped light two " + p.getPedLightTwoStatus());
//		}

//		System.out.println();
		

	}

	public void readInput() {

	}

}
