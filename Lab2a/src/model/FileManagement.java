package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManagement {

	public static void serializeToFile(String filename, Object data) throws IOException {

		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(data);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e) {
				System.out.println("File not found! Creating new file!");
			}
		}
	}

	public static Object deSerializeFromFile(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		Object data = null;
		try {
			in = new ObjectInputStream(new FileInputStream(filename));
			data = in.readObject();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				System.out.println("File not found! Creating new file!");
			}
		}
		return data;
	}

}
