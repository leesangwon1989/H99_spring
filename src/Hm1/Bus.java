package Hm1;

public class Bus {
    int num;                             // 번호
    int count;                           // 차량 순서
    static int currentGas = 100;         // 주유량
    int currentSpeed = 0;                // 현재 속도
    int acceleration;                    // 가속
    static int maxPass = 30;             // 최대 승객 수
    String status = "";                  // 상태
    int currentPass = 0;                 // 현재 승객 수
    int cost = 1000;                     // 요금

    static boolean gasLeft() {
        return currentGas >= 10;
    }

    public Bus(int count) {
        this.num = (int) (Math.random() * 100 + 1);

        this.count = count;
        System.out.println("버스 번호 : " + num);
    }

    void busStatus(boolean change) {
        if (change == true)
            status = "운행중";
        else {
            status = "차고지행";
            currentPass = 0;
        }
    }

    void currentBus() {
        System.out.println("상태 = " + status);
        System.out.println("주유량 = " + currentGas);
        if (!gasLeft())
            System.out.println("주유가 필요하다");
    }

    void drive() {
        if (gasLeft()) {
            System.out.println("운행 가능");
        }
        if (!gasLeft()) {
            System.out.println("주유가 필요하다");
            System.out.println("운행 불가 = 차고지행");
            status = "차고지행";
        }
    }

    void refuel(int gas) {
        currentGas += gas;
        if (!gasLeft()) {
            status = "차고지행";
        }
    }

    boolean available() {
        return maxPass >= currentPass;
    }

    int board(int pass) {
        if (pass >= (maxPass - currentPass))
            System.out.println("최대 승객 수 초과");
        else {
            if (available()) {
                currentPass += pass;
                System.out.println("탑승 승객 수 = " + pass + "명");
                System.out.println("잔여 승객 수 = " + (maxPass - currentPass) + "명");
                System.out.println("요금 확인 = " + (cost * pass));
            }
            if (!available()) {
                System.out.println("최대 승객 수 초과");
            }
        }
        return currentPass;
    }

    int changeSpeed(int acceleration) {
        if (gasLeft()) {
            this.acceleration = acceleration;

            currentSpeed += acceleration;

            System.out.println("현재 속도는 " + currentSpeed + "입니다.");
        }
        System.out.println("주유량을 확인해주세요 " + currentGas);
        return currentGas;
    }
}