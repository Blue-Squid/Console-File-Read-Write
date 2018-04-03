package console_app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// file location: C:\Users\Siddh\Downloads\
public class CreateFileList {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner st = new Scanner(System.in);
		String path ="C:\\Users\\Siddh\\Downloads\\";
		String filename = "unsorted.txt";
		path = path.concat(filename);
		System.out.println("File is stored at : "+path);
		File file = new File(path);
		try {
			if(file.createNewFile())
				System.out.println("File is created");
			else
				System.out.println("File doesn't exist");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Writing through Console.
		
		FileWriter fileEdit = null;
		PrintWriter edit = null;
		try {
			fileEdit = new FileWriter(path);
			edit = new PrintWriter(fileEdit);
			System.out.println("enter names with last_name followed by first_name");
			System.out.println("enter nummber of entries : ");
			int lines = in.nextInt();
			String str [] = new String[lines];
			for(int i = 0; i < lines; i++) {
				System.out.println("entry Number "+i);
				str[i] = st.nextLine();
			}
			for(int i = 0; i < str.length; i++) {
				edit.println(str[i]);
			}
			System.out.println("Data Stored in File");
		
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				fileEdit.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			edit.close();
		}
	}

}
