import java.util.UUID;

public class Product extends Menu{
    private double price;
    private UUID productId;
    private int cnt = 1;

    public Product(String name, double price, String desc) {
        super(name, desc);
        this.price = price;
        this.productId = UUID.randomUUID();
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public UUID getProductId() { return productId; }

    public void setProductId(UUID productId) { this.productId = productId; }
    @Override
    public String toString() {
        return super.getName() +" | "+price+" | "+super.getDesc();
    }
    public String toString_cnt() {
        return super.getName() +" | "+price+" | "+cnt+"개 | "+super.getDesc();
    }

}