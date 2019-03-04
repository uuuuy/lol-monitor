package com.uuuuy.lol.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PutFile {
	
	private String account;
	private File file;
	
	public PutFile(String account) throws IOException {
		this.account = account;
		file = new File("E:/" + account + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw e;
			}
		}
	}

	public String read() {
		StringBuffer content = new StringBuffer();
		try {
			String s = "";
			InputStreamReader in = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(in);
			while ((s=br.readLine())!=null) {
				content = content.append(s);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content.toString();
	}
	
	public void output(String content) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			out.write(content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
