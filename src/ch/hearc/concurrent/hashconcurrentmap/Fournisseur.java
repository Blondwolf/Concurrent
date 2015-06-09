
package ch.hearc.concurrent.hashconcurrentmap;

import java.util.ArrayList;
import java.util.List;

import ch.hearc.concurrent.hashconcurrentmap.librairie.Librairie_A;
import ch.hearc.concurrent.tools.Tools;

public class Fournisseur extends Person implements Runnable
	{

	public Fournisseur(Librairie_A lib, int speedSecMin, int speedSecMax)
		{
		super(lib, speedSecMin, speedSecMax);

		books = new ArrayList<String>();
		books.add("La belle et la bête");
		books.add("Le chaperon rouge");
		books.add("La belle au bois dormant");
		}

	@Override
	public void run()
		{
		while(true)
			{
			//Wait from 1 to 10 sec
			Tools.sleep(Tools.randInt(speedSecMin * 1000, speedSecMax * 1000));

			//Get a random book from internal list
			String randomBook = books.get(Tools.randInt(0, books.size() - 1));

			//Add this book in lib, between 1 and 5 of same book
			int randomNumberBook = Tools.randInt(1, 5);
			lib.addBook(randomBook, randomNumberBook);
			}
		}

	private List<String> books;//Books that the fournisseur can give
	}
