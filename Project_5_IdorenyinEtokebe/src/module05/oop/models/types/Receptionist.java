package module05.oop.models.types;
 
import java.util.Date;

import module05.oop.models.Contact;
import module05.oop.models.Funds;
import module05.oop.models.Location;
import module05.oop.models.Name;
import module05.oop.models.Person;
import module05.oop.models.transact.Appointment;
import module05.oop.models.transact.Transaction;

/**
 * The Receptionist class represents a receptionist entity with various attributes.
 */
public class Receptionist extends Person {

    private Date currentTimedate;
    private Appointment appointments;
    private Transaction transactions;
    private Person person;

    /**
     * Create a Receptionist instance with the specified current time and date,
     *  appointments, and transactions.
     * @param currentTimedate The current time and date.
     * @param appointments   The appointments associated with the receptionist.
     * @param transactions   The transactions associated with the receptionist.
     */
    public Receptionist(Date currentTimedate, Appointment appointments, Transaction transactions) {
        super();
        this.currentTimedate = currentTimedate;
        this.appointments = appointments;
        this.transactions = transactions;
    }

    /**
     * Create an empty Receptionist instance.
     */
    public Receptionist() {
        super();
    }

    /**
     * Create a Receptionist instance with the specified ID, name, location, contact, and funds.
     * @param id       The ID of the receptionist.
     * @param name     The name of the receptionist.
     * @param location The location of the receptionist.
     * @param contact  The contact details of the receptionist.
     * @param funds    The funds associated with the receptionist.
     */
    public Receptionist(Long id, Name name, Location location, Contact contact, Funds funds) {
        super(id, name, location, contact, funds);
    }

    /**
     * Create a Receptionist instance with the data from a Person object.
     * @param p The Person object to create the receptionist from.
     */
    public Receptionist(Person p) {
        super(p);
        person = p;
    }

    /**
     * Get the current time and date of the receptionist.
     * @return The current time and date.
     */
    public Date getCurrentTimedate() {
        return currentTimedate;
    }

    /**
     * Set the current time and date for the receptionist.
     * @param currentTimedate The current time and date to set.
     */
    public void setCurrentTimedate(Date currentTimedate) {
        this.currentTimedate = currentTimedate;
    }

    /**
     * Get the appointments associated with the receptionist.
     * @return The appointments.
     */
    public Appointment getAppointments() {
        return appointments;
    }

    /**
     * Set the appointments for the receptionist.
     * @param appointments The appointments to set.
     */
    public void setAppointments(Appointment appointments) {
        this.appointments = appointments;
    }

    /**
     * Get the transactions associated with the receptionist.
     * @return The transactions.
     */
    public Transaction getTransactions() {
        return transactions;
    }

    /**
     * Set the transactions for the receptionist.
     * @param transactions The transactions to set.
     */
    public void setTransactions(Transaction transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Receptionist [currentTimedate=" + currentTimedate +
        		", appointments=" + appointments + ", transactions="
                + transactions + ", person-data: " + person + "]";
    }
}

