package CSDS234_FinalProject;
import java.io.File;
import java.io.IOException;
import java.sql.* ;
import java.util.Scanner;

import java.util.*;

public class FetchData {
//	private String videoID;
//	private String uploader;
//	private Integer age;
//	private String category;
//	private Integer length;
//	private Integer views;
//	private float rate;
//	private Integer ratings;
//	private Integer comments;
//	private String relatedIDs;
	
	public void readData(File a) {
        //Creating Linkedlist for storing different attributes
		LinkedList<String> videoID = new LinkedList<String>();
		LinkedList<String> uploader = new LinkedList<String>();
		LinkedList<String> age = new LinkedList<String>();
		LinkedList<String> category = new LinkedList<String>();
		LinkedList<String> length = new LinkedList<String>();
		LinkedList<String> views = new LinkedList<String>();
		LinkedList<String> rate = new LinkedList<String>();
		LinkedList<String> ratings = new LinkedList<String>();
		LinkedList<String> comments = new LinkedList<String>();
		LinkedList<String> relatedIDS = new LinkedList<String>();
		LinkedList<String> rowData = new LinkedList<String>();
		
		
		try(Scanner input = new Scanner(new File("src/1.txt"))){
			while(input.hasNextLine()) {
			
				 String line;
				 line = input.nextLine();
				 
				 //Trying to process data line by line
				 try(Scanner data = new Scanner(line)){
					 while(data.hasNext()) {
						rowData.add(data.next());
					 }
					 data.close();   
						videoID.add(rowData.remove());

						uploader.add(rowData.remove());
						
						age.add(rowData.remove());
						
						category.add(rowData.remove());
 
						length.add(rowData.remove());

						views.add(rowData.remove());
						
						rate.add(rowData.remove());
						
						ratings.add(rowData.remove());
						
						comments.add(rowData.remove());
						
						
						while(!rowData.isEmpty()) {
//							System.out.println(rowData); 
							relatedIDS.add(rowData.remove());
							
						}
						System.out.println(ratings);
						
				 } 
				 saveData();
				 videoID.clear();

					uploader.clear();
					
					age.clear();
					
					category.clear();

					length.clear();

					views.clear();
					
					rate.clear();
					
					ratings.clear();
					
					comments.clear();
					
					relatedIDS.clear();
			}

		} catch(IOException e) {
			System.out.println(e);
		  }
	}
	
	/**
	 * Save readed data into mysql database
	 */
	private void saveData() {
		
	}
	/**
	 * Connecting to mysql database
	 */
	private Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(""); //url from mysql
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}
	}
}



/**
 * Save data in the database
 */
class FDemo{
	public static void main(String[]args) {
		FetchData a =new FetchData();
		try {
			a.readData(new File("src/1.txt"));
		} catch(Exception e) {
			System.out.println(e);
		}
}
}
