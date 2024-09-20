package module05.oop.models.types;

import module05.oop.models.Contact;
import module05.oop.models.Funds;
import module05.oop.models.Location;
import module05.oop.models.Name;
import module05.oop.models.Person;

/**
 * The Patient class represents a type of person with medical attributes.
 */
public class Patient extends Person {

    private String reasonVisit;
    private boolean hasInsurance;
    private Person person;

    /**
     * Constructs a Patient object with a reason for the visit and insurance status.
     * @param reasonVisit The reason for the patient's visit.
     * @param hasInsurance Indicates whether the patient has insurance.
     */
    public Patient(String reasonVisit, boolean hasInsurance) {
        super();
        this.reasonVisit = reasonVisit;
        this.hasInsurance = hasInsurance;
    }

    /**
     * Constructs an empty Patient object.
     */
    public Patient() {
        super();
    }

    /**
     * Constructs a Patient object with specified attributes.
     * @param id The ID of the patient.
     * @param name The name of the patient.
     * @param location The location information of the patient.
     * @param contact The contact information of the patient.
     * @param funds The financial information of the patient.
     */
    public Patient(Long id, Name name, Location location, Contact contact, Funds funds) {
        super(id, name, location, contact, funds);
    }

    /**
     * Constructs a Patient object based on an existing person.
     * @param p The existing person to represent as a patient.
     */
    public Patient(Person p) {
        super(p);
        person = p;
    }

    /**
     * Get the reason for the patient's visit.
     * @return The reason for the visit.
     */
    public String getReasonVisit() {
        return reasonVisit;
    }

    /**
     * Set the reason for the patient's visit.
     * @param reasonVisit The reason for the visit to set.
     */
    public void setReasonVisit(String reasonVisit) {
        this.reasonVisit = reasonVisit;
    }

    /**
     * Check if the patient has insurance.
     * @return True if the patient has insurance, otherwise false.
     */
    public boolean isHasInsurance() {
        return hasInsurance;
    }

    /**
     * Set the insurance status of the patient.
     * @param hasInsurance Indicates whether the patient has insurance.
     */
    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    @Override
    public String toString() {
        return "Patient [reasonVisit=" + reasonVisit + ", hasInsurance=" + hasInsurance + ", person-data: " + person + "]";
    }
}

