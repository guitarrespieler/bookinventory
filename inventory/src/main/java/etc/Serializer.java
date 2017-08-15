package etc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import model.Inventory;

public class Serializer {
	
	private static final String jsonExt = ".json";
	private static final String inventoryFileName = "bookinventory" + jsonExt;
	

	private static Gson gson = new Gson();
	
	public static void saveInventory(Inventory inventory){
		String jsonStr = gson.toJson(inventory);
		
		saveFile(inventoryFileName, jsonStr);
	}
	
	private static void saveFile(String  filename, String jsonStr){
		File file = new File(filename);
		
		FileWriter fw = null;
		PrintWriter writer = null;
		
		try {
			if(!file.exists())
				file.createNewFile();
			
			fw = new FileWriter(file);
			writer = new PrintWriter(fw);
			
			writer.print(jsonStr);
			writer.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			writer.close();
		}
	}
	
	public static Inventory loadInventory(){
		if(!doesInventoryExist())
			return new Inventory();
		
		String jsonStr = loadFile(inventoryFileName);
		
		return gson.fromJson(jsonStr, Inventory.class);
	}
	
	private static String loadFile(String fileName){
		StringBuilder sb = new StringBuilder();
		
		File file = new File(fileName);
		
		if(!file.exists())
			return "";
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line = "";
			
			while((line = br.readLine()) != null){
				sb.append(line);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {//omg
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	private static boolean doesInventoryExist(){
		File file = new File(inventoryFileName);
		
		return file.exists();
	}
}
