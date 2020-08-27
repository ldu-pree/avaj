package AvajConfig;

import java.io.FileWriter;
import java.io.IOException;

public class lib {
	public static void writeF(String line) {
		try {
			opts.myWriter.write(line);
			opts.writtenlines++;
			if(opts.logWrittenLinesIMToTerm == true && opts.logWeath == false && opts.logToTerm == false && opts.logLandToTerm == false && opts.logWeathChancesToTerm == false && opts.logWeathChangesToTerm == false){
				if(opts.writtenlines % 1000000 == 0){
					// try {
					// 	Thread.sleep(200);
					//  } catch (InterruptedException x) {
					//  }
					if(opts.writtenlines == 1000000){
						System.out.printf("Number Of Lines Written So Far: %d",opts.writtenlines);
					}
					System.out.print("\b");
					int len = opts.writtenlines / 1000000;
					if(len >= 1 && len <= 10){
						System.out.print("\b\b\b\b\b\b");	
					}
					if(len > 10 && len <= 100){
						System.out.print("\b\b\b\b\b\b\b");	
					}
					if(len > 100 && len <= 1000){
						System.out.print("\b\b\b\b\b\b\b\b");	
					}
					if(len > 1000 && len <= 10000){
						System.out.print("\b\b\b\b\b\b\b\b\b");	
					}
					System.out.printf("%d",opts.writtenlines);
				}
			}else if(opts.logWrittenLinesIMToTerm == true){
				if(opts.writtenlines % 1000000 == 0){
					System.out.printf("Number Of Lines Written So Far: %d%n",opts.writtenlines);
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred writing to simulation.txt.");
			e.printStackTrace();
		}
	}
}