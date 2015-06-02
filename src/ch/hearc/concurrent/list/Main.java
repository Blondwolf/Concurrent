
package ch.hearc.concurrent.list;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ch.hearc.concurrent.list.librairie.LibrairieNormal;
import ch.hearc.concurrent.list.librairie.LibrairieThreadSafe;
import ch.hearc.concurrent.list.librairie.Librairie_A;

public class Main
	{

	static List<Thread> listThreads;

	public static void main(String[] args)
		{
		int mode = askMode();
		init(mode);
		startActors();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static int askMode()
		{
		JFrame frame = new JFrame("Fen�tre principal non visible");
		int mode = JOptionPane.showConfirmDialog(frame, "Ce programme va simuler la gestion d'une librairie.\nVoulez-vous utiliser la librairie java?", "Choix du mode", JOptionPane.YES_NO_OPTION);

		return mode;
		}

	private static void init(int mode)
		{
		Librairie_A lib;

		if (mode == 0)
			{
			lib = new LibrairieNormal();
			}
		else
			{
			lib = new LibrairieThreadSafe();
			}

		listThreads = new ArrayList<Thread>();

		listThreads.add(new Thread(new Client(lib, 1, 2)));
		listThreads.add(new Thread(new Fournisseur(lib, 10, 20)));
		}

	private static void startActors()
		{
		for(Thread thread:listThreads)
			{
			thread.start();
			}
		}
	}
