
package ch.hearc.concurrent.hashconcurrentmap;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ch.hearc.concurrent.hashconcurrentmap.librairie.LibrairieThreadSafe;
import ch.hearc.concurrent.hashconcurrentmap.librairie.Librairie_A;

public class Main
	{

	static List<Thread> listThreads;

	public static void main(String[] args)
		{
		//int mode = askMode();
		init(1);
		startActors();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static int askMode()
		{
		JFrame frame = new JFrame("Fenêtre principal non visible");
		int mode = JOptionPane.showConfirmDialog(frame, "Ce programme va simuler la gestion d'une librairie.\nVoulez-vous utiliser la librairie java?", "Choix du mode", JOptionPane.YES_NO_OPTION);

		return mode;
		}

	private static void init(int mode)
		{
		Librairie_A lib;
		lib = new LibrairieThreadSafe();

		listThreads = new ArrayList<Thread>();

		listThreads.add(new Thread(new Client(lib, 1, 2)));
		listThreads.add(new Thread(new Fournisseur(lib, 2, 10)));
		}

	private static void startActors()
		{
		for(Thread thread:listThreads)
			{
			thread.start();
			}
		}
	}
