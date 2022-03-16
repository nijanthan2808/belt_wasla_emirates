package com.beltWasla.utils;

public class UtilThread {
	
	public static void sleep(long time) {
		//To give the sleep time to make the excution wait for specified seconds
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}

}
