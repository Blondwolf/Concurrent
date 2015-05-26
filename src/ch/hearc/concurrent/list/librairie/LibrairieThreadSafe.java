
package ch.hearc.concurrent.list.librairie;

import java.awt.print.Book;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LibrairieThreadSafe implements Librairie_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Set<Book> getBooks() {
		return mapBooksCounts.keySet();
	}
	
	public int getBookCount(Book book) {
		return mapBooksCounts.get(book).intValue();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private ConcurrentHashMap<Book, Integer> mapBooksCounts;

	}
