package TrafficLightController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MinorPedLightSensor implements Runnable{

	private ArrayList<Boolean> minorPedestrianButton = new ArrayList<Boolean>();
	
	private String PATH;
	
	private BufferedReader br;
	
	
	public MinorPedLightSensor(String PATH)
	{
		this.PATH = PATH;
	}

	public ArrayList<Boolean> getMinorPedestrianButton() {
		return minorPedestrianButton;
	}

	public void setMinorPedestrianButton(ArrayList<Boolean> minorPedestrianButton) {
		this.minorPedestrianButton = minorPedestrianButton;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		    String line = "";
		    String splitBy = ",";
			br = new BufferedReader(new FileReader(PATH));
			while ((line = br.readLine()) != null) 
			{
				String[] inputs = line.split(splitBy);
				minorPedestrianButton.add((Boolean.parseBoolean(inputs[4])));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		setList(allLines);
		
	}


}
