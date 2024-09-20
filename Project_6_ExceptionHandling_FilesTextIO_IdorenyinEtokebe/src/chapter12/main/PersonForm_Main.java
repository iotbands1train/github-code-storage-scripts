package chapter12.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import chapter12.filesTextIO.ReadTest;
import chapter12.filesTextIO.WriteTest;
import chapter12.formuserinput.FormFields;
import chapter12.models.Person;

/**
 * This class represents the main entry point of the Person Management System application.
 */
public class PersonForm_Main {
	// 12.10: The File Class.
	// 12.11: The File Input and Output.
	// 12.11.3: Reading Data using Scanner.
	// 12.4: Declaring, Throwing, and Catching Exceptions.
	// 12.11.1: Writing Data Using PrintWriter.

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 1;
        while (x == 1) {
            // Perform reading and writing operations
            readWriteread(in);
            // Log the timestamp of the run
            timeStamp();
            System.out.println("Press Enter for Again. Or other key and Enter to End-Program..");
            // Get user input to determine program continuation
            x = inputN(in);
            if (x != 1)
                System.out.println("Program Ended");
        }
        in.close();
    }

    /**
     * Logs the timestamp of the program run.
     */
    private static void timeStamp() {
        String filename = "timeStamp-Run-Test";
        int runCount = 0;
        // Retrieve the count of program runs from the given file
        runCount = getRunCount(filename) + 1;
        File f = new File(filename);
        PrintWriter p = null;

        try {
            p = new PrintWriter(f);
            // Write the current run count and timestamp to the file
            p.println(runCount + " " + new Date());
            p.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the count of program runs from the given file.
     */
    private static int getRunCount(String filename) {
        int lineCount = 0;
        Scanner r = null;
        try {
            r = new Scanner(new File(filename));
            String x = "";
            while (r.hasNextLine()) {
                String line = (String) r.nextLine();
                // Extract the run count from the line
                x = line.substring(0, line.indexOf(' '));
                System.out.println(x);
                lineCount = Integer.parseInt(x);
            }
            r.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    /**
     * Manages the process of reading, creating, and writing person data.
     */
    private static void readWriteread(Scanner in) {
        System.out.println("Just press Enter, Auto selects path in program\n\n\n");
        System.out.println("Current database: ");
        // Read person data from file
        ArrayList<Person> l = readPerson();
        // Display the current list of persons
        print(l);

        System.out.println("1 - User Input Person Form");
        System.out.println("2 - Exit");
        // Get user input for form or exit
        int input1 = inputN(in);
        Person person = null;
        if (input1 == 1) {
            // Create a new person based on user input
            person = createPerson(in);
        } else {
            System.out.println("Program Ended");
            System.exit(0); // Exit the program
        }
        // Add the new person to the list
        l.add(person);
        // Write the updated list of persons to a file
        WriteTest.savePerson(l);
        System.out.println("New database: ");
        // Read the updated list of persons from file
        l = readPerson();
        // Display the updated list of persons
        print(l);
        System.out.println("Done");
    }

    /**
     * Reads a list of persons from a file.
     */
    private static ArrayList<Person> readPerson() {
        // Read person data from a file and return the list
        ArrayList<Person> p = ReadTest.readPersons();
        return p;
    }

    /**
     * Prints the list of persons.
     */
    private static void print(ArrayList<Person> p) {
        if (p != null) {
            for (Person person : p) {
                System.out.println(person);
            }
        }
    }

    /**
     * Creates a new person based on user input.
     */
    private static Person createPerson(Scanner in) {
        long id = random_id();
        System.out.println("RandomID : " + id);
        // Collect user input for various fields
        String fname = FormFields.fnameForm(in);
        String lname = FormFields.lnameForm(in);
        String street = FormFields.streetForm(in);
        String city = FormFields.cityForm(in);
        String state = FormFields.stateForm(in);
        String zip = FormFields.zipForm(in);
        String phone = FormFields.phoneForm(in);

        // Create and return a new Person instance
        return new Person(id, fname, lname, street, city, state, zip, phone);
    }

    /**
     * Generates a random ID for a person.
     */
    private static long random_id() {
        // Generate a random ID within a specific range
        return new Random().nextInt(144500, 244500);
    }

    /**
     * Gets user input and returns a numeric value.
     */
    private static int inputN(Scanner in) {
        // Get user input and determine the appropriate numeric value
        String x = in.nextLine();
        x = x.equals("") ? "1" : x;
        int a = x.charAt(0) == '1' ? 1 : x.charAt(0) == '2' ? 2 : 3;
        return a;
    }
}