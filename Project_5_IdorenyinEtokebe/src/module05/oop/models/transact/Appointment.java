package module05.oop.models.transact;

/**
 * The Appointment class represents an appointment type.
 */
public class Appointment {

	private String apptType; // Stores the type of appointment.

	/**
	 * Constructs an empty Appointment object.
	 */
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs an Appointment object with a specified appointment type.
	 *
	 * @param apptType The type of appointment.
	 */
	public Appointment(String apptType) {
		super();
		this.apptType = apptType;
	}

	/**
	 * Gets the appointment type.
	 *
	 * @return The type of appointment.
	 */
	public String getApptType() {
		return apptType;
	}

	/**
	 * Sets the appointment type.
	 *
	 * @param apptType The type of appointment to set.
	 */
	public void setApptType(String apptType) {
		this.apptType = apptType;
	}

	/**
	 * Returns a string representation of the Appointment object.
	 *
	 * @return A string containing the appointment type.
	 */
	@Override
	public String toString() {
		return "Appointment [apptType=" + apptType + "]";
	}
}
