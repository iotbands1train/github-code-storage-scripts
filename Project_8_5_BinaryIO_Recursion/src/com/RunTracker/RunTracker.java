package com.RunTracker;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * The RunTracker class is used to track the execution count of different classes.
 * It records each run with a timestamp and class-specific count in a text file.
 */
public class RunTracker {

    // Constants for the file name and date-time format.
    private static final String FILE_NAME = "timesRunFile.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Updates the run count for a specified class. Records the current date-time,
     * class name, and respective counts to a file.
     * 
     * @param className The name of the class to update the run count for.
     */
    public static void updateRunCount(String className) {
        Map<String, Integer> classCounts = getClassCounts();
        int count = getRunCount() + 1;
        int classCount = classCounts.getOrDefault(className, 0) + 1;
        String dateTime = LocalDateTime.now().format(formatter);
        String content = "Count#" + count + " DateTime: " + dateTime + " Class: " + className + " ClassCount: " + classCount + "\n";

        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the total run count from the file using recursion.
     *
     * @return The total number of runs recorded in the file.
     */
    private static int getRunCount() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            return countLines(reader, 0);
        } catch (IOException e) {
            // Handle file-related exceptions
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Retrieves a map of class names to their respective run counts from the file using recursion.
     *
     * @return A map containing class names and their run counts.
     */
    private static Map<String, Integer> getClassCounts() {
        Map<String, Integer> counts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            readLines(reader, counts);
        } catch (IOException e) {
            // Handle file-related exceptions
            e.printStackTrace();
        }
        return counts;
    }
    
    /**
     * Reads lines from the file recursively and counts the occurrences of class names.
     *
     * @param reader The BufferedReader used to read the file.
     * @param counts A map containing class names and their run counts.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    private static void readLines(BufferedReader reader, Map<String, Integer> counts) throws IOException {
        String line = reader.readLine();
        if (line != null) {
            String className = line.split(" ")[5];
            counts.put(className, counts.getOrDefault(className, 0) + 1);
            readLines(reader, counts); // Recursively read the next line
        }
    }
    
    /**
     * Recursively counts the number of lines (runs) in the file.
     *
     * @param reader The BufferedReader used to read the file.
     * @param lines  The count of lines processed so far.
     * @return The total number of lines (runs) in the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    private static int countLines(BufferedReader reader, int lines) throws IOException {
        String line = reader.readLine();
        if (line != null) {
            return countLines(reader, lines + 1); // Recursively count the next line
        } else {
            return lines; // Base case: return the total count of lines
        }
    }
    
    
}