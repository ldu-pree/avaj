package Flyables;

import AvajConfig.lib;
import AvajConfig.opts;

public class Coords {
	public int longitude;
	public int latitude;
	public int height;
	String type1 = "JetPlane";
	String type2 = "Helicopter";
	String type3 = "Baloon";
	public void heightUp(int diff, Aircraft thing) {
		int newH = this.height+diff;
		if(newH <= 0){
			newH = 0;
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+") Landing At Lng["+thing.coords.longitude+"]Lat["+thing.coords.latitude+"]Hgt["+newH+"].\n");
			if(opts.logLandToTerm){System.out.printf("%s#%s(%d) Landing.%n", thing.type, thing.name, thing.uniID);}
			Factory.unregisterAircraft(thing.uniID);
			return;
		}else if(newH > 100){
			newH = 100;
		}
		this.height = newH;
	}
	public void heightDown(int diff, Aircraft thing) {
		int newH = this.height-diff;
		if(newH <= 0){
			newH = 0;
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+") Landing At Lng["+thing.coords.longitude+"]Lat["+thing.coords.latitude+"]Hgt["+newH+"].\n");
			if(opts.logLandToTerm){System.out.printf("%s#%s(%d) Landing.%n", thing.type, thing.name, thing.uniID);}
			Factory.unregisterAircraft(thing.uniID);
			return;
		}else if(newH > 100){
			newH = 100;
		}
		this.height = newH;
	}
	public void latUp(int diff, Aircraft thing) {
		int newL = this.latitude+diff;
		if(newL <= 0){
			newL = 0;
		}
		this.latitude = newL;
	}
	public void latDown(int diff, Aircraft thing) {
		this.latitude = this.latitude-diff;
	}
	public void lngUp(int diff, Aircraft thing) {
		int newL = this.longitude+diff;
		if(newL <= 0){
			newL = 0;
		}
		this.longitude = newL;
	}
	public void lngDown(int diff, Aircraft thing) {
		this.longitude = this.longitude-diff;
	}
}