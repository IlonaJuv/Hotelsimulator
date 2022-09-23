package simu.model;

import eduni.distributions.Negexp;
import simu.framework.Kello;
import simu.framework.Trace;

import java.util.Random;

// TODO:
// Asiakas koodataan simulointimallin edellyttämällä tavalla (data!)
public class Asiakas {
	private double saapumisaika;
	private double poistumisaika;
	private int id;
	public boolean varaus = true;
	public boolean kahvila = true;
	private static int i = 1;
	private static long sum = 0;
	private static long sum2 = 0;
	private static long sum3 = 0;

	private int kahvilaTodennakoisyys = 50;

	Negexp ngxp = new Negexp(15, 5);
	//double kokKeskiarvo;
	//double keskiarvo;
	Random rd;
	Random rd2;
	public Asiakas(){
	    id = i++;
		saapumisaika = Kello.getInstance().getAika();
		Trace.out(Trace.Level.INFO, "Uusi asiakas nro " + id + " saapui klo "+saapumisaika);

		//Mahdollisesti tänne voisi tehdä sen boolean-muuttujan varauksesta
		//onkoVaraus();
		rd = new Random();
		varaus = rd.nextBoolean();

		rd2 = new Random();
		kahvila = rd.nextBoolean();

		//meneekoKahvilaan();
	}
	public double getPoistumisaika() {
		return poistumisaika;
	}

	public void setPoistumisaika(double poistumisaika) {
		this.poistumisaika = poistumisaika;
	}

	public double getSaapumisaika() {
		return saapumisaika;
	}

	public void setSaapumisaika(double saapumisaika) {
		this.saapumisaika = saapumisaika;
	}

	public boolean meneekoKahvilaan () {
	/*	Random rnd = new Random();
	//	int chance = (int) ngxp.sample();
		int chance = rnd.nextInt(100);
		//int chance = 1;
		if (chance <= kahvilaTodennakoisyys) {
			kahvila = true;
		}else
			kahvila = false;
*/

		return kahvila;
	}

	public boolean onkoVaraus() {
		return varaus;
	}
	
	public long getId() {
		return id;
	}
	public void raportti() {
		Trace.out(Trace.Level.INFO, "\nAsiakas "+id+ " valmis! ");
		Trace.out(Trace.Level.INFO, "Asiakas "+id+ " saapui: " +saapumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " poistui: " +poistumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " varaus: " +varaus);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " viipyi: " +(poistumisaika-saapumisaika));
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " kahvila: " +kahvila);

		if (varaus) {
			sum += (poistumisaika-saapumisaika);
			double keskiarvo = sum/id;
			System.out.println("Varausasiakkaiden läpimenoaikojen keskiarvo tähän asti "+ keskiarvo);
		}
		else {
			sum2 += (poistumisaika-saapumisaika);
			double keskiarvo2 = sum2/id;
			System.out.println("Ilman varausta asiakkaiden läpimenoaikojen keskiarvo tähän asti "+ keskiarvo2);
		}
		sum3 += (poistumisaika-saapumisaika);
		double kokKeskiarvo = sum3/id;
		System.out.println("Kaikkien asiakkaiden läpimenoaikojen keskiarvo tähän asti "+ kokKeskiarvo);
	}
}