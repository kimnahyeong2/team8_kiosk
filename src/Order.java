import java.util.ArrayList;

public class Order {

    private  final ArrayList<Product> wishlist;
    private final ArrayList<Product> selledlist = new ArrayList<>();

    public Order() {
        this.wishlist = new ArrayList<>();
    }

    public ArrayList<Product> getWishlist() {
        return wishlist;
    }

    public void add(Product product){
        wishlist.add(product);
    }

    public ArrayList<Product> getSelledlist() {
        return selledlist;
    }

    public void clear(){
        wishlist.clear();
    }
    public void addSelledList(Product product){
        selledlist.add(product);
    }

}