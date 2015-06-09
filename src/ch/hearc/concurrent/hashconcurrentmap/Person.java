
package ch.hearc.concurrent.hashconcurrentmap;

import ch.hearc.concurrent.hashconcurrentmap.librairie.Librairie_A;



public class Person
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Person(Librairie_A lib, int speedSecMin, int speedSecMax)
		{
		this.lib = lib;
		this.speedSecMin = speedSecMin;
		this.speedSecMax = speedSecMax;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	protected Librairie_A lib;
	protected int speedSecMin;
	protected int speedSecMax;

	}

