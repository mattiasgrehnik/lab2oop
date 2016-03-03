package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Hints on how to implement serialization and deserialization
 * in class CollectionOfBooks.
 */
public class FileManagement {
	private DataStorage data;
	
	/**
	 * Sets the data from DataStorage
	 * @param data
	 */
	public void setData(DataStorage data){
		this.data = data;
	}
	/**
	 * Returns the DataStorage
	 * @return DataStorage
	 */
	public DataStorage getData(){
		return data;
	}
	
	/**
	 * Serializes data from DataStorage to a file
	 * @param filename
	 * @throws IOException
	 */
	public void serializeToFile(String filename) throws IOException {
		
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(data);
		}
		finally {
			try {
				if(out != null){
					out.close();
				}
			} catch(Exception e) {
				System.out.println("File not found! Creating new file!");
			}
		}
	}

	/**
	 * Deserializes the data from a file to a DataStorage
	 * @param filename
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void deSerializeFromFile(String filename) throws IOException, ClassNotFoundException {
		
		ObjectInputStream in = null;
		
		try {
			in = new ObjectInputStream(new FileInputStream(filename));
			// readObject returns a reference of type Object, hence the down-cast
			data = (DataStorage) in.readObject();
		}
		finally {
			try {
				if(in != null){
					in.close();
				}
			} catch(Exception e) {
				System.out.println("File not found! Creating new file!");
			}			
		}
	}

}
