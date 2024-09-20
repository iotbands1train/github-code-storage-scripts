package module05.oop.models;

import module05.oop.randompms.MyRandomPersonData;

/**
 * The `Funds` class represents financial information including bank ID, salary, and current balance.
 */
public class Funds {
    private Long bankID;
    private Float salary;
    private Float currentBalance;

    /**
     * Constructs a `Funds` object with randomly generated financial data.
     */
    public Funds() {
        super();
        // Generate a random bank ID in the range [955111111, 956999999]
        this.bankID = Math.abs(MyRandomPersonData.random(955111111, 956999999));
        // Generate a random salary in the range [55000, 175000]
        this.salary = (float) Math.abs(MyRandomPersonData.random(55000, 175000));
        // Generate a random current balance in the range [0.001, 1244]
        this.currentBalance = (float) Math.abs(MyRandomPersonData.random(0.001, 1244));
    }

    /**
     * Constructs a `Funds` object with the given bank ID, salary, and current balance.
     *
     * @param bankID         The bank ID to set for the funds.
     * @param salary         The salary to set for the funds.
     * @param currentBalance The current balance to set for the funds.
     */
    public Funds(Long bankID, Float salary, Float currentBalance) {
        super();
        this.bankID = bankID;
        this.salary = salary;
        this.currentBalance = currentBalance;
    }

    /**
     * Gets the bank ID associated with the funds.
     *
     * @return The bank ID.
     */
    public Long getBankID() {
        return bankID;
    }

    /**
     * Sets the bank ID associated with the funds.
     *
     * @param bankID The bank ID to set.
     */
    public void setBankID(Long bankID) {
        this.bankID = bankID;
    }

    /**
     * Gets the salary of the funds.
     *
     * @return The salary.
     */
    public Float getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the funds.
     *
     * @param salary The salary to set.
     */
    public void setSalary(Float salary) {
        this.salary = salary;
    }

    /**
     * Gets the current balance of the funds.
     *
     * @return The current balance.
     */
    public Float getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Sets the current balance of the funds.
     *
     * @param currentBalance The current balance to set.
     */
    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * Formats a currency value with commas for thousands.
     *
     * @param c The currency value to format.
     * @return The formatted currency string.
     */
    public String currencies(Float c) {
        String x = "";
        x = String.format("$ %.2f", c);
        if (c > 999)
            x = String.format("$%,.2f", Float.parseFloat(x));
        return x;
    }

    /**
     * Formats the current balance as a currency string.
     *
     * @return The formatted current balance string.
     */
    public String showCurrentBalance() {
        String x = "";
        x = String.format("$ %.2f", currentBalance);
        if (currentBalance > 999)
            x = String.format("$ %,.2f", currentBalance);
        return x;
    }
    
    /**
     * Formats the current salary as a currency string.
     *
     * @return The formatted current balance string.
     */
    // Private method to format salary as a currency string
    private String showSalary() {
        return String.format("$ %,.2f", salary);
    }

    /**
     * Returns a string representation of the `Funds` object.
     *
     * @return A string containing bank ID, salary, and current balance.
     */
    @Override
    public String toString() {
        return " Funds [bankID = (" + bankID + "), salary = (" + showSalary() + "), currentBalance = ("
                + showCurrentBalance() + ") ] ";
    }
}
