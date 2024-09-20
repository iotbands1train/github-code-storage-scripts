package module05.oop.models;

import module05.oop.randompms.MyRandomPersonData;

/**
 * The `Contact` class represents a contact with a phone number.
 */
public class Contact {
    private Long phone;

    /**
     * Constructs a `Contact` object with a randomly generated phone number.
     */
    public Contact() {
        super();
        // Generate a random phone number in the range [2141111111, 2149999999]
        this.phone = Math.abs(MyRandomPersonData.random(2141111111L, 2149999999L));
    }

    /**
     * Constructs a `Contact` object with the given phone number.
     *
     * @param phone The phone number to set for the contact.
     */
    public Contact(Long phone) {
        super();
        this.phone = phone;
    }

    /**
     * Gets the phone number of the contact.
     *
     * @return The phone number of the contact.
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the contact.
     *
     * @param phone The phone number to set for the contact.
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * Returns a string representation of the `Contact` object.
     *
     * @return A string containing the phone number of the contact.
     */
    @Override
    public String toString() {
        return " Contact [phone=" + phone + "]";
    }
}
