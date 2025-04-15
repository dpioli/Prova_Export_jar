package gson.test.impor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class GsonImportTest {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		ArrayList<Integer> numeri = new ArrayList<>();
		
		for (int i = 0; i < 100; i++)
			numeri.add(i);
		
		System.out.println(numeri);
		System.out.println(gson.toJson(numeri));
		try {
			FileWriter fileWriter = new FileWriter("../ImportJar/numeri/num.json");
			gson.toJson(numeri, fileWriter);
			System.out.println("JSON saved to num.json successfully!");
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
