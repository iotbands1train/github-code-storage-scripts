package module02.objectclassestopics;

import java.util.Arrays;
import java.util.Date;

/**
 * The PersonArray class manages an array of Person objects and provides
 * methods to perform operations such as adding, updating, deleting, and displaying
 * individuals. It also includes methods to create random persons and access the array size.
 */
public class PersonArray {
	
	private Person[][] pDatabase;
	private int numRows;
	private int numCols;
	private static final int DEFAULT_NUM_ROWS = 100;
	private static final int DEFAULT_NUM_COLS = 10;
	
	public PersonArray(int newNumRows, int newNumCols) {
		numRows = newNumRows;
		numCols = newNumCols;
		
		pDatabase = new Person[numRows][numCols];
	}
	
	public PersonArray() {
		this(DEFAULT_NUM_ROWS, DEFAULT_NUM_COLS);
	}
	
	public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getArraySize() {
        return numRows * numCols;
    }
	
	/**
	 * @return the pDatabase
	 */
	public Person[][] getpDatabase() {
		return pDatabase;
	}

	/**
	 * @param pDatabase the pDatabase to set
	 */
	public void setpDatabase(Person[][] pDatabase) {
		this.pDatabase = pDatabase;
	}

	/**
	 * @param numRows the numRows to set
	 */
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	/**
	 * @param numCols the numCols to set
	 */
	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}
	
	/**
	 * Adds a Person object to the two-dimensional array if there is an available slot.
	 *
	 * @param person The Person object to be added.
	 * @return true if the person is added successfully, false if the array is full.
	 */
	public boolean addPerson(Person person) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (pDatabase[row][col] == null) {
                	pDatabase[row][col] = person;
                    return true; // Person added successfully
                }
            }
        }
        return false; // Array is full, person not added
    }
	
	/**
	 * Retrieves the Person object stored at the specified row and column in the two-dimensional array.
	 *
	 * @param row The row index of the desired person.
	 * @param col The column index of the desired person.
	 * @return The Person object at the specified row and column, or null if the indices are invalid.
	 */	
	public Person getPerson(int row, int col) {
        if (row >= 0 && row < numRows && col >= 0 && col < numCols) {
            return pDatabase[row][col];
        } else {
            System.out.println("Invalid row or column index.");
            return null;
        }
    }
	
	/**
	 * Displays information of all persons stored in the two-dimensional array.
	 * If a cell in the array contains a non-null Person object, their information is printed.
	 */
    public void displayAllPersons() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (pDatabase[row][col] != null) {
                    System.out.println(pDatabase[row][col]);
                }
            }
        }
    }
    
 // Update a person based on ID
    public void updatePerson(long id, Person updatedPerson) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (pDatabase[row][col] != null && pDatabase[row][col].getId() == id) {
                	pDatabase[row][col] = updatedPerson;
                    return;
                }
            }
        }
        System.out.println("Person with ID " + id + " not found.");
    }
    
 // Delete a person based on ID
    public void deletePerson(long id) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (pDatabase[row][col] != null && pDatabase[row][col].getId() == id) {
                	pDatabase[row][col] = null;
                    return;
                }
            }
        }
        System.out.println("Person with ID " + id + " not found.");
    }
    
    
    /**
     * Generates and adds a specified number of random Person objects to the array.
     *
     * @param count The number of random persons to generate and add.
     */
    public void createBulkRandomPersons(int count) {
        for (int i = 0; i < count; i++) {
            Person randomPerson = generateRandomPerson();
            addPerson(randomPerson);
        }
    }
    
    /**
     * Generates a random Person object with random attribute values including ID, first name,
     * last name, street number, street name, city, state, zip code, phone number, salary, creation date,
     * membership status, and a default password. The random values are generated using the
     * MyRandomPersonData class's methods.
     *
     * @return A randomly generated code Person object.
     */
    private Person generateRandomPerson() {
        int id = MyRandomPersonData.generateRandomId();
        String fname = MyRandomPersonData.generateRandomFirstName();
        String lname = MyRandomPersonData.generateRandomLastName();
       int streetNo = MyRandomPersonData.generateRandomStreetNumber();
        String streetName = MyRandomPersonData.generateRandomStreetName();
        String city = MyRandomPersonData.generateRandomCity();
        String state = MyRandomPersonData.generateRandomState();
        int zip = MyRandomPersonData.generateRandomZip();
        int phone = MyRandomPersonData.generateRandomPhoneNumber();
        float salary = MyRandomPersonData.generateRandomSalary();
        Date creationDate = MyRandomPersonData.generateRandomCreationDate();
        boolean isMember = MyRandomPersonData.generateRandomIsMember();
        String defaultPassword = MyRandomPersonData.generateRandomPassword();

        return new Person(id, fname, lname, streetNo, streetName, city, state, zip, phone, salary, creationDate, isMember, defaultPassword);
    }

	@Override
	public String toString() {
		return "PersonArray [pDatabase=" + Arrays.toString(pDatabase) + ", numRows=" + numRows + ", numCols=" + numCols
				+ "]";
	}
    	

}
