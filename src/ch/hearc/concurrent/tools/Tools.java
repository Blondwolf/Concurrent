
package ch.hearc.concurrent.tools;

import java.util.Random;

public final class Tools
	{

	public static void sleep(int delayMS) {
		try
			{
			Thread.sleep(delayMS);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
	}

	public static int randInt(int min, int max)
		{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
		}
	}
