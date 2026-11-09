/**
 * Represents a rice meal with optional upsizing and extra sides.
 * @author Romer Enardecido
 * @version 1.0
 */
public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    /** Creates a regular meal with no extra sides. */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Creates a meal with the supplied details.
     * @param name meal name
     * @param basePrice meal base price
     * @param itemCode meal code
     * @param upsized whether the meal is upsized
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode,
                boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /**
     * Computes the meal price including upgrades and extra sides.
     * @return final meal price
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Upsizing adds 20 pesos.
        if (upsized) {
            price += 20;
        }
        return price + (12 * extraSides);
    }

    /**
     * Returns the meal description including its options.
     * @return meal description
     */
    @Override
    public String getDescription() {
        String sizeStatus = upsized ? "Upsized" : "Regular";
        String sideLabel = extraSides == 1 ? "side" : "sides";
        return super.getDescription() + " " + sizeStatus + ", "
                + extraSides + " " + sideLabel;
    }

    /** @return true when the meal is upsized */
    public boolean isUpsized() { return upsized; }

    /**
     * Changes the meal's upsize status.
     * @param upsized new upsize status
     */
    public void setUpsized(boolean upsized) { this.upsized = upsized; }

    /** @return number of extra sides */
    public int getExtraSides() { return extraSides; }

    /**
     * Sets the number of extra sides; negative values are rejected.
     * @param extraSides requested number of extra sides
     */
    public void setExtraSides(int extraSides) {
        // Extra sides cannot be negative.
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}
