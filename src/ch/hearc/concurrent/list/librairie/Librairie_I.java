
package ch.hearc.concurrent.list.librairie;

import java.util.Set;

public interface Librairie_I
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addBook(String book, int value);
	
	public Set<String> getBooks();
	
	public int getBookCount(String book);

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	}
