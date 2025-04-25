package gson.test.impor;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Persistenza {
	
	private static final String FILE_DATI = "../ImportJar/numeri/num.json";
	private static Gson gson;
	
	public Persistenza() {
		this.gson= new GsonBuilder().setPrettyPrinting().create();
	}
	
	private static <T> void salva(T oggetto, String fpath) {
		try(FileWriter wr = new FileWriter(fpath)){
			gson.toJson(oggetto, wr);
			wr.close();
		} catch (IOException e) {
			System.err.println("Errore durente il salvataggio: " + e.getMessage());
		}
	}
	
	private static <T> T carica(Type typeOf, String fpath) {
		T oggetto = null;
		File file = new File(fpath);
		if(!file.exists()) {
			System.err.println("File non trovato: " + fpath);
			return null;
		}
		
		try(FileReader rd = new FileReader(fpath)){
			oggetto = gson.fromJson(rd, typeOf);
		} catch(IOException e) {
			System.err.println("Errore durante il caricamento: " + e.getMessage());
		}
		return oggetto != null ? oggetto : null;
	}
	
	private static <T> T creaOggettoVuoto(Class<T> classe) {
        try {
            return classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static void salvanumeri(ArrayList<Integer> numeri) {
		salva(numeri, FILE_DATI);
	}
	
	public static ArrayList<Integer> caricaNumeri(){
	    Type listType = new TypeToken<ArrayList<Integer>>() {}.getType();
	    ArrayList<Integer> gerarchie = carica(listType, FILE_DATI);
	    if(gerarchie == null) {
	    	return new ArrayList<Integer>();
	    }
	    return gerarchie;
	}
}
