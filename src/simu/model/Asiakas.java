package simu.model;

import eduni.distributions.Bernoulli;
import eduni.distributions.Normal;
import simu.framework.Kello;
import simu.framework.Trace;

import java.util.Random;

// TODO:
// Asiakas koodataan simulointimallin edellyttämällä tavalla (data!)
public class Asiakas {
	private double saapumisaika;
	private double poistumisaika;
	private int id;
	public boolean huonevaraus, kahvilavaraus = true;
	private static int i = 1;
	private static long sum , sum2, sum3 = 0;
	Random rdVaraus;
	Random rdKahvilaanko;

	public Asiakas(){
		id = i++;
		saapumisaika = Kello.getInstance().getAika();
		Trace.out(Trace.Level.INFO, "Uusi asiakas nro " + id + " saapui klo "+saapumisaika);
		meneekoKahvilaan();
		onkoVaraus();
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
		/*int kahvilaTodennakoisyys = 50;
		Random rnd = new Random();
		//int chance = rnd.nextInt(100-1) + 1;
		Normal ngxp = new Normal(10,5);
		int chance = (int) ngxp.sample();
		if (chance > kahvilaTodennakoisyys) {
			kahvilavaraus = true;
		}
		 */
		rdKahvilaanko = new Random();
		kahvilavaraus = rdKahvilaanko.nextBoolean();
		return kahvilavaraus;
	}
	public boolean onkoVaraus() {
		rdVaraus = new Random();
		huonevaraus = rdVaraus.nextBoolean();
		return huonevaraus;
	}
	public long getId() {
		return id;
	}
	public void raportti() {
		Trace.out(Trace.Level.INFO, "\nAsiakas "+id+ " valmis! ");
		Trace.out(Trace.Level.INFO, "Asiakas "+id+ " saapui: " +saapumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " poistui: " +poistumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " varaus: " + huonevaraus);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " viipyi: " +(poistumisaika-saapumisaika));
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " kahvila: " + kahvilavaraus);

		if (huonevaraus) {
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

	static private double kahvilaTulo, plvltiski1tulo, plvltiski2tulo, huoneTulo, ravintolaTulo;
	static private double plvltiski1Lahto, plvltiski2Lahto, huoneLahto, ravintolaLahto, kahvilaLahto;
	static int kahvilassaPalvellutAsiakkaat, ravintolassaPalvellutAsiakkaat, plvltiski1llaPalvellutAsiakkaat, plvltiski2llaPalvellutAsiakkaat, huoneenPalvellutAsiakkaat;

	public static double getKahvilaTulo() {
		return kahvilaTulo;
	}
	public static double getPlvltiski1tulo() {
		return plvltiski1tulo;
	}
	public static double getPlvltiski2tulo() {
		return plvltiski2tulo;
	}
	public static double getHuoneTulo() {
		return huoneTulo;
	}
	public static double getRavintolaTulo() {
		return ravintolaTulo;
	}
	public static double getKahvilaLahto() {
		return kahvilaLahto;
	}
	public static double getPlvltiski1Lahto() {
		return plvltiski1Lahto;
	}
	public static double getPlvltiski2Lahto() {
		return plvltiski2Lahto;
	}
	public static double getHuoneLahto() {
		return huoneLahto;
	}
	public static double getRavintolaLahto() {
		return ravintolaLahto;
	}

	public int getKahvilaAsiakkaat(){
		return kahvilassaPalvellutAsiakkaat;
	}
	public int getP1Asiakkaat(){
		return plvltiski1llaPalvellutAsiakkaat;
	}
	public int getP2Asiakkaat(){
		return plvltiski2llaPalvellutAsiakkaat;
	}
	public int getHuoneAsiakkaat(){
		return huoneenPalvellutAsiakkaat;
	}
	public void setKahvilaanTuloAika (double kahvilaanTuloAika) {
		this.kahvilaTulo = (kahvilaTulo+kahvilaanTuloAika);
	}
	public void setKahvilastaPoistumisaika(double kahvilastaPoistumisaika) {
		this.kahvilaLahto = (kahvilaLahto + kahvilastaPoistumisaika);
		this.kahvilassaPalvellutAsiakkaat++;
	}

	public void setPlvlTiski1TuloAika (double plvlTiski1TuloAika) {
		this.plvltiski1tulo = (plvltiski1tulo + plvlTiski1TuloAika);
	}
	public void setPlvltiski1Poistumisaika (double plvltiski1LahtoAika) {
		this.plvltiski1Lahto = (plvltiski1Lahto + plvltiski1LahtoAika);
		this.plvltiski1llaPalvellutAsiakkaat++;
	}
	public void setPlvlTiski2TuloAika (double plvlTiski2TuloAika) {
		this.plvltiski2tulo = (plvltiski2tulo + plvlTiski2TuloAika);
	}
	public void setPlvltiski2Poistumisaika (double plvltiski2LahtoAika) {
		this.plvltiski2Lahto = (plvltiski2Lahto + plvltiski2LahtoAika);
		this.plvltiski2llaPalvellutAsiakkaat++;
	}
	public void setHuoneeseenTuloAika (double huoneeseenTuloAika) {
		huoneTulo = (huoneTulo + huoneeseenTuloAika);
	}
	public void setHuoneestaPoistumisaika(double poistumisaika) {
		this.huoneLahto = (huoneLahto + poistumisaika);
		huoneenPalvellutAsiakkaat++;
	}
	public void setRavintolaanTuloAika (double ravintolaanTuloAika) {
		this.ravintolaTulo = (ravintolaTulo + ravintolaanTuloAika);
	}
	public void setRavintolastaPoistumisAika (double ravintolastaLahtoaika) {
		this.ravintolaLahto = (ravintolaLahto + ravintolastaLahtoaika);
		ravintolassaPalvellutAsiakkaat++;
	}
	public int getRavintolaAsiakkaat () {
		return ravintolassaPalvellutAsiakkaat;
	}
}