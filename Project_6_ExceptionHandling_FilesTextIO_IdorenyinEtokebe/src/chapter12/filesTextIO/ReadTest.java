package chapter12.filesTextIO;
//Import necessary packages
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import chapter12.models.Person;

/**
* This class provides methods for reading persons from a file.
*/
public class ReadTest {
 
 // 12.4: Declaring, Throwing, and Catching Exceptions.

 /**
  * Reads and returns a list of persons from a file.
  */
 public static ArrayList<Person> readPersons() {
     ArrayList<Person> p = null;
     
     // 12.10: The File Class.
     // Define a file based on the class name (Person)
     File file = new File(Person.class.getSimpleName().toLowerCase());

     // If the file does not exist, create it with a default person and save it
     if (!file.exists()) {
         try { // 12.4.1: 
        	 // 12.11.1: Writing data Using PrintWriter
             WriteTest.savePerson(new Person(), new PrintWriter(file));
         } catch (FileNotFoundException e) { // 12.4.3: Catching Exceptions
             // Print stack trace to indicate the error details
             e.printStackTrace(); // 12.4.4: Getting Information from Exceptions.
         }
     }

     try {
    	 // 12.11.3: Reading Data using Scanner.
         // Read from the file using Scanner
         Scanner r = new Scanner(file);
         // Convert the file contents to a list of persons
         p = getList(r);
         r.close();
     } catch (FileNotFoundException e) { // 12.4.3: Catching Exceptions
         // Print stack trace to indicate the error details
         e.printStackTrace(); // 12.4.4: Getting Information from Exceptions.
     }

     return p;
 }

 /**
  * Converts the content from Scanner into a list of persons.
  */
 private static ArrayList<Person> getList(Scanner r) {
     ArrayList<Person> p = new ArrayList<>();
     while (r.hasNextLine()) {
         String line = r.nextLine();
         // Convert each line to a Person object and add it to the list
         Person person = lineToPerson(line);
         p.add(person);
     }
     return p;
 }

 /**
  * Converts a line of text into a Person object.
  */
 private static Person lineToPerson(String line) {
     // Split the line into values using comma and space as delimiters
     String[] values = line.split(", ");

     // Check if the line has the correct number of values
     if (values.length != 8) {
    	 // 12.4.2: Throwing Exceptions
         throw new IllegalArgumentException("Invalid input line: " + line);
     }

     // Create a new Person object and set its properties based on the values
     Person p = new Person();
     p.setId(Long.parseLong(values[0].trim()));
     p.setFname(values[1]);
     p.setLname(values[2]);
     p.setStreet(values[3]);
     p.setCity(values[4]);
     p.setState(values[5]);
     p.setZip(values[6]);
     p.setPhone(values[7]);
     return p;
 }
}