
public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    
    public Meal(String name, double basePrice, String itemCode,
                boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    @Override
    public double computePrice() {
        double price = basePrice;
        // Upsizing adds 20 pesos.
        if (upsized) {
            price += 20;
        }
        return price + (12 * extraSides);
    }

    
    @Override
    public String getDescription() {
        String sizeStatus = upsized ? "Upsized" : "Regular";
        String sideLabel = extraSides == 1 ? "side" : "sides";
        return super.getDescription() + " " + sizeStatus + ", "
                + extraSides + " " + sideLabel;
    }

    public boolean isUpsized() { return upsized; }

    
    public void setUpsized(boolean upsized) { this.upsized = upsized; }

    
    public int getExtraSides() { return extraSides; }

    
    public void setExtraSides(int extraSides) {
        // Extra sides cannot be negative.
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}
