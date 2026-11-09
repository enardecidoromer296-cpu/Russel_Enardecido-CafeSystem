/**
 * Represents a customer who can earn loyalty points.
 * @author Romer Enardecido
 * @version 1.0
 */
public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    /** Creates a non-student customer with a default name. */
    public Customer() {
        this("Unknown Customer", false);
    }

    /**
     * Creates a non-student customer with the supplied name.
     * @param name customer name
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Creates a customer with a name and student status.
     * @param name customer name
     * @param student true when the customer is a student
     */
    public Customer(String name, boolean student) {
        setName(name);
        this.student = student;
        loyaltyPoints = 0;
    }

    /**
     * Adds a specified number of loyalty points.
     * @param points points to add
     */
    public void addPoints(int points) {
        if (points > 0) loyaltyPoints += points;
    }

    /**
     * Adds one point for every 50 pesos spent.
     * @param amountSpent amount paid in pesos
     */
    public void addPoints(double amountSpent) {
        if (amountSpent > 0) loyaltyPoints += (int) (amountSpent / 50);
    }

    /** @return customer name */
    public String getName() { return name; }

    /**
     * Updates the customer name when it is not blank.
     * @param name new customer name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }

    /** @return true when the customer is a student */
    public boolean isStudent() { return student; }

    /**
     * Updates the customer's student status.
     * @param student new student status
     */
    public void setStudent(boolean student) { this.student = student; }

    /** @return current loyalty points */
    public int getLoyaltyPoints() { return loyaltyPoints; }

    /**
     * Sets loyalty points when the value is not negative.
     * @param loyaltyPoints new loyalty-point balance
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) this.loyaltyPoints = loyaltyPoints;
    }
}
