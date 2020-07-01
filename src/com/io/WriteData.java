package com.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.model.UserFile;

public class WriteData {
	public static int writeFile(UserFile userFile) {
		int status = 0;
		FileWriter fileWriter = null;
		BufferedWriter writer = null;
		try {
			fileWriter = new FileWriter("data\\"+userFile.getFilename());
			writer = new BufferedWriter(fileWriter);
			String data = userFile.getData();
			writer.write(data);
			writer.flush();
		} catch(IOException ioe) {
			status = -1;
		} finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch(IOException ioe) {
					System.out.println("Could not close buffered writer!");
				}
			}
			if(fileWriter!=null) {
				try {
					fileWriter.close();
				} catch(IOException ioe) {
					System.out.println("Could not close file writer!");
				}
			}
		}
		return status;
	}
	
	public static int writeFile(UserFile userFile, boolean exists) {
		int status = 0;
		FileWriter fileWriter = null;
		BufferedWriter writer = null;
		try {
			fileWriter = new FileWriter("data\\"+userFile.getFilename());
			writer = new BufferedWriter(fileWriter);
			String data = userFile.getData();
			writer.write(data);
			writer.flush();
		} catch(IOException ioe) {
			status = -1;
		} finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch(IOException ioe) {
					System.out.println("Could not close buffered writer!");
				}
			}
			if(fileWriter!=null) {
				try {
					fileWriter.close();
				} catch(IOException ioe) {
					System.out.println("Could not close file writer!");
				}
			}
		}
		return status;
	}
}
