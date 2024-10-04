package com.bayramgoze.services;

import java.security.SecureRandom;

public class TicketUtils {
	public static String GeneratePnr() {
		  String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		  int PNR_LENGTH = 6;
		  SecureRandom random = new SecureRandom();
		  StringBuilder pnr = new StringBuilder(PNR_LENGTH);
		  for (int i = 0; i < PNR_LENGTH; i++) {
		            int randomIndex = random.nextInt(CHARACTERS.length());
		            pnr.append(CHARACTERS.charAt(randomIndex));
		        }

		        return pnr.toString();	 
	}
}

	