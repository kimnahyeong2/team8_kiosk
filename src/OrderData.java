import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderData {

    //주문목록
    static List<OrderData> orderedDataList = new ArrayList<>();

    //대기번호
    int waitingNumber;

    //구매상품목록
    String[] nameList;

    //총 구매 가격
    double totalPrice;
    //요구사항메세지
    String requiredMsg;
    //주문일자 or 완료일자
    LocalDateTime orderedDate;
    //상태 1: 준비중 2: 완료
    int state;

    public OrderData(int waitingNumber, String[] nameList, double totalPrice, String requiredMsg,  int state) {
        this.waitingNumber = waitingNumber;
        this.nameList = nameList;
        this.totalPrice = totalPrice;
        this.requiredMsg = requiredMsg;
        this.orderedDate = LocalDateTime.now();
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

    public String[] getNameList() {
        return nameList;
    }

    public void setNameList(String[] nameList) {
        this.nameList = nameList;
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

    public LocalDateTime getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDateTime orderedDate) {
        this.orderedDate = orderedDate;
    }

    //여기에서만 쓰이므로 작성
    //state상태를 1이면 중 2이면 완료로 표시
    public String trancelateState(int state){
        return switch (state) {
            case 1 -> "준비중";
            case 2 -> "완료";
            default -> "알 수 없음";
        };
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for(String name : nameList){
            sb.append(name);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return  "\n[주문번호]\t: " + waitingNumber +
                "\n[주문상품]\t: " + sb +
                "\n[총 가격]\t: " + totalPrice +
                "\n[요청사항]\t: '" + requiredMsg + '\'' +
                "\n[주문일자]\t: " + orderedDate.format(formatter) +
                "\n[현재상태]:\t: " +trancelateState(state);
    }
}