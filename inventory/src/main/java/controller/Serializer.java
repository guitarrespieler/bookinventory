package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import model.inventory.AuthorInventory;
import model.inventory.PublicationInventory;
import model.inventory.PublicationTypes;
import model.inventory.ThemeInventory;
import model.inventory.TitleInventory;

public class Serializer {

	Gson gson = new Gson();
	
	public void createInventoryFiles(){
		for(FileName name : FileName.values()){
			File temp = new File(name.getFileName());
			try {
				temp.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	
	public boolean AreInventoryFilesExists(){
		for(FileName name : FileName.values()){
			if(!isInventoryFileExist(name))
				return false;
		}
		return true;
	}

	private boolean isInventoryFileExist(FileName name) {
		File file = new File(name.getFileName());
		
		return file.exists();
	}
	
	public void saveFile(FileName name, String jsonStr){
		File file = new File(name.getFileName());
		
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
	
	public String loadFile(FileName name){
		StringBuilder sb = new StringBuilder();
		
		File file = new File(name.getFileName());
		
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
	
	public void serialize(PublicationInventory inventory){
		String jsonStr = gson.toJson(inventory);		
		saveFile(FileName.PUBLICATIONS, jsonStr);
	}
	
	public PublicationInventory deserializePublicationInventory(){
		String jsonStr = loadFile(FileName.PUBLICATIONS);
		return gson.fromJson(jsonStr, PublicationInventory.class);
	}
	
	public void serialize(AuthorInventory inventory){
		String jsonStr = gson.toJson(inventory);		
		saveFile(FileName.AUTHORS, jsonStr);
	}
	
	public AuthorInventory deserializeAuthorInventory(){
		String jsonStr = loadFile(FileName.AUTHORS);
		return gson.fromJson(jsonStr, AuthorInventory.class);
	}
	
	public void serialize(PublicationTypes types){
		String jsonStr = gson.toJson(types);		
		saveFile(FileName.PUBLICATIONTYPES, jsonStr);
	}
	
	public PublicationTypes deserializePublicationTypes(){
		String jsonStr = loadFile(FileName.PUBLICATIONTYPES);
		return gson.fromJson(jsonStr, PublicationTypes.class);
	}
	
	public void serialize(ThemeInventory inventory){
		String jsonStr = gson.toJson(inventory);		
		saveFile(FileName.THEMES, jsonStr);
	}
	
	public ThemeInventory deserializeThemeInventory(){
		String jsonStr = loadFile(FileName.THEMES);
		return gson.fromJson(jsonStr, ThemeInventory.class);
	}
	
	public void serialize(TitleInventory inventory){
		String jsonStr = gson.toJson(inventory);		
		saveFile(FileName.PUBLICATIONS, jsonStr);
	}
	
	public TitleInventory deserializeTitleInventory(){
		String jsonStr = loadFile(FileName.TITLES);
		return gson.fromJson(jsonStr, TitleInventory.class);
	}
}
