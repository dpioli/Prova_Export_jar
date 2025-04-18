package gson.test.impor;

import java.util.ArrayList;


public class GsonImportTest {

	public static void main(String[] args) {
		Persistenza p = new Persistenza();
		
		ArrayList<Integer> numeri = Persistenza.caricaNumeri();
		
		boolean continua = false;
		
		while(!continua) {
			int nuovoNum = InputDati.leggiIntero("Inserisci un numero ('0' per terminare) > ");
			if(nuovoNum == 0) {
				continua = true;
			} else {
				numeri.add(nuovoNum);
			}
		}
		
		System.out.println(numeri);
		
		Persistenza.salvanumeri(numeri);
		

	}

}
