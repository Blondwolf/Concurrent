
package ch.hearc.concurrent.list;

import java.util.List;

import ch.hearc.concurrent.list.librairie.Librairie_I;

public class Fournisseur implements Runnable
	{

	public Fournisseur(Librairie_I lib)
		{
		this.lib = lib;

		books.add("La belle et la bête");
		books.add("Le chaperon rouge");
		}

	@Override
	public void run()
		{
		while(true)
			{
			//get a random book from internal list
			//add this book in lib
			//show book name
			}
		}

	private Librairie_I lib;
	private List<String> books;//les livres que le fournisseur peut donner
	}
