package module05.oop.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import module05.oop.models.Person;
import module05.oop.models.StackOfPersons;
import module05.oop.models.transact.Appointment;
import module05.oop.models.transact.Transaction;
import module05.oop.models.types.Doctor;
import module05.oop.models.types.Patient;
import module05.oop.models.types.Receptionist;
import module05.oop.randompms.MyRandomPersonTypeData;

/**
 * This program manages patient visits at a clinic. It simulates the check-in,
 * appointment, and billing process.
 */
public class PatientVisitMain {
	// Scanner for user input
	static Scanner input = new Scanner(System.in);

	/**
	 * This method handles the check-in process for a patient's visit.
	 *
	 * @param transact       The current transaction.
	 * @param personDatabase The list of persons (patients) in the database.
	 * @param oldSalary      The patient's old salary before the transaction.
	 * @return The updated transaction after check-in.
	 */
	public static Transaction checkInProcess(Transaction transact, ArrayList<Person> personDatabase, Float oldSalary) {
		System.out.println("[Receptionist] Need patients(personID):"); 
		Long id = personDatabase.get(personDatabase.size() - 1).getId();
		if (id.equals(transact.getPatient().getId())) {
			// Transaction process for checking in a patient
			// ===================================================
			Patient patient = transact.getPatient();
			System.out.println("Transaction started....");
			System.out.println("Reason for Visit : ");
			patient.setReasonVisit(input.nextLine());
			System.out.println("Do you have insurance... ");
			String answer = input.nextLine();
			if (answer.toUpperCase().charAt(0) == 'Y') {
				patient.setHasInsurance(true);
			}
			System.out.println(patient);
			System.out.println("[Rec] - > patient waiting... for Doctor");
			// ===================================================
			// Creating a random doctor
			Doctor doc = new Doctor(randomPerson(personDatabase));
			doc.setObservations(MyRandomPersonTypeData.random_observation());
			System.out.println("Doctor's observation = " + doc.getObservations());
			doc.setPrescription(MyRandomPersonTypeData.random_prescription());
			System.out.println("Doctor's prescription = " + doc.getPrescription());
			// ===================================================

			System.out.println("Checkout -> " + patient.getName());
			System.out.println("===================================================");
			System.out.println("===========Processing Transaction==================");
			System.out.println("===================================================");
			System.out.println(patient.getName() + ", are you ready to pay the bill? 1-Yes");
			String inString = input.nextLine();
			int ans = Integer.parseInt(inString);
			if (ans == 1) {
				transact.setDoctor(doc);
				transact.startCharge();
				Float currentBalance = transact.getCharge().getCurrentBalance();
				Float newSalary = transact.getPatient().getFunds().getSalary() - currentBalance;
				transact.getPatient().getFunds().setSalary(newSalary);
				transact.getCharge().setCurrentBalance(0f);
				patient = transact.getPatient();
				System.out.println("old salary...." + oldSalary);
				System.out.println("new salary...." + patient.getFunds().getSalary());
				System.out.println("net..........." + (oldSalary - patient.getFunds().getSalary()));

				transact = storeTransaction(transact);
			}
		} else {
			System.out.println("Person does not exist");
		}

		System.out.println("Transaction - Done ... ");
		return transact;
	}

	/**
	 * The main method of the program.
	 *
	 * @param args Command-line arguments (not used in this program).
	 */
	public static void main(String[] args) {
		// Initialize a list to store transactions
		ArrayList<Transaction> transact_database = new ArrayList<>();
		boolean again = false;
		do {
			Transaction transact = null;
			ArrayList<Person> personDatabase = getPersonData();
			System.out.println("Loading ... clinic database");
			printList(personDatabase);

			transact = new Transaction();

			// ===================================================
			Receptionist rec = new Receptionist(randomPerson(personDatabase));
			rec.setAppointments(appointmentForm());
			rec.setCurrentTimedate(new Date());
			transact.setReceptionist(rec);
			System.out.println(
					"Loading ... a random Receptionist [" + rec.getName().getFname() + "] will be helping you:");
			Patient patient = new Patient(randomPerson(personDatabase));
			Float oldSalary = patient.getFunds().getSalary();
			// ===================================================
			System.out.println("Random Patient - " + patient);
			System.out.println("  Patient current salary -> $" + patient.getFunds().getSalary());
			transact.setPatient(patient);
			System.out.println("Patient >>  " + rec.getAppointments().getApptType());
			personDatabase.add(patient);
			transact = checkInProcess(transact, personDatabase, oldSalary);
			rec.setTransactions(transact);

			transact_database.add(transact);

			printTransaction(transact_database);

			// Ask if the user wants to repeat the process
			System.out.println("1-Again");
			String againString = input.nextLine();
			again = againString.toUpperCase().charAt(0) == '1' ? true : false;
			System.out.println(">>Again");
		} while (again);
		System.out.println("Done....");
	}

	/**
	 * This method creates an appointment for the patient.
	 *
	 * @return The appointment object.
	 */
	private static Appointment appointmentForm() {
		Appointment p = new Appointment();
		System.out
				.println("Do you have an appointment or is this just a walk-in visit?\n 1-appointment\n Else-Walk-in");
		String in = input.nextLine();
		String purpose;
		if (Integer.parseInt(in.charAt(0) + "") == 1) {
			System.out.println("You may see the doctor now");
			purpose = "Appointment";
		} else {
			purpose = "Walk-in";
		}
		p.setApptType(purpose);
		return p;
	}

	/**
	 * This method prints the details of all transactions in the database.
	 *
	 * @param transact_database The list of transactions.
	 */
	private static void printTransaction(ArrayList<Transaction> transact_database) {
		int i = 0;
		for (Transaction transaction : transact_database) {
			System.out.println(" =========== Transaction Receipt ======== ");
			System.out.print(" row#[" + i + "] ");
			System.out.print(" | T-ID = " + transaction.getTransactID());
			System.out.print(" | T-Receptionist = ID=" + transaction.getReceptionist().getId() + " - "
					+ transaction.getReceptionist().getName().getFname());
			System.out.print(" | T-Doctor Observation= " + transaction.getDoctor().getObservations());
			System.out.print(" | T-Patient reason= " + transaction.getPatient().getReasonVisit());
			System.out.print(" | T-Patient salary= " + transaction.getPatient().getFunds().getSalary());
			System.out.print(" | T-Patient balance= " + transaction.getPatient().getFunds().getCurrentBalance());
			System.out.print(" | T-Charge = " + transaction.getCharge().getCurrentBalance());
			System.out.println(" | T-TransactDate = " + transaction.getTransactDate());
			System.out.println(" ========================================= ");
			i++;
		}
	}

	/**
	 * This method stores the transaction with a timestamp.
	 *
	 * @param transact The transaction to be stored.
	 * @return The transaction with the timestamp.
	 */
	private static Transaction storeTransaction(Transaction transact) {
		Transaction t = transact;
		Date timeStamp = new Date();
		t.setTransactDate(timeStamp);
		return t;
	}

	/**
	 * This method selects a random person from the database.
	 *
	 * @param personDatabase The list of persons.
	 * @return A randomly selected person.
	 */
	private static Person randomPerson(ArrayList<Person> personDatabase) {
		return personDatabase.get(new Random().nextInt(0, personDatabase.size() - 1));
	}

	/**
	 * This method prints the list of persons (patients) in the database.
	 *
	 * @param personDatabase The list of persons.
	 */
	private static void printList(ArrayList<Person> personDatabase) {
		int i = 0;
		for (Person person : personDatabase) {
			System.out.println("[" + i + "]=>" + person);
			i++;
		}
	}

	/**
	 * This method generates and returns a list of persons (patients) for the
	 * database.
	 *
	 * @return The list of persons.
	 */
	private static ArrayList<Person> getPersonData() {
		// Create an instance of the StackOfPersons class (30-100)
		int max = new Random().nextInt(30, 100);

		// Create an instance of the StackOfPersons class
		StackOfPersons stack = new StackOfPersons(max);
		// Populate the stack with initial data
		bulkStackPersons(stack, max);
		stack.printAllPersons();
		return convertStackToArrayList(stack);
	}

	/**
	 * This method populates the stack with a specified number of persons
	 * (patients).
	 *
	 * @param stk The stack of persons.
	 * @param num The number of persons to add.
	 * @return The populated stack.
	 */
	private static StackOfPersons bulkStackPersons(StackOfPersons stk, int num) {

		for (int i = 0; i < num - 1; i++) {

			Person newPerson1 = new Person();
			stk.push(newPerson1);

		}
		return stk;
	}

	/**
	 * This method converts the stack of persons to an ArrayList.
	 *
	 * @param stack The stack of persons.
	 * @return The ArrayList containing persons.
	 */
	private static ArrayList<Person> convertStackToArrayList(StackOfPersons stack) {
		ArrayList<Person> arrayList = new ArrayList<>();
		System.out.println("Stack size = " + stack.getPersonCount());
		System.out.println("ArrayList size = " + arrayList.size());
		int i = 0;
		for (i = stack.getPersonCount(); i > 0; i--) {
			arrayList.add(stack.pop());
		}
		System.out.println("Stack size = " + stack.getPersonCount());
		System.out.println("ArrayList size = " + arrayList.size());

		return arrayList;
	}
}
