package nz.co.anz.dataGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App 
{
    public static void main( String[] args ){
    	BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			Gson gson = new GsonBuilder()
					.setPrettyPrinting()
					.setDateFormat("yyyy-MM-dd'T'hh:mm:ssZ")
					.create();
			String content = gson.toJson(Customer.customers());
			fw = new FileWriter("./data.json");
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

    }
}
