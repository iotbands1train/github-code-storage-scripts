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
     * Retrieves the total run count from the file.
     * 
     * @return The total number of runs recorded in the file.
     */
    private static int getRunCount() {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            // File might not exist yet, which is fine.
        }
        return lines;
    }

    /**
     * Retrieves a map of class names to their respective run counts from the file.
     * 
     * @return A map containing class names and their run counts.
     */
    private static Map<String, Integer> getClassCounts() {
        Map<String, Integer> counts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String className = line.split(" ")[5];
                counts.put(className, counts.getOrDefault(className, 0) + 1);
            }
        } catch (IOException e) {
            // File might not exist yet, which is fine.
        }
        return counts;
    }
}