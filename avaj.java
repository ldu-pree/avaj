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
		if (args.length == 1){
			final List<String> inputs = readFile(args[0]);
			if(valInput(inputs)){
				weatherchanges = Integer.parseInt(inputs.get(0));
				if(opts.logWeathChangesToTerm){System.out.printf("The Weather Changed (%d) Times%n",weatherchanges);}
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
				}
			}
		} else if (args.length == 0){
			System.err.format("No File Specified");
		} else if (args.length > 1){
			System.err.format("Too Many Arguments");
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
	static private boolean valInput(List<String> lines) {
		if (lines.size() == 0){
			System.err.format("No Data In The Specified File%n");
			System.err.format("The File Should Have The Number Of Weather Changes On The First Line%n");
			System.err.format("Then A List Of Flyables Each on Their Own Line In The Format:(Type Name Lng Lat Height)%n");
            return false; 
		}
		if (lines.size() == 1){
			System.err.format("No Flyables Provided Add A Flyable With The Format (Type Name Lng Lat Height)");
            return false; 
		}
		if (lines.get(0).length() == 0){
			System.err.format("No Data In The Specified File%n");
			System.err.format("The File Should Have The Number Of Weather Changes On The First Line%n");
			System.err.format("Then A List Of Flyables Each on Their Own Line In The Format:(Type Name Lng Lat Height)%n");
            return false; 
		}
		for (int i = 0; i < lines.get(0).length(); i++) { 
            if (lines.get(0).charAt(i) >= '0'
                && lines.get(0).charAt(i) <= '9') { 
            } 
            else { 
				System.err.format("Number Of Weather Changes Must Be An Int And Bigger Than 0.");
                return false; 
            } 
		}
		for (int l = 1; l < lines.size(); l++){
			final String[] data = lines.get(l).split("\\s+");
			if (data.length < 5){
				System.err.format("Not Enough Flyable Data Provided At Line %d%n",l+1);
				System.err.format("Please Follow The Format (Type Name Lng Lat Height)");
                return false;
			}
			if (data[0].equals("Baloon") || data[0].equals("Helicopter") || data[0].equals("JetPlane")){
			} else {
				System.err.format("Invalid Flyable Type At Line %d",l+1);
                return false;
			}
			for (int i = 0; i < data[2].length(); i++) { 
				if (data[2].charAt(i) >= '0'
					&& data[2].charAt(i) <= '9') { 
				} 
				else { 
					System.err.format("Longitude Must Be An Int And Positive For %s|%s At Line %d",data[0], data[1], l+1);
					return false; 
				} 
			}
			for (int i = 0; i < data[3].length(); i++) { 
				if (data[3].charAt(i) >= '0'
					&& data[3].charAt(i) <= '9') { 
				} 
				else { 
					System.err.format("Latitude Must Be An Int And Positive For %s|%s At Line %d",data[0], data[1], l+1);
					return false; 
				} 
			}
			for (int i = 0; i < data[4].length(); i++) { 
				if (data[4].charAt(i) >= '0'
					&& data[4].charAt(i) <= '9') { 
				} 
				else { 
					System.err.format("Height Must Be An Int And Between 0 - 100 For %s|%s At Line %d",data[0], data[1], l+1);
					return false; 
				} 
			}
			if (Integer.parseInt(data[2]) < 0){
				System.err.format("Longitude Must Be An Int And Positive For %s|%s At Line %d",data[0], data[1], l+1);
				return false; 
			}
			if (Integer.parseInt(data[3]) < 0){
				System.err.format("Latitude Must Be An Int And Positive For %s|%s At Line %d",data[0], data[1], l+1);
				return false; 
			}
			if (Integer.parseInt(data[4]) < 0 || Integer.parseInt(data[4]) > 100){
				System.err.format("Height Must Be An Int And Between 0 - 100 For %s|%s At Line %d",data[0], data[1], l+1);
				return false; 
			}
		}
		return true;
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