import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KioskManager {

    static Order order = new Order();
    private static List<CompletedOrder> completedList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public void callManager(){
        System.out.println("키오스크 관리 프로그램입니다.");
        System.out.println("1. 대기주문 목록 2. 완료주문 목록 3. 상품 생성 4. 상품 삭제, 0.처음으로");
        int answer = input();

        switch (answer){
            case 1 -> {getWaitingList();break;}
            case 2 -> {completeOrderList();break;}
            case 3 -> {createProduct();break;}
            case 4 -> {deleteProduct();break;}
            case 0 -> {break;}

        }
    }
    public void getCurrentOrderList() {
        System.out.println("[ 최근 완료한 주문 ]");
        List<OrderData> currentOrderList = OrderData.orderedDataList;

        List<OrderData> currentOrderList2 = new ArrayList<>(currentOrderList);
        Collections.reverse(currentOrderList2);

        if (currentOrderList2.isEmpty()) {
            System.out.println("완료된 주문이 존재하지 않습니다.");
        } else {
            int count = 0;
            for (OrderData orderData : currentOrderList2) {
                if (count < 3) {
                    if (orderData.getState() == 2) {
                        System.out.println(orderData);
                        count++;
                    }
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

                // 대기 주문에서 상품 목록 가져오기
                String[] orderedNameList = waitingList.get(answer - 1).getNameList();
                String[] completedProducts = new String[orderedNameList.length];
                for (int i = 0; i < orderedNameList.length; i++) {
                    completedProducts[i] = orderedNameList[i];
                }

                // 완료된 주문을 completedList에 추가
                CompletedOrder completedOrder = new CompletedOrder(waitingList.get(answer - 1).getWaitingNumber(),
                        completedProducts,
                        waitingList.get(answer - 1).getTotalPrice(),
                        waitingList.get(answer - 1).getRequiredMsg());
                completedList.add(completedOrder);

                getWaitingList();
            }
        }
    }

    /*서지인*/
    // 완료 주문 목록
    public void completeOrderList() {
        System.out.println("현재 완료 주문 목록입니다.");

        if (completedList.isEmpty()) {
            System.out.println("완료 주문 목록이 없습니다.");
        } else {
            for (CompletedOrder completedData : completedList) {
                System.out.println("대기 번호 : " + completedData.getOrderNumber());
                System.out.println("주문 번호 : " + completedData.getOrderNumber());
                System.out.println("주문 총 가격 : " + completedData.getTotalPrice());
                System.out.println("주문 일시 : " + completedData.getCompletedTime());
                System.out.println("요청 사항 : " + completedData.getRequest());
                LocalDateTime time = completedData.getCompletedTime();
                completedData.setCompletedTime(time);
                System.out.println("완료주문 일시 : " + time);
                System.out.print("상품 목록 : ");

                String[] productList = completedData.getCompletedList();
                for (String product : productList) {
                    System.out.println(product);
                }

                System.out.println("[0] : 돌아가기");
                int input = sc.nextInt();
                if (input == 0) {
                    callManager();
                } else {
                    System.out.println("번호를 잘못 입력했습니다.");
                    completeOrderList();
                }
            }
        }
    }

    //상품 생성

    public static void createProduct() {

        System.out.println("메뉴를 입력하세요:");
        System.out.println("1. Burgers");
        System.out.println("2. Custard");
        System.out.println("3. Drink  ");
        System.out.println("4. Beer   ");
        System.out.println("5. New    ");

        int menuName = sc.nextInt();

        switch (menuName) {
            case 1 -> {
                System.out.println("상품 이름을 입력하세요:");
                String name = sc.next();

                System.out.println("상품 가격을 입력하세요:");
                double price = sc.nextDouble();

                System.out.println("상품 설명을 입력하세요:");
                String desc = sc.next();

                Product newProduct = new Product(name, price, desc);

                Main.burgerArrayList.add(newProduct);

                System.out.println("상품이 성공적으로 생성되었습니다!");
                break;
            }
            case 2 -> {
                System.out.println("상품 이름을 입력하세요:");
                String name = sc.next();

                System.out.println("상품 가격을 입력하세요:");
                double price = sc.nextDouble();

                System.out.println("상품 설명을 입력하세요:");
                String desc = sc.next();

                Product newProduct = new Product(name, price, desc);

                Main.custardArrayList.add(newProduct);

                System.out.println("상품이 성공적으로 생성되었습니다!");
                break;
            }
            case 3 -> {
                System.out.println("상품 이름을 입력하세요:");
                String name = sc.next();

                System.out.println("상품 가격을 입력하세요:");
                double price = sc.nextDouble();

                System.out.println("상품 설명을 입력하세요:");
                String desc = sc.next();

                Product newProduct = new Product(name, price, desc);

                Main.drinkArrayList.add(newProduct);

                System.out.println("상품이 성공적으로 생성되었습니다!");
                break;
            }
            case 4 -> {
                System.out.println("상품 이름을 입력하세요:");
                String name = sc.next();

                System.out.println("상품 가격을 입력하세요:");
                double price = sc.nextDouble();

                System.out.println("상품 설명을 입력하세요:");
                String desc = sc.next();

                Product newProduct = new Product(name, price, desc);

                Main.beerArrayList.add(newProduct);

                System.out.println("상품이 성공적으로 생성되었습니다!");
                break;
            }
            case 5 -> {
                System.out.println("상품 이름을 입력하세요:");
                String name = sc.next();

                System.out.println("상품 가격을 입력하세요:");
                double price = sc.nextDouble();

                System.out.println("상품 설명을 입력하세요:");
                String desc = sc.next();

                Product newProduct = new Product(name, price, desc);

                Main.newProductArrayList.add(newProduct);

                System.out.println("상품이 성공적으로 생성되었습니다!");
                break;
            }
            default -> {
                System.out.println("잘못된 값을 입력하셨습니다.");
            }
        }
    }


    // 상품 삭제

    public static void deleteProduct() {


        System.out.println("삭제할 상품의 메뉴를 입력하세요:");
        System.out.println("1. Burgers");
        System.out.println("2. Custard");
        System.out.println("3. Drink  ");
        System.out.println("4. Beer   ");
        System.out.println("5. New    ");

        int delete = sc.nextInt();

        switch (delete) {
            case 1 -> {
                for (Product product : Main.burgerArrayList) {
                    System.out.println(product);
                    System.out.println("Product ID: " + product.getProductId());
                    System.out.println();
                }

                String productId = sc.next();

                for (int i = 0; i < Main.burgerArrayList.size(); i++) {
                    Product product = Main.burgerArrayList.get(i);
                    if (product.getProductId().toString().equals(productId)) {
                        Main.burgerArrayList.remove(i);
                        System.out.println("상품이 성공적으로 삭제되었습니다!");
                        return;
                    }
                }
                System.out.println("입력한 ID와 일치하는 상품을 찾을 수 없습니다.");
                break;
            }
            case 2 -> {
                for (Product product : Main.custardArrayList) {
                    System.out.println(product);
                    System.out.println("Product ID: " + product.getProductId());
                    System.out.println();
                }

                String productId = sc.next();

                for (int i = 0; i < Main.custardArrayList.size(); i++) {
                    Product product = Main.custardArrayList.get(i);
                    if (product.getProductId().toString().equals(productId)) {
                        Main.custardArrayList.remove(i);
                        System.out.println("상품이 성공적으로 삭제되었습니다!");
                        return;
                    }
                }
                System.out.println("입력한 ID와 일치하는 상품을 찾을 수 없습니다.");
                break;
            }
            case 3 -> {
                for (Product product : Main.drinkArrayList) {
                    System.out.println(product);
                    System.out.println("Product ID: " + product.getProductId());
                    System.out.println();
                }

                String productId = sc.next();

                for (int i = 0; i < Main.drinkArrayList.size(); i++) {
                    Product product = Main.drinkArrayList.get(i);
                    if (product.getProductId().toString().equals(productId)) {
                        Main.drinkArrayList.remove(i);
                        System.out.println("상품이 성공적으로 삭제되었습니다!");
                        return;
                    }
                }
                System.out.println("입력한 ID와 일치하는 상품을 찾을 수 없습니다.");
                break;
            }
            case 4 -> {
                for (Product product : Main.beerArrayList) {
                    System.out.println(product);
                    System.out.println("Product ID: " + product.getProductId());
                    System.out.println();
                }

                String productId = sc.next();

                for (int i = 0; i < Main.beerArrayList.size(); i++) {
                    Product product = Main.beerArrayList.get(i);
                    if (product.getProductId().toString().equals(productId)) {
                        Main.beerArrayList.remove(i);
                        System.out.println("상품이 성공적으로 삭제되었습니다!");
                        return;
                    }
                }
                System.out.println("입력한 ID와 일치하는 상품을 찾을 수 없습니다.");
                break;
            }

            case 5 -> {
                for (Product product : Main.newProductArrayList) {
                    System.out.println(product);
                    System.out.println("Product ID: " + product.getProductId());
                    System.out.println();
                }

                String productId = sc.next();

                for (int i = 0; i <Main.newProductArrayList.size(); i++) {
                    Product product = Main.newProductArrayList.get(i);
                    if (product.getProductId().toString().equals(productId)) {
                        Main.newProductArrayList.remove(i);
                        System.out.println("상품이 성공적으로 삭제되었습니다!");
                        return;
                    }
                }
                System.out.println("입력한 ID와 일치하는 상품을 찾을 수 없습니다.");
                break;
            }
        }
    }

    public int input(){
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }
}