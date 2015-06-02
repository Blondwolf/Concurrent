
package ch.hearc.concurrent.list.librairie;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LibrairieThreadSafe extends Librairie_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public LibrairieThreadSafe()
		{
		super();
		this.booksCount = new ConcurrentHashMap<String, Integer>();
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
	public String getBookChild(String book)
		{
		addBookChild(book, -1);
		if (booksCount.get(book) == 0)
			{
			booksCount.remove(book);
			}
		return book;
		}

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

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private ConcurrentHashMap<String, Integer> booksCount;

	}
