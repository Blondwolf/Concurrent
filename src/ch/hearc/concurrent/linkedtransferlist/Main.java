
package ch.hearc.concurrent.linkedtransferlist;

import java.util.ArrayList;
import java.util.List;

import ch.hearc.concurrent.tools.Tools;

public class Main
	{

	public static void main(String[] args)
		{
		//Créations des postes
		final String destinations[] = { "Bienne", "Neuchâtel", "Lausanne", "France" };
		final List<Poste> postes = new ArrayList<Poste>();
		final List<Thread> threadPostes = new ArrayList<Thread>();

		for(int i = 0; i < destinations.length; i++)
			{
			postes.add(new Poste(destinations[i], i));
			}

		//Liaisons des postes et lancement
		for(int i = 0; i < postes.size() - 1; i++)
			{
			postes.get(i).setNextChain(postes.get(i + 1));

			Thread thread = new Thread(postes.get(i));
			threadPostes.add(thread);
			thread.start();
			}

		//Lancement du producteur de colis
		Thread threadFournisseur = new Thread(new Runnable()
			{

				int iterations = 2; //10 colis en tout

				@Override
				public void run()
					{
					while(true)
						{
						if (iterations > 0)
							{
							//Génération du colis
							//int index = Tools.randInt(0, destinations.length - 1);
							Colis colis = new Colis(destinations[destinations.length - 1]); //Tjr vers dernier

							//Envoi du colis vers premier
							System.out.println("Envoi du colis pour: " + colis.getVille());
							postes.get(0).send(colis);

							//Patiente et affiche
							iterations--;
							}

						Tools.sleep(1*1000);

						/*for(Thread thread:threadPostes)
						{
						thread.stop();
						}*/
						}
					}
			});
		threadFournisseur.start();
		}
	}
