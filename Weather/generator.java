package Weather;

import java.util.concurrent.ThreadLocalRandom;
import AvajConfig.opts;

public class generator {
	public static String getWeather(int lng, int lat, int height) {
		opts.snowperc = (((24f/101f)/3f)*100f)*2f;
		opts.sunperc = (((24f/101f)/3f)*100f)*2f+(((25f/101f)/2f)*100f);
		opts.rainperc = (((24f/101f)/3f)*100f)*3f;
		opts.fogperc = (((24f/101f)/3f)*100f)*2f+(((25f/101f)/2f)*100f);
		if(height < 25 && height >= 0){
			return Section1(lng, lat, height);
		}else if(height >= 25 && height < 50){
			return Section2(lng, lat, height);
		}else if(height >= 50 && height < 75){
			return Section3(lng, lat, height);
		}else if(height >= 75 && height <= 100){
			return Section4(lng, lat, height);
		}else{
			System.err.format("Error Generating Weather%n");
			return "";
		}
	}

	//
	// Sections
	//
	// Each Section Refers To A 25 Digit Block in The Height Coordinate
	// Section1 Starting from 0 to 24 and Section2 from 25 to 49 etc.
	//
	private static float snow = (((24f/101f)/3f)*100f)*2f;
	private static float rain = (((24f/101f)/3f)*100f)*3f;
	private static float fog = (((24f/101f)/3f)*100f)*2f+(((25f/101f)/2f)*100f);
	private static float sun = (((24f/101f)/3f)*100f)*2f+(((25f/101f)/2f)*100f);
	
	private static String Section1(int lng, int lat, int height) {
		int weth = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		if(weth == 1){
			logChance(snow, "Snow");
			return("SNOW");
		}else if(weth == 2){
			logChance(rain, "Rain");
			return("RAIN");
		}else{
			logChance(fog, "Fog");
			return("FOG");
		}
	}
	private static String Section2(int lng, int lat, int height) {
		int weth = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		if(weth == 1){
			logChance(snow, "Snow");
			return("SNOW");
		}else if(weth == 2){
			logChance(rain, "Rain");
			return("RAIN");
		}else{
			logChance(sun, "Sun");
			return("SUN");
		}
	}
	private static String Section3(int lng, int lat, int height) {
		int weth = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		if(weth == 1){
			logChance(sun, "Sun");
			return("SUN");
		}else if(weth == 2){
			logChance(rain, "Rain");
			return("RAIN");
		}else{
			logChance(fog, "Fog");
			return("FOG");
		}
	}
	private static String Section4(int lng, int lat, int height) {
		int weth = ThreadLocalRandom.current().nextInt(1, 2 + 1);
		if(weth == 1){
			logChance(sun, "Sun");
			return("SUN");
		}else{
			logChance(fog, "Fog");
			return("FOG");
		}
	}
	private static void logChance(float chance, String Weather) {
		if(AvajConfig.opts.logWeathChancesToTerm == true){
			System.out.printf("Chance Of %s Was %.2f%%%n",Weather, chance);
		}
	}
}