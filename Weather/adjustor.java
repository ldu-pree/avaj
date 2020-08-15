package Weather;

import AvajConfig.lib;
import Flyables.*;

public class adjustor {
	static String type1 = "JetPlane";
	static String type2 = "Helicopter";
	static String type3 = "Baloon";
	public static void snow(Aircraft thing) {
		if(thing.type.equals(type1)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): Bloody Snow I Wanna Fly!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): Bloody Snow I Wanna Fly!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.heightDown(7, thing);
		}else if(thing.type.equals(type2)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): Might Have To Land If The Snow Continues!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): Might Have To Land If The Snow Continues!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.heightDown(12, thing);
		}else if(thing.type.equals(type3)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): Might Have To Land If The Snow Continues!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): Might Have To Land If The Snow Continues!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.heightDown(15, thing);
		}
	}
	public static void sun(Aircraft thing) {
		if(thing.type.equals(type1)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): Beautiful Weather Go Faster And Higher I Am Speed!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): Beautiful Weather Go Faster And Higher I Am Speed!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.heightUp(2, thing);
			thing.coords.latUp(10, thing);
		}else if(thing.type.equals(type2)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): I Believe I Can Fly!!! Sunny Helicopter Tours Are Best!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): I Believe I Can Fly!!! Sunny Helicopter Tours Are Best%n", thing.type, thing.name, thing.uniID);}
			thing.coords.heightUp(2, thing);
			thing.coords.lngUp(10, thing);
		}else if(thing.type.equals(type3)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): Great Weather But The Baloon Doesn't Have Shade\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): Great Weather But The Baloon Doesn't Have Shade%n", thing.type, thing.name, thing.uniID);}
			thing.coords.heightUp(4, thing);
			thing.coords.lngUp(2, thing);
		}
	}
	public static void rain(Aircraft thing) {
		if(thing.type.equals(type1)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): I Don't Mind The Rain That Much i Am Too Fast For It!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): I Don't Mind The Rain That Much i Am Too Fast For It!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.latUp(5, thing);
		}else if(thing.type.equals(type2)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): The Rotors Make The Rain Even Worse!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): The Rotors Make The Rain Even Worse!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.lngUp(5, thing);
		}else if(thing.type.equals(type3)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): Luckily The Big Baloon Stops The Rain!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): Luckily The Big Baloon Stops The Rain!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.heightDown(5, thing);
		}
	}
	public static void fog(Aircraft thing) {
		if(thing.type.equals(type1)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): Can't See Anything Need To Slow Down!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): Can't See Anything Need To Slow Down!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.latUp(1, thing);
		}else if(thing.type.equals(type2)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): Have To Be Careful The Fog Is Making It Hard To See The Ground!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): Have To Be Careful The Fog Is Making It Hard To See The Ground!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.lngUp(1, thing);
		}else if(thing.type.equals(type3)){
			lib.writeF(thing.type+"#"+thing.name+"("+thing.uniID+"): Gonna Go Lower Can't See Anything In This Fog!!!\n");
			if(AvajConfig.opts.logToTerm == true){System.out.printf("%s#%s(%d): Gonna Go Lower Can't See Anything In This Fog!!!%n", thing.type, thing.name, thing.uniID);}
			thing.coords.heightDown(3, thing);
		}
	}
}