package module05.oop.models.types;
 
import module05.oop.models.Person;

/**
 * The Doctor class represents a type of person with medical attributes.
 */
public class Doctor extends Person {
    
    private String observations;
    private String prescription;
    private Person person;

    /**
     * Constructs a Doctor object with specified observations and prescription.
     * @param observations The medical observations.
     * @param prescription The medical prescription.
     */
    public Doctor(String observations, String prescription) {
        super();
        this.observations = observations;
        this.prescription = prescription;
    }

    /**
     * Constructs an empty Doctor object.
     */
    public Doctor() {
        super();
    }

    /**
     * Constructs a Doctor object based on an existing person with salary update.
     * @param p The existing person.
     */
    public Doctor(Person p) {
        super(updateDoctorSalary(p));
        person = p;
    }

    /**
     * Update the salary of a person to reflect doctor's additional salary.
     * @param p The person object to update.
     * @return The updated person object with the new salary.
     */
    public static Person updateDoctorSalary(Person p) {
        Float salary = p.getFunds().getSalary();
        salary += 75_000.00f;
        p.getFunds().setSalary(salary);
        return p;
    }

    /**
     * Get the medical observations made by the doctor.
     * @return The medical observations.
     */
    public String getObservations() {
        return observations;
    }

    /**
     * Set the medical observations made by the doctor.
     * @param observations The medical observations to set.
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }

    /**
     * Get the medical prescription given by the doctor.
     * @return The medical prescription.
     */
    public String getPrescription() {
        return prescription;
    }

    /**
     * Set the medical prescription given by the doctor.
     * @param prescription The medical prescription to set.
     */
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    
    /**
     * @return a formatted string output for an instance of this class.
     */

    @Override
    public String toString() {
        return "Doctor [observations=" + observations + ", prescription=" + prescription + ", person-data: " + person + "]";
    }
}

