package Codes2;

import java.io. * ;

public class Controller {

	public static void main(String args[]) throws FileNotFoundException {
//		System.out.println("Hello");
		TrafficLights trafficLights = new TrafficLights();
		PedestrianLights pedestrianLights = new PedestrianLights(); 
		Camera camera = new Camera();
		PedLightTwoSensor pedTwoSensor = new PedLightTwoSensor();
		PedLightOneSensor pedOneSensor = new PedLightOneSensor();
		
	    String line = "";
	    String splitBy = ",";
	    try {
	    	int i = 0;
	      //parsing a CSV file into BufferedReader class constructor  
	      BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\eclipse-workspace\\CSE564-Project\\TrafficLightController\\src\\Codes2\\data.csv"));
	      while ((line = br.readLine()) != null)  
	      {
	    	  System.out.println("Iteration: " + i);
	    	  String[] inputs = line.split(splitBy);
	    	  
	    	  camera.setCarLeftLine(Boolean.parseBoolean(inputs[0]));
//	    	  System.out.println("camera: " + camera.getCarLeftLine());
	    	  camera.setCarLeftLineTwo(Boolean.parseBoolean(inputs[1]));
	    	  camera.setCarRightSide(Boolean.parseBoolean(inputs[2]));
	    	  pedOneSensor.setPushPedestrian(Boolean.parseBoolean(inputs[3]));
	    	  pedTwoSensor.setPushPedestrian(Boolean.parseBoolean(inputs[4]));
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  trafficLights.setBeCarLeftLine(camera.getCarLeftLine());
//	    	  System.out.println("input : " + camera.getCarLeftLine());
	    	  trafficLights.setBeCarLeftLineTwo(camera.getCarLeftLineTwo());
	    	  trafficLights.setBeCarRightSide(camera.getCarRightSide());
	    	  pedestrianLights.setBePedOne(pedOneSensor.getPushPedestrian());
	    	  pedestrianLights.setBePedTwo(pedTwoSensor.getPushPedestrian());
			
			  trafficLights.controlLightOne(pedestrianLights.getPedLighOneStatus());
			  trafficLights.controlLightTwo();
				
				
			  pedestrianLights.controlPedLightOne(trafficLights.getLightOneStatus());
			  pedestrianLights.controlPedLightTwo(trafficLights.getLightOneStatus());
			
			System.out.println("Main light: " + trafficLights.getLightOneStatus() + " || Minor light: " + trafficLights.getLightTwoStatus() + " || Main Ped light: " + pedestrianLights.getPedLighOneStatus() + " || Minor Ped light: " + pedestrianLights.getPedLightTwoStatus());
			System.out.println("-----------------------------------------------------------------------------------");
		  
		      i++;}
		    }
		    catch(IOException e) {
		      e.printStackTrace();
		    }
		
//		}

//		System.out.println();
		

	}

	public void readInput() {

	}

}
