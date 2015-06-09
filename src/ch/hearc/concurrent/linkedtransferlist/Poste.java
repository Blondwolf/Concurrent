
package ch.hearc.concurrent.linkedtransferlist;

import java.util.concurrent.LinkedTransferQueue;

import ch.hearc.concurrent.tools.Tools;

public class Poste implements Runnable
	{

	Poste(String ville, int tempsTraitementSec)
		{
		this.transfer = new LinkedTransferQueue<Colis>();
		this.ville = ville;
		this.tempsTraitementSec = tempsTraitementSec;
		}

	@Override
	public void run()
		{
		while(true)
			{
			StringBuilder builder = new StringBuilder();
			builder.append("Traitement de poste " + ville + " :");
			Colis colis;
//			try
//				{
			Tools.sleep(tempsTraitementSec * 1000); //Temps de traitement 10 sec
				colis = transfer.poll(); 				//Recupération du premier objet de la queue


				if (colis != null)
					{
					if (colis.getVille().equals(ville)) //Arrivé a destination
						{
						//transfer.take();
						builder.append("Le colis est arrivée à destination");
						}
					else								//Envoi au prochain élément
						{
						nextPost.send(colis);
						builder.append("Le colis est envoyé à "+ nextPost.ville);
						}
					}
				else
					{
					builder.append("Aucun colis pour " + ville);
					}
//				}
//			catch (InterruptedException e)
//				{
//				System.out.println("Erreur");
//				e.printStackTrace();
//				}

			System.out.println(builder.toString());
			}
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Poste [");
		builder.append(this.ville);
		builder.append("] : \n");
		for(Colis colis:transfer)
			{
			builder.append(colis.getVille());
			}
		builder.append("\nRestant :" + transfer.getWaitingConsumerCount());
		builder.append("\n");
		return builder.toString();
		}

	public void setNextChain(Poste nextPoste)
		{
		this.nextPost = nextPoste;
		}

	public void send(Colis cls)
		{
		//Reception
		transfer.put(cls);//, 5 * 1000, TimeUnit.MILLISECONDS); //Temps d'atente de transfert
		System.out.println("Réception chez "+ville+":\n");
		System.out.println(toString());
		}

	private LinkedTransferQueue<Colis> transfer;
	private int tempsTraitementSec;

	private String ville;
	private Poste nextPost;
	}
