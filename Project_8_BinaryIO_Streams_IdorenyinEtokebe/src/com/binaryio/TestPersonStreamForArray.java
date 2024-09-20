package com.binaryio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Importing custom utility and model classes
import com.RunTracker.RunTracker;
import com.model.Person;
import com.random.MyRandomPersonData;

/**
 * Demonstrates binary IO operations using an array of Person objects.
 * This class shows how to serialize and deserialize arrays of objects 
 * to and from a binary file using Java's Object Input/Output Streams.
 */
public class TestPersonStreamForArray {
    
    /**
     * Main method that demonstrates the serialization and deserialization 
     * of an array of Person objects using binary streams.
     * 
     * @param args Command line arguments (not used in this method).
     * @throws ClassNotFoundException if a class cannot be found during deserialization.
     * @throws IOException if an IO error occurs during file operations.
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // Update the run count for this class for tracking executions
        RunTracker.updateRunCount(TestPersonStreamForArray.class.getSimpleName());

        // Generate an array of Person objects for demonstration
        Person[] persons = MyRandomPersonData.randomNumPeople(55);

        // Using ObjectOutputStream to write data to a binary file
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("personArray.dat"))) {
            // Write the array of Person objects to the file
            output.writeObject(persons);
        } // The try-with-resources statement ensures that the ObjectOutputStream is closed after use

        // Using ObjectInputStream to read data from a binary file
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("personArray.dat"))) {
            // Read the array of Person objects back from the file
            Person[] newPersons = (Person[]) (input.readObject());

            // Print each Person object from the deserialized array
            for (Person person : newPersons) {
                System.out.println(person);
            }
        } // The try-with-resources statement ensures that the ObjectInputStream is closed after use
    }
}