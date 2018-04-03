package console_app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class SortingFromFile {
	
	public static ArrayList<String> readData(String fileDirectory){
		ArrayList<String> data = new ArrayList<String>();
		File f = null;
		BufferedReader br = null;
		String str; 
		try {
			f = new File("C:\\Users\\Siddh\\Downloads\\unsorted.txt");
			br = new BufferedReader(new FileReader(f));
			while ((str = br.readLine()) != null) {
				data.add(str);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public static void writeData(ArrayList<String> al) {
		String path = "C:\\Users\\Siddh\\Downloads\\sorted.txt";
		File file = new File (path);
		try {
			if(file.createNewFile())
				System.out.println("Sorted.txt is created");
			else
				System.out.println("file creation fail..!");
		} catch(IOException e) {
			e.printStackTrace();
		}
		FileWriter fw = null;
		PrintWriter edit = null;
		try {
			fw = new FileWriter(path);
			edit = new PrintWriter(fw);
			for(int i = 0; i < al.size(); i++) {
				edit.println(al.get(i));
			}
			System.out.println("sorted list is added to file.");
		} catch(IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				fw.close();
				edit.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		String path = "C:\\Users\\Siddh\\Downloads\\unsorted.txt";
		ArrayList <String> dataStr = readData(path);
		System.out.println("Unsorted List");
		for(String s : dataStr) {
			System.out.println(s);
		}
		System.out.println("\nSorted List");
		Collections.sort(dataStr);
		for(String s : dataStr) {
			System.out.println(s);
		}
		writeData(dataStr);
	}
}