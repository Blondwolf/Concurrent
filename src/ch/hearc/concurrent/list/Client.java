
package ch.hearc.concurrent.list;

import ch.hearc.concurrent.list.librairie.Librairie_I;

public class Client implements Runnable
	{

	public Client(Librairie_I lib)
		{
		this.lib = lib;
		}

	@Override
	public void run()
		{
		while(true)
			{
			//get a random number
			//get the book in lib with number
			//show the book name
			}
		}

	private void getBook(Book book)
		{
		//lib.getBook(book);
		}

	Librairie_I lib;

	}
