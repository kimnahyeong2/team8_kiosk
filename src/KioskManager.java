import java.util.List;
import java.util.Scanner;

public class KioskManager {

    static Order order = new Order();


    public void callManager(){
        System.out.println("키오스크 관리 프로그램입니다.");
        System.out.println("1. 대기주문 목록 2. 완료주문 목록 3. 상품 생성 4. 상품 삭제, 0.처음으로");
        int answer = input();

        switch (answer){
            case 1 -> {getWaitingList();break;}
            case 2 -> {break;}
            case 3 -> {break;}
            case 4 -> {break;}
            case 0 -> {break;}

        }
    }
    public void getCurrentOrderList(){
        System.out.println("[ 최근 완료한 주문 ]");
        List<OrderData> currentOrderList = OrderData.orderedDataList;
        if(currentOrderList.isEmpty()){
            System.out.println("완료된 주문이 존재하지 않습니다.");
        }
        else{
            for(OrderData orderData : currentOrderList){
                if(orderData.getState() == 2){
                    System.out.println(orderData);
                }
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("[ 대기중인 주문 ] ");
        if(currentOrderList.isEmpty()){
            System.out.println("대기중인 주문이 존재하지 않습니다.");
        }
        else{
            for(OrderData orderData : currentOrderList){
                if(orderData.getState() == 1){
                    System.out.println(orderData);
                }
            }
        }
    }
    public void getWaitingList() {
        System.out.println("현재 대기 주문 목록입니다.");
        List<OrderData> waitingList = OrderData.orderedDataList;

        if (waitingList.isEmpty()) {
            System.out.println("대기 주문 목록이 없습니다.");

        } else {
            System.out.println("대기중인 주문 목록을 보여줍니다.");

            for (OrderData waitingData : waitingList) {
                //대기주문중인(1) OrderData만 출력
                if(waitingData.getState() == 1){
                    System.out.println(waitingData);
                }
            }
            System.out.println("[현재상태]를 완료로 변경하실 [주문번호]를 입력해주세요");
            System.out.println("0: 돌아가기");
            int answer = input();
            if(answer == 0){
                callManager();
            }
            else{
                order.complete(answer);
                System.out.println("상품이 완료주문으로 변경되었습니다.");
                getWaitingList();
            }
        }
    }


    public int input(){
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }
}