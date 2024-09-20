package module05.oop.models.transact;

import java.util.Date;
import java.util.Random;

import module05.oop.models.Funds;
import module05.oop.models.Person;
import module05.oop.models.types.Doctor;
import module05.oop.models.types.Patient;
import module05.oop.models.types.Receptionist;

/**
 * The Transaction class represents a medical transaction with various attributes.
 */
public class Transaction {
    
    // Private attributes for storing transaction details.
    private Long transactID;
    private Date transactDate;
    private Doctor doctor;
    private Receptionist receptionist;
    private Patient patient;
    private Funds charge; 

    /**
     * Get the financial charge associated with the transaction.
     * @return The charge information.
     */
    public Funds getCharge() {
        return charge;
    }

    /**
     * Set the financial charge associated with the transaction.
     * @param charge The charge information to set.
     */
    public void setCharge(Funds charge) {
        this.charge = charge;
    }

    /**
     * Initializes the financial charge for the transaction.
     */
    public void startCharge() {
        // Calculate charge and set balance
        int points = getTotalPoints();    
        Float currentCost = getCostByPoints(points);        
        charge = new Funds();
        charge.setSalary(doctorValue());
        currentCost = insuranceCheck(currentCost); 
        charge.setCurrentBalance(currentCost);
    }

    // Private methods for calculating charges...

    /**
     * Calculate the doctor's percentage value for the charge.
     * @return The doctor's percentage value.
     */
    private Float doctorValue() {
        Float percentCost = doctor.getFunds().getSalary();
        percentCost = percentCost * 0.01f;
        return percentCost;
    }

    /**
     * Adjust the current cost based on insurance coverage.
     * @param currentCost The current cost to adjust.
     * @return The adjusted cost after considering insurance.
     */
    private Float insuranceCheck(Float currentCost) {
        if (patient.isHasInsurance()) {
            currentCost = (float) (currentCost - (currentCost * 0.65));
        }
        return currentCost;
    }

    /**
     * Get the cost based on total points accumulated.
     * @param points The total points.
     * @return The cost based on the points.
     */
    private Float getCostByPoints(int points) {
        Float balance = 0f;
        if (points < 3) {
            balance = 175.00f;
        } else if (points < 6) {
            balance = 675.00f;             
        } else {
            balance = 1275.00f;             
        }
        return balance;
    }

    /**
     * Calculate the total points by adding points from observations and prescriptions.
     * @return The total points.
     */
    private int getTotalPoints() {
        int total = 0;
        total += pointString(doctor.getObservations());
        total += pointString(doctor.getPrescription());
        return total;
    }

    /**
     * Get the integer value of the first character in a string.
     * @param str The input string.
     * @return The integer value of the first character.
     */
    private int pointString(String str) { 
        return Integer.parseInt(str.charAt(0) + ""); 
    }

    /**
     * Constructs an empty Transaction object with a randomly generated transaction ID and current date.
     */
    public Transaction() {
        super();
        transactID = new Random().nextLong(4444000001L, 4445000001L);
        transactDate = new Date();
    }

    // Getter and setter methods for the class attributes...

    @Override
    public String toString() {
        return "Transaction [transactID=" + transactID + ", transactDate=" +
                transactDate + ", doctor= Dr. " + doctor.getName().getLname()
                + " with ID=[" + doctor.getId() + "], receptionist=" +
                receptionist.getName().getFname() + " with ID=["
                + receptionist.getId() + "], patient=" + patient.getName().getFname() +
                " " + patient.getReasonVisit() + "]";
    }
    /**
     * Get the patient associated with this transaction.
     * @return The patient.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Set the doctor associated with this transaction.
     * @param doc The doctor to set.
     */
    public void setDoctor(Doctor doc) {
        this.doctor = doc;
    }

    /**
     * Set the receptionist associated with this transaction.
     * @param rec The receptionist to set.
     */
    public void setReceptionist(Receptionist rec) {
        this.receptionist = rec;
    }

    /**
     * Set the patient associated with this transaction.
     * @param patient The patient to set.
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Get the transaction ID as a string.
     * @return The transaction ID as a string.
     */
    public String getTransactID() {
        return transactID + "";
    }

    /**
     * Get the receptionist associated with this transaction.
     * @return The receptionist.
     */
    public Person getReceptionist() {
        return receptionist;
    }

    /**
     * Get the doctor associated with this transaction.
     * @return The doctor.
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Get the transaction date as a string.
     * @return The transaction date as a string.
     */
    public String getTransactDate() {
        return transactDate + "";
    }

    /**
     * Set the transaction date with the given timestamp.
     * @param timeStamp The timestamp to set as the transaction date.
     */
    public void setTransactDate(Date timeStamp) {
        transactDate = timeStamp;
    }
}

