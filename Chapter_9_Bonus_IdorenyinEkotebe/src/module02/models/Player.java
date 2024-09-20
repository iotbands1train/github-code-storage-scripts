package module02.models;

/**
 * This class represents a Player in a sports team.
 */
public class Player {

    // Private instance variables to store player attributes
    private int jerseyNum;
    private String fname;
    private String lname;
    private String position;
    private int years;

    /**
     * Default constructor for creating a Player object.
     */
    public Player() {
        super();
    }

    /**
     * Parameterized constructor for creating a Player object with specific attributes.
     *
     * @param jeresyNum The jersey number of the player.
     * @param fname     The first name of the player.
     * @param lname     The last name of the player.
     * @param position  The position of the player (Guard, Forward, or Center).
     * @param years     The number of years the player has been active.
     */
    public Player(int jeresyNum, String fname, String lname, String position, int years) {
        super();
        this.jerseyNum = jeresyNum;
        this.fname = fname;
        this.lname = lname;
        this.position = position;
        this.years = years;
    }

    /**
     * Parameterized constructor for creating a Player object with a specific position.
     *
     * @param position The position of the player (Guard, Forward, or Center).
     */
    public Player(String position) {
        super();
        this.position = position;
    }

    /**
     * Copy constructor for creating a Player object by copying attributes from another player.
     *
     * @param p Another Player object to copy attributes from.
     */
    public Player(Player p) {
        super();
        this.jerseyNum = p.jerseyNum;
        this.fname = p.fname;
        this.lname = p.lname;
        this.position = p.position;
        this.years = p.years;
    }

    // Getter and setter methods for accessing and modifying attributes

    public int getJerseyNum() {
        return jerseyNum;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYears() {
        return years;
    }

    /**
     * Returns a string representation of the Player object.
     *
     * @return A string containing player attributes.
     */
    @Override
    public String toString() {
        return "Player [jeresyNum=" + jerseyNum + ", fname=" + fname + ", lname=" + lname +
                ", position=" + position + ", years=" + years + "]";
    }
}
