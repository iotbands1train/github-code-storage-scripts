package module05.oop.models;

import module05.oop.randompms.MyRandomPersonData;

/**
 * The `Location` class represents a physical address with a unique location ID, street number, street name, city, state, and ZIP code.
 */
public class Location {
    private Long locationID;
    private Short streetNo;
    private String streetName;
    private String city;
    private String state;
    private Integer zip;

    /**
     * Constructs a `Location` object with randomly generated address data.
     */
    public Location() {
        super();
        // Generate a random street number in the range [1, 21222]
        this.streetNo = (short) Math.abs(MyRandomPersonData.random(1, 21222));
        this.streetName = MyRandomPersonData.randomStreet();
        this.city = MyRandomPersonData.randomCity();
        this.state = MyRandomPersonData.randomState();
        // Generate a random ZIP code in the range [21222, 92992]
        this.zip = (int) Math.abs(MyRandomPersonData.random(21222, 92992));
        // Combine values to create a unique location ID
        String combinedValue = streetNo + streetName + city + state + zip;
        this.locationID = charsDecimalValuesOfString(combinedValue);
    }

    /**
     * Constructs a `Location` object with the given address components.
     *
     * @param streetNo   The street number.
     * @param streetName The street name.
     * @param city       The city.
     * @param state      The state.
     * @param zip        The ZIP code.
     */
    public Location(Short streetNo, String streetName, String city, String state, Integer zip) {
        super();
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        // Combine values to create a unique location ID
        String combinedValue = streetNo + streetName + city + state + zip;
        this.locationID = charsDecimalValuesOfString(combinedValue);
    }
    
    /**
     * Calculates the decimal values of characters in a string.
     *
     * @param input The string input to use.
     * @return The result of that calculation.
     * 
     */

    // Private method to calculate the decimal values of characters in a string
    private long charsDecimalValuesOfString(String input) {
        long result = 0;
        for (char c : input.toCharArray()) {
            result += (long) c; // Adding the decimal value of the character
        }
        return result;
    }

    /**
     * Gets the unique location ID.
     *
     * @return The location ID.
     */
    public Long getLocationID() {
        return locationID;
    }

    /**
     * Sets the unique location ID.
     *
     * @param locationID The location ID to set.
     */
    public void setLocationID(Long locationID) {
        this.locationID = locationID;
    }

    /**
     * Gets the street number.
     *
     * @return The street number.
     */
    public Short getStreetNo() {
        return streetNo;
    }

    /**
     * Sets the street number.
     *
     * @param streetNo The street number to set.
     */
    public void setStreetNo(Short streetNo) {
        this.streetNo = streetNo;
    }

    /**
     * Gets the street name.
     *
     * @return The street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the street name.
     *
     * @param streetName The street name to set.
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets the city.
     *
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     *
     * @return The state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the ZIP code.
     *
     * @return The ZIP code.
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * Sets the ZIP code.
     *
     * @param zip The ZIP code to set.
     */
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    /**
     * Formats the ZIP code as a 5-digit string.
     *
     * @return The formatted ZIP code string.
     */
    private String showZip() {
        return String.format("%05d", zip);
    }

    /**
     * Returns a string representation of the `Location` object.
     *
     * @return A string containing location ID, street number, street name, city, state, and ZIP code.
     */
    @Override
    public String toString() {
        return " Location [locationID=" + locationID + ", streetNo=" + streetNo + ", streetName=" + streetName
                + ", city=" + city + ", state=" + state + ", zip=" + showZip() + "]";
    }
}
