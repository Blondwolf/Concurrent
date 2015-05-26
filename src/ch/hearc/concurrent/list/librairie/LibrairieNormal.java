
package ch.hearc.concurrent.list.librairie;

import java.util.HashMap;
import java.util.Set;

public class LibrairieNormal implements Librairie_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public LibrairieNormal(){
		this.booksCount = new HashMap<String, Integer>();
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

	public Set<String> getBooks() {
		return booksCount.keySet();
	}

	public int getBookCount(String book) {
		return booksCount.get(book).intValue();
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
	private HashMap<String, Integer> booksCount;

	}

