import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompletedOrder {
    private int orderNumber; // 대기 번호
    private double totalPrice; // 총 가격
    private LocalDateTime completedTime; // 완료주문 일시
    private String request; // 요청 사항

    //state는 현재 상품의 상태를 나타냅니다. 1: 준비중, 2:완료
    private int state;

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
}