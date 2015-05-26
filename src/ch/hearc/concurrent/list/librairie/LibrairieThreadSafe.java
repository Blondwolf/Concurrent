
package ch.hearc.concurrent.list.librairie;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LibrairieThreadSafe implements Librairie_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public LibrairieThreadSafe(){
		this.booksCount = new ConcurrentHashMap<String, Integer>();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	
	public void addBook(String book, int value){
		int count = this.booksCount.get(book);
		this.booksCount.replace(book, count + value);
	}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Set<String> getBooks() {
		return booksCount.keySet();
	}
	
	public int getBookCount(String book) {
		return booksCount.get(book).intValue();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private ConcurrentHashMap<String, Integer> booksCount;

	}
