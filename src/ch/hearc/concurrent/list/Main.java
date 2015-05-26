
package ch.hearc.concurrent.list;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ch.hearc.concurrent.list.librairie.LibrairieNormal;
import ch.hearc.concurrent.list.librairie.LibrairieThreadSafe;
import ch.hearc.concurrent.list.librairie.Librairie_I;

public class Main
	{

	static List<Thread> listThreads;

	public static void main(String[] args)
		{
		int mode = askMode();
		init(mode);
		startActors();
		}

	private static int askMode()
		{
		JFrame frame = new JFrame("Fenêtre principal non visible");
		int mode = JOptionPane.showConfirmDialog(frame, "Ce programme va simuler la gestion d'une librairie.\nVoulez-vous utiliser la librairie java?", "Choix du mode", JOptionPane.YES_NO_OPTION);

		return mode;
		}

	private static void init(int mode)
		{
		Librairie_I lib;

		if (mode == 0)
			{
			lib = new LibrairieNormal();
			}
		else
			{
			lib = new LibrairieThreadSafe();
			}

		listThreads = new ArrayList<Thread>();

		listThreads.add(new Thread(new Client(lib)));
		listThreads.add(new Thread(new Fournisseur(lib)));
		}

	private static void startActors()
		{
		for(Thread thread:listThreads)
			{
			thread.start();
			}
		}
	}
