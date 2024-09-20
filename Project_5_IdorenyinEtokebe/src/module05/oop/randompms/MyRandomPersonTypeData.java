package module05.oop.randompms;

import java.util.ArrayList;
import java.util.Random;

/**
 * The MyRandomPersonTypeData class provides methods for generating random data
 * related to different attributes of person types like observations,
 * prescriptions, reason for visit, insurance, and appointments.
 */
public class MyRandomPersonTypeData {

	/**
	 * Generates a random observation for a person.
	 * 
	 * @return A random observation.
	 */
	public static String random_observation() {
		String[] OBSERVATIONS = { "1*see a specialization doctor", "2*common illness", "3*need x-ray visit" };
		return randomElementFromStringArray(OBSERVATIONS);
	}

	/**
	 * Generates a random prescription for a person.
	 * 
	 * @return A random prescription.
	 */
	public static String random_prescription() {
		String[] PRESCRIPTION = { "3*Antibiotics and plenty of rest", "2*Pain relievers and fluids",
				"3*Anti-inflammatory medication", "2*Prescription medication as directed",
				"4*Physical therapy sessions", "5*Specialized treatment plan", "1*Follow-up appointments" };
		return randomElementFromStringArray(PRESCRIPTION);
	}

	/**
	 * Generates a random reason for a person's visit.
	 * 
	 * @return A random reason for visit.
	 */
	public static String random_reasonVisit() {
		String[] REASON_VISITS = { "Routine checkup", "Flu symptoms", "Injury assessment", "Follow-up appointment",
				"X-ray required", "Health consultation", "Vaccination", "Chronic condition management" };
		return randomElementFromStringArray(REASON_VISITS);
	}

	/**
	 * Generates a random boolean value indicating whether a person has insurance.
	 * 
	 * @return True if the person has insurance, false otherwise.
	 */
	public static boolean random_hasInsurance() {
		return new Random().nextBoolean();
	}

	/**
	 * Generates a list of random appointment types for a person.
	 * 
	 * @return A list of random appointment types.
	 */
	public static ArrayList<String> random_appointments() {
		String[] APPOINTMENT_TYPES = { "Consultation", "Follow-up", "Diagnostic", "Procedure" };
		int numAppointments = new Random().nextInt(1, APPOINTMENT_TYPES.length);
		ArrayList<String> appointments = new ArrayList<>();
		for (int i = 0; i < numAppointments; i++) {
			String randomAppointment = randomElementFromStringArray(APPOINTMENT_TYPES);
			appointments.add(randomAppointment);
		}
		return appointments;
	}

	/**
	 * Generates a random element from a given string array.
	 * 
	 * @param arr The string array from which to select a random element.
	 * @return A random element from the array.
	 * @throws IllegalArgumentException if the array is null or empty.
	 */
	public static String randomElementFromStringArray(String[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array must not be null or empty");
		}
		int randomIndex = new Random().nextInt(arr.length);
		return arr[randomIndex];
	}
}
