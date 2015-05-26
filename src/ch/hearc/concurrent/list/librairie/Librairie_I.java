
package ch.hearc.concurrent.list.librairie;

import java.awt.print.Book;
import java.util.Set;

public interface Librairie_I
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public Set<Book> getBooks();
	public int getBookCount(Book book);

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	}
