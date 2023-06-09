import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

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

    public void complete(int number){
        OrderData completeOrderData = OrderData.orderedDataList.get(number-1);
        //번호표를 -1해줌
        Main.waiting--;

        //상태를 완료주문으로 변경
        completeOrderData.setState(2);
        //완료 주문일시로 갱신
        completeOrderData.setOrderedDate(LocalDateTime.now());
    }
}