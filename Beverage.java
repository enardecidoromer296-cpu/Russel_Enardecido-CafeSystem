public class Beverage extends MenuItem {
    private String size;

    public Beverage() {
        super();
        size = "S";
    }

    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    @Override
    public double computePrice() {
        // Large beverages add 25 pesos to the base price.
        if (size.equals("L")) {
            return basePrice + 25;
        // Medium beverages add 15 pesos to the base price.
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }


    public String getSize() { return size; }

    public void setSize(String size) {
        if ("S".equals(size) || "M".equals(size) || "L".equals(size)) {
            this.size = size;
        }
    }
}
