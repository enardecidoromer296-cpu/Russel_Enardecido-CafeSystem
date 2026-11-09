
public class Pastry extends MenuItem {
    private boolean warmed;

    
    public Pastry() {
        super();
        warmed = false;
    }

   
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    @Override
    public double computePrice() {
        // Warming adds 10 pesos to the pastry price.
        if (warmed) {
            return basePrice + 10;
        }
        return basePrice;
    }
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }

    public boolean isWarmed() { return warmed; }

    public void setWarmed(boolean warmed) { this.warmed = warmed; }
}
