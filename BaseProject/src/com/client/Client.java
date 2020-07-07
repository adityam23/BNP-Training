package com.client;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Collections;

import com.io.ReadData;
import com.io.WriteData;
import com.model.UserFile;
import com.model.comparator.FileNameAscendingComparator;
import com.model.comparator.FileNameDescendingComparator;

public class Client {
	private static ArrayList<UserFile> userFiles;

	public void createUserFile() {
		System.out.print("Enter the filename : ");
		String filename = ReadData.readString();
		System.out.print("Enter data into file (type exit to exit or press enter twice) : ");
		String data = ReadData.readFileData();
		boolean exists = false;
		for (UserFile uf : userFiles) {
			if (uf.getFilename().equalsIgnoreCase(filename)) {
				exists = true;
				uf.setFilename(filename);
				uf.setData(data);
				int status = WriteData.writeFile(uf);
				if (status == 0) {
					System.out.println("File " + filename + " created successfully!");
				} else {
					System.out.println("An error occured!");
				}
				break;
			}
		}
		if (!exists) {
			UserFile userFile = new UserFile(filename, data);
			int status = WriteData.writeFile(userFile);
			if (status == 0) {
				userFiles.add(userFile);
				System.out.println("File " + filename + " created successfully!");
			} else {
				System.out.println("An error occured!");
			}
		}

	}

	public void showAllFiles() {
		System.out.println("-------------------------------------------------");
		if (userFiles.isEmpty()) {
			System.out.println("No files to show!");
		} else {
			int i = 1;
			for (UserFile uf : userFiles) {
				System.out.println(i + ". " + uf.getFilename());
				i++;
			}
		}
		System.out.println("-------------------------------------------------");
	}

	public void showUserFile() {
		System.out.print("Enter the filename to show : ");
		String filename = ReadData.readString();
		try {
			UserFile userFile = ReadData.readFile(filename);
			if (userFile != null) {
				System.out.println("Found the file!");
				System.out.println("-------------------------------------------------");
				System.out.println("Filename : " + userFile.getFilename());
				System.out.println("File Data : \n" + userFile.getData());
				System.out.println("-------------------------------------------------");
			} else {
				System.out.println("Error reading file " + filename);
			}
		} catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}
	}

	public void showUserFile(String filename) {
		// System.out.print("Enter the filename to show : ");
		// String filename = ReadData.readString();
		try {
			UserFile userFile = ReadData.readFile(filename);
			if (userFile != null) {
				System.out.println("-------------------------------------------------");
				System.out.println("Filename : " + userFile.getFilename());
				System.out.println("File Data : \n" + userFile.getData());
				System.out.println("-------------------------------------------------");
			} else {
				System.out.println("Error reading file " + filename);
			}
		} catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}
	}

	public void sortAscending() {
		// ArrayList<UserFile> unsortedFiles = ReadData.readFiles();
		if (userFiles.isEmpty()) {
			System.out.println("No files to sort!");
		} else {
			Collections.sort(userFiles, new FileNameAscendingComparator());
		}
	}

	public void sortDescending() {
		// ArrayList<UserFile> unsortedFiles = ReadData.readFiles();
		if (userFiles.isEmpty()) {
			System.out.println("No files to sort!");
		} else {
			Collections.sort(userFiles, new FileNameDescendingComparator());
		}
	}

	public void splashScreen() {
		System.out.println("-----------------Phase 1 Project-----------------");
		System.out.println("Made by : Aditya Menon");
		System.out.println("-------------------------------------------------");
	}

	public void mainMenu() {
		while (true) {
			userFiles = ReadData.readFiles();
			int innerChoice = 0;
			int outerChoice = 0;
			String filename = null;
			System.out.println("--------------------Welcome!---------------------\n\n\n");
			System.out.println("1. Create new file");
			System.out.println("2. Show file by filename");
			System.out.println("3. Show all files");
			System.out.println("4. Sort");
			System.out.println("5. Delete file");
			System.out.println("6. Exit");
			System.out.print("Enter your choice : ");
			String mainChoice = ReadData.readString();
			if(mainChoice != null)
				outerChoice = Integer.parseInt(mainChoice);
			switch (outerChoice) {
			case 1:
				createUserFile();
				break;
			case 2:
				showUserFile();
				break;
			case 3:
				showAllFiles();
				System.out.print("Select file to show (0 to go back) : ");
				innerChoice = Integer.parseInt(ReadData.readString());
				try {
					filename = userFiles.get(innerChoice - 1).getFilename();
					showUserFile(filename);
				} catch (Exception e) {
					if (innerChoice != 0)
						System.out.println("Invalid number entered");
				}
				break;
			case 4:
				System.out.println("1. Sort Ascending");
				System.out.println("2. Sort Descending");
				innerChoice = Integer.parseInt(ReadData.readString());
				switch (innerChoice) {
				case 1:
					sortAscending();
					showAllFiles();
					break;
				case 2:
					sortDescending();
					showAllFiles();
					break;
				}
				break;
			case 5:
				showAllFiles();
				System.out.print("Select file to delete (0 to go back) : ");
				innerChoice = Integer.parseInt(ReadData.readString());
				try {
					filename = userFiles.get(innerChoice - 1).getFilename();
					File deleteFile = new File("data\\" + filename);
					if (deleteFile.delete()) {
						userFiles.remove(innerChoice - 1);
						System.out.println("File successfully deleted " + filename);
					} else
						System.out.println("Error deleting file " + filename);
				} catch (Exception e) {
					if (innerChoice != 0)
						System.out.println("Invalid number entered");
				}
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Enter valid choice");
			case 0:
				continue;
			}
		}
	}

}
