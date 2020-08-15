package Weather;

import java.util.concurrent.ThreadLocalRandom;

public class generator {
	public static String getWeather(int lng, int lat, int height) {
		int weth = ThreadLocalRandom.current().nextInt(1, 4 + 1);
		if(weth == 1){
			return("SNOW");
		}else if(weth == 2){
			return "SUN";
		}else if(weth == 3){
			return "RAIN";
		}else{
			return "FOG";
		}
	}
}