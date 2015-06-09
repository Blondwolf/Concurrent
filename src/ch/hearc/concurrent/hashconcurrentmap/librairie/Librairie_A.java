
package ch.hearc.concurrent.hashconcurrentmap.librairie;

import java.util.Set;

public abstract class Librairie_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Librairie_A()
		{
		System.out.println("Ouverture de la librairie");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addBook(String book, int value)
		{
		System.out.println("Fournisseur envoi " + value + " exemplaires de " + book);
		addBookChild(book, value);
		}

	protected abstract void addBookChild(String book, int value);

	public Set<String> getBookList()
		{
		Set<String> bookSet = getBookListChild();
		if (bookSet.isEmpty())
			{
			System.out.println("Librairie vide");
			}
		return bookSet;
		}

	public abstract Set<String> getBookListChild();

	/**
	 * Return the asked book and remove it from the library
	 * @return a String which is the asked book
	 */
	public String getBook(String book)
		{
		System.out.println("Client achète " + book);
		return getBookChild(book);
		}

	protected abstract String getBookChild(String book);

	public abstract int getBookCount(String book);

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	}
