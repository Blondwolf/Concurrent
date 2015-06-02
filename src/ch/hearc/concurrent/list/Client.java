
package ch.hearc.concurrent.list;

import java.util.ArrayList;
import java.util.List;

import ch.hearc.concurrent.list.librairie.Librairie_A;
import ch.hearc.concurrent.list.tools.Tools;

public class Client extends Person implements Runnable
	{

	public Client(Librairie_A lib, int speedSecMin, int speedSecMax)
		{
		super(lib, speedSecMin, speedSecMax);
		this.lib = lib;
		}

	@Override
	public void run()
		{
		while(true)
			{
			//Wait from 1 to 10 sec
			Tools.sleep(Tools.randInt(speedSecMin * 1000, speedSecMax * 1000));

			//get a random book from available books in librairie
			List<String> books = new ArrayList<String>(lib.getBookList());
			if (!books.isEmpty())
				{
				String book = books.get(Tools.randInt(0, books.size()-1));

				//get the book in lib
				lib.getBook(book);
				}
			}
		}

	}
