import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import AvajConfig.opts;
import Flyables.*;
import Weather.*;

public class avaj {
	public static void main(final String[] args) {
		int count = 0;
		int weatherchanges = 0;
		final List<String> inputs = readFile(args[0]);
		weatherchanges = Integer.parseInt(inputs.get(0));
		if(opts.logWeathChangesToTerm){System.out.printf("The Weather Changed (%d) Times%n",weatherchanges);}
		if(inputs.size() > 1){
			if(weatherchanges < 1){
				System.out.println("Nr of Weather Changes Is Either 0 or Negative");
			}else{
				createFile();
				int i = 0;
				while(i < inputs.size()){
					if(inputs.get(i) == null){
						System.out.println("No Flyables or No Weather Changes");
						return;
					}
					i++;
				}
				for(int j = 0; j < inputs.size(); j++) {
					if(j > 0){
						final String[] data = inputs.get(j).split("\\s+");
						count++;
						Factory.addAircraft(count,data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
					}
				}
				final List<Aircraft> things = Factory.allAircraft;
				for (int k = 0; k < weatherchanges; k++) {
					for(int l = 0; l < things.size(); l++) {
						if(things.get(l).active == true){
							final String Weath = Weather.generator.getWeather(things.get(l).coords.longitude, things.get(l).coords.latitude, things.get(l).coords.height);
							if(opts.logWeath == true){System.out.printf("%s#%s(%d): Weather[%s]%n",things.get(l).type,things.get(l).name,things.get(l).uniID,Weath);}
							if(Weath.equals("SNOW")){
								Weather.adjustor.snow(things.get(l));
							}else if(Weath.equals("SUN")){
								Weather.adjustor.sun(things.get(l));
							}else if(Weath.equals("RAIN")){
								Weather.adjustor.rain(things.get(l));
							}else if(Weath.equals("FOG")){
								Weather.adjustor.fog(things.get(l));
							}
						}
					}
				}
				try {
					opts.myWriter.close();
				} catch (final IOException e) {
					System.out.println("An error occurred closing simulation.txt.");
					e.printStackTrace();
				}
				if(opts.logCrafts == true){
					for(int l = 0; l < things.size(); l++) {
						if(things.get(l).active == true){
							System.out.printf("%s#%s(%d): Active at[%d:%d:%d]%n",things.get(l).type,things.get(l).name,things.get(l).uniID,things.get(l).coords.longitude,things.get(l).coords.latitude,things.get(l).coords.height);
						}
					}
				}
				//for (int i = 0; i < count; i++) {
				//	System.out.println(Factory.allAircraft.get(i).name+" of type "+Factory.allAircraft.get(i).type);
				//	System.out.println("("+Factory.allAircraft.get(i).coords.longitude+":"+Factory.allAircraft.get(i).coords.latitude+") at "+Factory.allAircraft.get(i).coords.height+"m");
				//}
			}
		}else{
			System.out.println("No Flyables or No Weather Changes");
		}
	}
	static private List<String> readFile(final String filename)
	{
	  final List<String> records = new ArrayList<String>();
	  try
	  {
	    final BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	      records.add(line);
	    }
	    reader.close();
	    return records;
	  }
	  catch (final Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
	static private void createFile() {
		try {
			final File myObj = new File("simulation.txt");
			if (myObj.createNewFile()) {
			} else {
				if (myObj.delete()) { 
				  } else {
					System.out.println("simulation.txt already existed and we failed to delete it.");
				  }
			}
			opts.myWriter = new FileWriter("simulation.txt");
		} catch (final IOException e) {
			System.out.println("An error occurred creating simulation.txt.");
			e.printStackTrace();
		}
	}
}