package testi;
import simu.framework.*;
import simu.framework.Trace.Level;

public class Simulaattori { //Tekstipohjainen

	public static void main(String[] args) {
		/*
		Trace.setTraceLevel(Level.INFO);
		Moottori m = new OmaMoottori();
		m.setSimulointiaika(1000);
		m.aja();
		 */
		SimuTesti simuTesti = new SimuTesti();
		simuTesti.simuTestaus1();
	}
}
