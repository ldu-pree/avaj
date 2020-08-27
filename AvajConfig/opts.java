package AvajConfig;

import java.io.FileWriter;

public class opts {
	public static FileWriter myWriter;
	public static int writtenlines;
	public static int snowcount = 0;
	public static int suncount = 0;
	public static int raincount = 0;
	public static int fogcount = 0;
	public static float snowperc;
	public static float sunperc;
	public static float rainperc;
	public static float fogperc;
	//Log The Remaining Flying Aircraft At The End
	public static boolean logCrafts = false;
	//Log The Weather For Each Aircraft
	public static boolean logWeath = false;
	//Log The Messages In Terminal For Each Aircraft
	public static boolean logToTerm = false;
	//Log The Registration In Terminal For Each Aircraft
	public static boolean logRegToTerm = true;
	//Log The Aircraft Landings
	public static boolean logLandToTerm = false;
	//Log The Nr Of Weather Changes
	public static boolean logWeathChangesToTerm = false;
	//Log The Chances Of Each Weather
	public static boolean logWeathChancesToTerm = false;
	//Log The Nr Of Lines Written Progress in Millions
	public static boolean logWrittenLinesIMToTerm = true;
	//Log The Nr Of Lines Written
	public static boolean logWrittenLinesToTerm = true;
	//Log The Nr Of Each Weather Occurence
	public static boolean logWeathChangesPerWeath = true;
}