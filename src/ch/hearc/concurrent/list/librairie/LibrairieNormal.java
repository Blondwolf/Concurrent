
package ch.hearc.concurrent.list.librairie;

import java.util.HashMap;
import java.util.Set;

public class LibrairieNormal extends Librairie_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public LibrairieNormal()
		{
		super();
		this.booksCount = new HashMap<String, Integer>();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void addBookChild(String book, int value)
		{
		if (booksCount.containsKey(book))
			{
			int count = booksCount.get(book);
			booksCount.replace(book, count + value);
			}
		else
			{
			booksCount.put(book, value);
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	@Override
	public Set<String> getBookListChild()
		{
		return booksCount.keySet();
		}

	@Override
	public int getBookCount(String book)
		{
		return booksCount.get(book).intValue();
		}

	@Override
	public String getBookChild(String book)
		{
		addBookChild(book, -1);
		if (booksCount.get(book) == 0)
			{
			booksCount.remove(book);
			}
		return book;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private HashMap<String, Integer> booksCount;
	}
