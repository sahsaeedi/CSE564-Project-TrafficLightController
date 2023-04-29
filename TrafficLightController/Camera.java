package TrafficLightController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;


public class Camera implements Runnable{

	private ArrayList<Boolean> mainLeftTurnTraffic = new ArrayList<Boolean>();

	private ArrayList<Boolean> minorLeftTurnTraffic= new ArrayList<Boolean>();

	private ArrayList<Boolean> minorRoadTraffic= new ArrayList<Boolean>();
	
	private String PATH;
	
	private BufferedReader br;
	
	
	public Camera(String PATH) throws IOException
	{
		 this.PATH = PATH;

	}
	
	public ArrayList<Boolean> getMinorRoadTraffic() {
		return minorRoadTraffic;
	}

	public ArrayList<Boolean> getMinorLeftTurnTraffic() {
		return minorLeftTurnTraffic;
	}

	public ArrayList<Boolean> getMainLeftTurnTraffic() {
		return mainLeftTurnTraffic;
	}
	
	

	public void setMinorLeftTurnTraffic(ArrayList<Boolean> minorLeftTurnTraffic) {
		this.minorLeftTurnTraffic = minorLeftTurnTraffic;

	}

	public void setMainLeftTurnTraffic(ArrayList<Boolean> mainLeftTurnTraffic) {
		this.mainLeftTurnTraffic = mainLeftTurnTraffic;

	}

	public void setMinorRoadTraffic(ArrayList<Boolean> minorRoadTraffic) {
		this.minorRoadTraffic = minorRoadTraffic;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this) {
		try {
		    String line = "";
		    String splitBy = ",";
			br = new BufferedReader(new FileReader(PATH));
			while ((line = br.readLine()) != null) 
			{
				String[] inputs = line.split(splitBy);
				mainLeftTurnTraffic.add((Boolean.parseBoolean(inputs[0])));
				minorLeftTurnTraffic.add((Boolean.parseBoolean(inputs[1])));
				minorRoadTraffic.add((Boolean.parseBoolean(inputs[2])));
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

}
