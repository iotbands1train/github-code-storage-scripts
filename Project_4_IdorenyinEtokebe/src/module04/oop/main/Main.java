package module04.oop.main;

import module04.oop.models.Admin;
import module04.oop.models.Person;

/**
 * The Main class demonstrates the usage of the Person and Admin classes by generating and displaying their data.
 */
public class Main {

    public static void main(String[] args) {
        // Creating an instance of the Person class
        Person person = new Person();
        
        // Displaying the generated Person data
        System.out.println("Generated Person Data:");
        System.out.println(person);

        // Creating an instance of the Admin class
        Admin admin = new Admin();
        
        // Displaying the generated Admin data
        System.out.println("\nGenerated Admin Data:");
        System.out.println(admin);
    }
}
