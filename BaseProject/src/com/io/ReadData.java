package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.model.UserFile;
import java.io.FileNotFoundException;
public class ReadData {
	public static ArrayList<UserFile> readFiles(){
		File file = new File("data");
		String[] fileList = file.list();
		ArrayList<UserFile> allFiles = new ArrayList<>();
		for(String filename:fileList) {
			try {
				allFiles.add(readFile(filename));
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		return allFiles;
	}
	public static String readFileData() {
		String fileData = "";
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String input = scan.nextLine();
			if("exit".equalsIgnoreCase(input) || (input.length() == 0))
				break;
			if(fileData == null) 
				fileData = (input+"\n");
			else
				fileData += (input+"\n");
		}
		//scan.close();
		if(fileData.length()>0)
			return fileData.substring(0,fileData.length() - 1); //remove trailing '\n'
		else
			return fileData;
	}
	
	public static String readString() {
		String stringData = null;
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(System.in));
			stringData = input.readLine();
		} catch (IOException ioe) {
			System.out.println("Error in accepting data");
			ioe.printStackTrace();
		} finally {
			if (input != null) {
				input = null;
			}
		}
		if(stringData.equals(""))
			stringData="0";
		return stringData;
	}

	public static UserFile readFile(String filename) throws FileNotFoundException{
		String file = "data\\" + filename;
		UserFile userFile = null;
		BufferedReader input = null;
		try {
			String readLine = null;
			input = new BufferedReader(new FileReader(file));
			userFile = new UserFile(filename);
			while((readLine = input.readLine())!=null) {
				userFile.appendData(readLine);
			}
		} catch (FileNotFoundException fnf) {
			throw new FileNotFoundException("Cannot find file " + filename);
		} catch(IOException ioe){
			System.out.println("Error reading the file! Please try again later");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return userFile;
	}
}
