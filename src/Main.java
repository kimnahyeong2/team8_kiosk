import java.util.*;

public class Main {

    public static double total = 0;

    static Scanner sc = new Scanner(System.in);
    static Order order = new Order();
    static int waiting = 0;


    public static void main(String[] args) throws InterruptedException {
        while(true) {

            ArrayList<Menu> menuArrayList = getMenuList();
            ArrayList<Product> productList;
            System.out.println("---------------------------------------\n");
            System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
            try {

                int answer = selectMenu(menuArrayList);

                switch (answer) {
                    case 0 -> {
                        System.out.println("[ 총 판매금액 현황 ]");
                        System.out.printf("현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n\n",total);
                        System.out.println("1.돌아가기");
                        answer = sc.nextInt();
                        break;
                    }
                    case 9 -> {
                        System.out.println("[ 총 판매상품 목록 현황 ]");
                        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
                        ArrayList<Product>selledList = order.getSelledlist();
                        for (Product product : selledList) {
                            System.out.println("- " + product.getName() + " | W " + product.getPrice());
                        }
                        System.out.println("1.돌아가기");
                        answer = sc.nextInt();
                        break;
                    }
                    case 1, 2, 3, 4 -> {
                        selectProcess(answer);

                    }
                    case 5 -> {
                        System.out.println("아래와 같이 주문하시겠습니까?\n");
                        System.out.println("[ Orders ]");
                        ArrayList<Product> wishlist = order.getWishlist();

                        for(Product product : wishlist){
                            System.out.println(product.toString_cnt());
                        }


                        System.out.println();
                        System.out.println("[ Total ]");
                        double sum = 0;
                        for(int i=0; i<wishlist.size(); i++){
                            sum += wishlist.get(i).getPrice() * wishlist.get(i).getCnt();
                        }
                        System.out.printf("W %.1f\n\n",sum);
                        System.out.println("1. 주문    2. 메뉴판");

                        answer = sc.nextInt();

                        if(answer == 1) {
                            if(order.getWishlist().isEmpty()){
                                System.out.println("메뉴를 담고 주문해주세요.");
                                System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
                                Thread.sleep(3000);
                            }else{
                                total += sum;
                                System.out.println("주문이 완료되었습니다!\n");
                                for(Product selledProduct : wishlist){
                                    order.addSelledList(selledProduct);
                                }
                                order.clear();
                                System.out.println("대기번호는 [ " + (++waiting) + " ] 번 입니다.");
                                System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
                                Thread.sleep(3000);}
                        }
                    }
                    case 6 -> {
                        System.out.println("진행하던 주문을 취소하시겠습니까?");
                        System.out.println("1. 확인    2.취소");
                        answer = sc.nextInt();
                        if(answer == 1){order.clear();
                            System.out.println("진행하던 주문이 취소되었습니다.\n");}
                    }
                    default ->{
                        System.out.println("올바른 입력이 아닙니다.");
                        Thread.sleep(2000);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("올바른 입력이 아닙니다.");
                Thread.sleep(2000);
            }
        }
    }
    //메뉴 불러오기
    public static ArrayList<Menu> getMenuList(){
        ArrayList<Menu> menuArrayList = new ArrayList<>();
        menuArrayList.add(new Menu("Burgers         ","앵거스 비프 통살을 다져만든 버거"));
        menuArrayList.add(new Menu("Forzen Custard  ","매장에서 신선하게 만드는 아이스크림"));
        menuArrayList.add(new Menu("Drinks          ","매장에서 직접 만드는 음료"));
        menuArrayList.add(new Menu("Beer            ","뉴욕 브루클린 브루어리에서 양조한 맥주"));
        return menuArrayList;
    }

    //5,6번 메뉴(오더) 불러오기
    public static ArrayList<Menu> getOrderList(){
        ArrayList<Menu> orderArrayList = new ArrayList<>();
        orderArrayList.add(new Menu("Order       ","장바구니를 확인 후 주문합니다."));
        orderArrayList.add(new Menu("Cancel      ","진행중인 주문을 취소합니다."));
        return orderArrayList;
    }

    //상품들 가져오기
    public static ArrayList<Product> getProductList(int direction){
        ArrayList<Product> productArrayList = new ArrayList<>();
        switch (direction) {
            case 1: {
                productArrayList.add(new Product("ShackBurger   ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
                productArrayList.add(new Product("SmokeShack    ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
                productArrayList.add(new Product("Shroom Burger ", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
                productArrayList.add(new Product("Cheeseburger  ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
                productArrayList.add(new Product("Hamburger     ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
                return productArrayList;
            }
            case 2: {
                productArrayList.add(new Product("Shakes             ", 5.9, "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트 스트로베리, 피넛버터, 커피"));
                productArrayList.add(new Product("Shakes of the week ", 6.9, "특별한 커스터드 플레이버"));
                productArrayList.add(new Product("Red Bean Shake     ", 6.9, "신선한 커스타드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크"));
                return productArrayList;
            }
            case 3: {
                productArrayList.add(new Product("Shack-made Lemonade   ", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드"));
                productArrayList.add(new Product("Fresh Brewed Iced Tea ", 3.5, "직접 유기농 홍차를 우려낸 아이스티"));
                productArrayList.add(new Product("Fifty / Fifty         ", 3.4, "레몬에이드와 아이스티의 만남"));
                return productArrayList;
            }
            case 4: {
                productArrayList.add(new Product("ShackMeister Ale   ", 9.8, "쉐이크쉑 버거를 위해 뉴욕 브루클릭 브루어리에서 특별히 양조한 에일 맥주"));
                productArrayList.add(new Product("Slow IPA           ", 6.8, "The Hand and Malt"));
                productArrayList.add(new Product("Blackcurrant Gose  ", 6.8, "Garilla Brewing Co. Busan"));
                return productArrayList;
            }
        }

        return productArrayList;
    }

    //메뉴 리스트 출력, 선택한 번호 1,2,3,4.. 리턴
    public static int selectMenu(ArrayList<Menu> menuArrayList) throws InterruptedException {
        System.out.println("[ SHAKESHACK MENU ]");
        ArrayList<Menu> orderArrayList = getOrderList();
        for (int i = 0; i < menuArrayList.size(); i++) {
            System.out.println(((i+1)+". "+menuArrayList.get(i).toString()));
            delay();
        }

        System.out.println("\n[ ORDER MENU ]");
        delay();
        getOrder(orderArrayList);
        sc = new Scanner(System.in);

        return sc.nextInt();
    }

    //오더 리스트 출력, 선택한 번호 1,2,3,4.. 리턴
    //메뉴 개수 증가하면 그에 따라 번호 맞춤 메뉴가 5개 인 경우, 오더 메뉴 6번 부터 시작
    public static void getOrder(ArrayList<Menu> orderArrayList) throws InterruptedException {
        ArrayList<Menu> menuArrayList = getMenuList();
        for (int i = 0; i < orderArrayList.size(); i++) {
            System.out.println(((menuArrayList.size()+(i+1))+". "+orderArrayList.get(i).toString()));
            delay();
        }
    }

    //상품 리스트 출력, 선택한 번호 1,2,3,4.. 리턴
    public static int selectProduct(ArrayList<Product> productArrayList) throws InterruptedException {
        for (int i = 0; i < productArrayList.size(); i++) {
            System.out.println(((i+1)+". "+productArrayList.get(i).toString()));
            delay();
        }
        sc = new Scanner(System.in);

        return sc.nextInt();
    }

    public static Product selectOption(Product selectedProduct) throws InterruptedException {

        System.out.println(selectedProduct.toString());
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        double sizeUp = 3.0;

        String selectedName = selectedProduct.getName();
        double selectedPrice = selectedProduct.getPrice();
        System.out.println("1. Single(W "+selectedPrice+")        2. SizeUp(W "+(selectedPrice+sizeUp)+")");

        int answer = sc.nextInt();
        if(answer == 2){
            selectedProduct.setPrice(selectedPrice+sizeUp);
            selectedProduct.setName("[Size Up]"+selectedName);
        }
        return selectedProduct;
    }
    //장바구니로 담는 메서드,, 이것도 반복되는 것 같아 함수로 만들었다.
    public static void addWishlist(Product selectedProduct){

        System.out.println(selectedProduct.toString());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인    2.취소");
        int answer = sc.nextInt();
        if (answer != 1) {
            System.out.println("취소되었습니다.");
        } else {
            boolean exists = false;
            //장바구니 내 이미 selectedProduct가 존재하는지 여부
            for(int i=0; i<order.getWishlist().size(); i++){
                if (order.getWishlist().get(i).toString().equals(selectedProduct.toString())) {
                    exists = true;
                    Product existingProduct = order.getWishlist().get(i);
                    existingProduct.setCnt(existingProduct.getCnt() + 1);
                    System.out.println(existingProduct.getName() + "의 수량이 증가되었습니다.");
                }
            }
            if(!exists){
                order.add(selectedProduct);
                System.out.println(selectedProduct.getName() + " 가 장바구니에 추가되었습니다.");
            }
        }
    }

    public static void selectProcess(int answer) throws InterruptedException {
        ArrayList<Product>productList = getProductList(answer);
        answer = selectProduct(productList);
        Product selectedProduct = productList.get(answer - 1);
        selectOption(selectedProduct);
        addWishlist(selectedProduct);
    }
    //천천히 출력되게끔,,
    public static void delay() throws InterruptedException {
        Thread.sleep(200);
    }
}