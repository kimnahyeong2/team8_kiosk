import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompletedOrder {
    //완료 주문객체를 담는 바구니 CompletedOrder.completedOrderList로 사용할 수 있어요.
//    static List<CompletedOrder> completedList = new ArrayList<>();
    private int orderNumber; // 대기 번호
    private double totalPrice; // 총 가격
    private LocalDateTime orderTime; // 주문 일시
    private LocalDateTime completedTime; // 완료주문 일시
    private String request; // 요청 사항

    //state는 현재 상품의 상태를 나타냅니다. 1: 준비중, 2:완료
    private int state;

    public CompletedOrder(String name) {
    }

    //상품 이름이 담겨있는 배열입니다.
    private String[] completedList;
    public String[] getCompletedList() {
        return completedList;
    }

    public CompletedOrder(int orderNumber, String[] completedList, double totalPrice, String request) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.request = request;
        this.completedList = completedList;
        this.completedTime = LocalDateTime.now();   //이렇게 하는게 최신날짜를 적용하는게 맞는지 헷갈리네요
        this.state = 2;                         //완료주문은 항상 state가 2라서 argument에서 제외했습니다.
    }


    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public String getRequest() {
        return request;
    }
    public LocalDateTime getCompletedTime() {
        return completedTime;
    }
    // 완료주문 일시
    public void setCompletedTime(LocalDateTime completedTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        this.completedTime = completedTime;
    }

//    @Override
//    public String toString() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
//        String result = "대기 번호 : " + orderNumber + "\n" +
//                "주문 총 가격 : " + totalPrice + "\n" +
//                "주문 일시 : " + orderTime.format(formatter) + "\n" +
//                "요청 사항 : " + request + "\n" +
//                "완료주문 일시 : " + completedTime.format(formatter) + "\n" +
//                "주문 상품 목록 : \n";
//
//        for (CompletedOrder completed : completedList) {
//            result += "- " + completed + "\n";
//        }
//
//        return result;
//    }
}