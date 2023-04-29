package TrafficLightController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainPedLightSensor implements Runnable{

	private ArrayList<Boolean>  mainPedestrianButton = new ArrayList<Boolean>();
	
	private String PATH;
	
	private BufferedReader br;
	
	public MainPedLightSensor(String PATH)
	{
		this.PATH = PATH;
	}

	public ArrayList<Boolean>  getMainPedestrianButton() {
		return mainPedestrianButton;
	}

	public void setMainPedestrianButton(ArrayList<Boolean> mainPedestrianButton) {
		this.mainPedestrianButton = mainPedestrianButton;
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
				mainPedestrianButton.add((Boolean.parseBoolean(inputs[3])));
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
