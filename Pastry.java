/**
 * Represents a baked item that may be warmed for an extra fee.
 * @author Romer Enardecido
 * @version 1.0
 */
public class Pastry extends MenuItem {
    private boolean warmed;

    /** Creates a pastry with default menu-item values that is not warmed. */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Creates a pastry with the supplied details.
     * @param name pastry name
     * @param basePrice pastry base price
     * @param itemCode pastry code
     * @param warmed whether the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes the pastry price, including the warming fee when applicable.
     * @return final pastry price
     */
    @Override
    public double computePrice() {
        // Warming adds 10 pesos to the pastry price.
        if (warmed) {
            return basePrice + 10;
        }
        return basePrice;
    }

    /**
     * Returns the pastry description and warming status.
     * @return pastry description
     */
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }

    /** @return true when the pastry is warmed */
    public boolean isWarmed() { return warmed; }

    /**
     * Changes the pastry's warming status.
     * @param warmed new warming status
     */
    public void setWarmed(boolean warmed) { this.warmed = warmed; }
}
