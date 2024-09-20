package chapter12.filesTextIO;
//Import necessary packages
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import chapter12.models.Person;

/**
* This class provides methods for writing persons to a file.
*/
public class WriteTest {
 // 12.10: The File Class.
 // 12.11.3: Reading Data using Scanner.
 // 12.4: Declaring, Throwing, and Catching Exceptions.
 

 /**
  * Saves a list of persons to a file.
  * @param l The list of persons to be saved.
  */
 public static void savePerson(ArrayList<Person> l) {
     // Get the class name of the first person in the list to determine the filename
     String filename = l.get(0).getClass().getSimpleName().toLowerCase();
     // Create a File object with the determined filename
     File file = new File(filename); // 12.11: The File Input and Output.
     PrintWriter pw = null; // 12.11.1: Writing Data Using PrintWriter.
     
     // 12.11.1: Writing Data Using PrintWriter.
     try {
         // Create a PrintWriter to write to the file
         pw = new PrintWriter(file);
         // Iterate through the list of persons and save each person using the savePerson method
         for (int i = 0; i < l.size(); i++) {
             savePerson(l.get(i), pw);
         }
         // Close the PrintWriter
         pw.close();
     } catch (FileNotFoundException e) { // 12.4.3 Catching Exceptions
         // Print stack trace to indicate the error details
         e.printStackTrace(); // 12.4.4: getting Information from Exceptions.
     }
 }

 /**
  * Saves a single person's information to the provided PrintWriter.
  * @param p The person object to be saved.
  * @param pw The PrintWriter used for writing to the file.
  */
 public static void savePerson(Person p, PrintWriter pw) {
     // Write each property of the person separated by commas and a newline character
     pw.print(p.getId() + ", ");
     pw.print(p.getFname() + ", ");
     pw.print(p.getLname() + ", ");
     pw.print(p.getStreet() + ", ");
     pw.print(p.getCity() + ", ");
     pw.print(p.getState() + ", ");
     pw.print(p.getZip() + ", ");
     pw.println(p.getPhone());
 }

 /**
  * Gets the number of lines in the provided Scanner.
  * @param r The Scanner to count lines from.
  * @return The number of lines in the Scanner.
  */
 public static int getLineCount(Scanner r) {
     int l = 0;
     while (r.hasNextLine()) {
         r.nextLine();
         l++;
     }
     return l;
 }
}
