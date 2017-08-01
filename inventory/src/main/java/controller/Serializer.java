package controller;

import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;

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
}
