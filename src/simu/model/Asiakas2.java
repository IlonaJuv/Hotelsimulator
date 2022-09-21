package simu.model;

import simu.framework.Kello;
import simu.framework.Trace;

public class Asiakas2 extends Asiakas {

	private double saapumisaika;
	private double poistumisaika;
	private int id;
	private static int i = 1;
	private static long sum = 0;
	
	public Asiakas2(){
	    id = i++;
	    
		saapumisaika = Kello.getInstance().getAika();
		Trace.out(Trace.Level.INFO, "Uusi asiakas2:" + id + ":"+saapumisaika);
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
	
	public void raportti(){
		Trace.out(Trace.Level.INFO, "Asiakas2 "+id+ " saapui:" +saapumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas2 "+id+ " poistui:" +poistumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas2 "+id+ " viipyi:" +(poistumisaika-saapumisaika));
		sum += (poistumisaika-saapumisaika);
		double keskiarvo = sum/id;
		System.out.println("Asiakas2 tyyppisten asiakkaiden läpimenoaikojen keskiarvo "+ keskiarvo);
	}
}
