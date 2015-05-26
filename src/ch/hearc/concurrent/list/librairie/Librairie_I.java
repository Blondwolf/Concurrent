
package ch.hearc.concurrent.list.librairie;

import java.util.Set;

public interface Librairie_I
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addBook(String book, int value);
		
	public Set<String> getBooks();
	
	/**
	 * Return the asked book and remove it from the library
	 * @return a String which is the asked book
	 */
	public String getBook(String book);
	
	public int getBookCount(String book);

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	}
