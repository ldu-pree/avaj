package Flyables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import AvajConfig.lib;
/**
 * Factory
 */
public class Factory {
	public static Aircraft[] flyables = new Aircraft[4];
	public static List<Aircraft> allAircraft = new ArrayList<>();

	public static void Create() {
		for (int i = 0; i < 4; i++) {
			flyables[i] = new Aircraft();
			flyables[i].type = "plane";
			flyables[i].name = "test"+i;
			int randomNum1 = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
			flyables[i].coords.height = randomNum1;
			int randomNum2 = ThreadLocalRandom.current().nextInt(-10000, 10000 + 1);
			flyables[i].coords.latitude = randomNum2;
			int randomNum3 = ThreadLocalRandom.current().nextInt(-10000, 10000 + 1);
			flyables[i].coords.longitude = randomNum3;
		}
	}
	public static void addAircraft(int id, String type, String name, int longitude, int latitude, int height) {
		Aircraft newflyable = new Aircraft();
		newflyable.uniID = id;
		newflyable.active = true;
		newflyable.name = name;
		newflyable.type = type;
		newflyable.coords.latitude = latitude;
		newflyable.coords.longitude = longitude;
		newflyable.coords.height = height;
		allAircraft.add(newflyable);
		lib.writeF("Tower says: "+type+"#"+name+"("+id+") registered to weather tower.\n");
		if(AvajConfig.opts.logRegToTerm == true){System.out.printf("Tower says: %s#%s(%d) registered to weather tower.%n", type, name, id);}
	}
	public static void unregisterAircraft(int id) {
		lib.writeF("Tower says: "+allAircraft.get(id-1).type+"#"+allAircraft.get(id-1).name+"("+id+") unregistered from weather tower.\n");
		if(AvajConfig.opts.logRegToTerm == true){System.out.printf("Tower says: %s#%s(%d) unregistered from weather tower.%n", allAircraft.get(id-1).type, allAircraft.get(id-1).name, id);}
		allAircraft.get(id-1).active = false;
	}
}