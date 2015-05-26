
package ch.hearc.concurrent.list.librairie;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Set;

public class LibrairieNormal implements Librairie_I
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

	public Set<Book> getBooks() {
		return mapBooksCounts.keySet();
	}

	public int getBookCount(Book book) {
		return mapBooksCounts.get(book).intValue();
	}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private HashMap<Book, Integer> mapBooksCounts;

	}

