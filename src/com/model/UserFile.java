package com.model;

public class UserFile {
	private String filename;
	private String data;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
			this.data = data+"\n";
		
	}
	
	public void appendData(String data) {
		if(this.data == null)
			this.data = data+"\n";
		else
			this.data += (data+"\n");
		
	}
	public UserFile(String filename, String data) {
		super();
		this.filename = filename;
		this.data = data;
	}
	public UserFile(String filename) {
		super();
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "UserFile [filename=" + filename + ", data=" + data + "]";
	}
	
	
}
