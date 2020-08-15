package AvajConfig;

import java.io.FileWriter;

public class opts {
	public static FileWriter myWriter;
	//Log The Remaining Flying Aircraft At The End
	public static boolean logCrafts = false;
	//Log The Weather For Each Aircraft
	public static boolean logWeath = false;
	//Log The Messages In Terminal For Each Aircraft
	public static boolean logToTerm = false;
	//Log The Registration In Terminal For Each Aircraft
	public static boolean logRegToTerm = false;
	//Log The Aircraft Landings
	public static boolean logLandToTerm = false;
	//Log The Nr Of Weather Changes
	public static boolean logWeathChangesToTerm = false;
}