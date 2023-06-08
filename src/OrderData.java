import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderData {

    //주문목록
    static List<OrderData> orderedDataList = new ArrayList<>();

    //대기번호
    int waitingNumber;

    //구매상품목록
    ArrayList<Product> orderedProductList;

    //총 구매 가격
    double totalPrice;
    //요구사항메세지
    String requiredMsg;
    //주문일자 or 완료일자
    Date orderedDate;
    //상태 1: 대기주문 2: 완료주문
    int state;

    public OrderData(int waitingNumber, ArrayList<Product> orderedProductList, double totalPrice, String requiredMsg, Date orderedDate, int state) {
        this.waitingNumber = waitingNumber;
        this.orderedProductList = orderedProductList;
        System.out.println(orderedProductList.get(0).getName());
        this.totalPrice = totalPrice;
        this.requiredMsg = requiredMsg;
        this.orderedDate = orderedDate;
        this.state = state;
    }

    public List<OrderData> getOrderedDataList() {
        return orderedDataList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    public int getWaitingNumber() {
        return waitingNumber;
    }

    public void setWaitingNumber(int waitingNumber) {
        this.waitingNumber = waitingNumber;
    }

    public List<Product> getOrderedProductList() {
        return orderedProductList;
    }

    public void setOrderedProductList(ArrayList<Product> orderedProductList) {
        this.orderedProductList = orderedProductList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRequiredMsg() {
        return requiredMsg;
    }

    public void setRequiredMsg(String requiredMsg) {
        this.requiredMsg = requiredMsg;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }



    @Override
    public String toString() {
        //값이 담기질 않아 값이 없습니다가 출력됩니다.
        if(orderedProductList.isEmpty()){
            System.out.println("orderedProductList 안의 값이 없습니다.");
        }

        StringBuilder st = new StringBuilder();
        for(Product product : orderedDataList.get(0).orderedProductList){
            st.append(product.getName());
        }

        return "OrderData{" +
                "대기번호=" + waitingNumber +
                ", 주문상품목록= " + st.toString() +
                ", 총 가격=" + totalPrice +
                ", 요청사항='" + requiredMsg + '\'' +
                ", 주문일자=" + orderedDate +
                ", 상태=" + state +
                '}';
    }
}