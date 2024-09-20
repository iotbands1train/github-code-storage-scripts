package com.binaryio;
import java.io.*;

// Importing additional custom classes
import com.RunTracker.RunTracker;
import com.model.Person;
import com.random.MyRandomPersonData;

/**
 * This class demonstrates the use of RandomAccessFile to write and read serialized
 * Person objects. It uses a fixed-size byte array to store each Person object,
 * ensuring consistent record sizes for random access.
 */
public class TestRandomAccessFilePerson {

    // Fixed size for each serialized Person object to ensure uniform size
    private static final int FIXED_SIZE = 1024;

    /**
     * Main method which writes and reads Person objects to and from a RandomAccessFile.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Try-with-resources to ensure proper resource management
        try (RandomAccessFile inout = new RandomAccessFile("personData.dat", "rw")) {

            // Update the run count for tracking executions of this class
            RunTracker.updateRunCount(TestRandomAccessFilePerson.class.getSimpleName());

            // Reset the file length to 0 to start fresh
            inout.setLength(0);

            // Generate an array of random Person objects
            Person[] p =  MyRandomPersonData.randomNumPeople(100);

            // Writing Person objects to the file
            for (int i = 0; i < 10; i++) {
                // Select a random Person from the array
                Person person = p[(int) (Math.random()*p.length)];

                // Serialize the Person object to a byte array
                byte[] personBytes = serialize(person);

                // Creating a fixed-size byte array for uniform record size
                byte[] fixedSizePersonData = new byte[FIXED_SIZE];

                // Copy serialized data to fixed-size array
                System.arraycopy(personBytes, 0, fixedSizePersonData, 0, Math.min(personBytes.length, FIXED_SIZE));

                // Write the fixed-size data to the file
                inout.write(fixedSizePersonData);
            }

            // Reading a Person object from a specific location
            inout.seek(0); // Pointing to the start of the file

            // Creating a byte array to hold the read data
            byte[] personData = new byte[FIXED_SIZE];

            // Reading a full record from the file
            inout.readFully(personData);

            // Deserialize the data to obtain the first Person object
            Person firstPerson = deserialize(personData);

            // Display the first Person object
            System.out.println("First person: " + firstPerson);
        }
    }

    /**
     * Serializes a Person object to a byte array.
     * 
     * @param p The Person object to serialize.
     * @return A byte array representing the serialized Person object.
     * @throws IOException If an I/O error occurs.
     */
    private static byte[] serialize(Person p) throws IOException {
        // Use ByteArrayOutputStream and ObjectOutputStream for serialization
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(p);
            return bos.toByteArray();
        }
    }

    /**
     * Deserializes a byte array back to a Person object.
     * 
     * @param data The byte array containing the serialized Person object.
     * @return The deserialized Person object.
     * @throws IOException If an I/O error occurs.
     * @throws ClassNotFoundException If the Person class is not found.
     */
    private static Person deserialize(byte[] data) throws IOException, ClassNotFoundException {
        // Use ByteArrayInputStream and ObjectInputStream for deserialization
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream in = new ObjectInputStream(bis)) {
            return (Person) in.readObject();
        }
    }
}