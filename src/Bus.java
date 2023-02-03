public class Bus {
    int busNumber; // 버스번호
    int passengerCount; // 승객 수
    int maxPassenger; //최대 승객 수
    int price; // 요금
    int gas; //주유량
    int speed; //현재 속도
    int state; //현재 상태

    public void startOperation(String state) {
        this.state = state;
    }
    // 상태 변경
    public void changeState() {
        if (this.state == "운행") this.state = "차고지행";
        else if (this.state == "차고지행") this.state = "운행";

        if (gas < 10) {
            this.state = "차고지행";
        }
    }
    public Bus(int busNumber) { //모든 버스는 번호를 가져야한다. (기본생성자 설정)
        this.busNumber = busNumber;
        this.maxPassenger = 30;
        this.passengerCount = 0;
        this.price = 1000;
        this.gas = 10;
        this.speed = 0;
    }
    public void take(int newPassenger) { // 승객을 탑승
        if (this.passengerCount + newPassenger <= maxPassenger && state.equals("운행")) {
            this.passengerCount += newPassenger;
            System.out.println("탑승 승객 = " + newPassenger);
            System.out.println("잔여 승객 = " + passengerCount);
            System.out.println("요금 확인 = " + price * newPassenger);
        } else {
            System.out.println("최대 승객 수를 초과하였습니다");

        }
    }
    public void gas(int gas) { // 승객을 탑승
        this.gas -= gas; //위의 매개변수를 받았으므로, 받은만큼 돈이 증가해야하므로 += money로 설정한다.
        if(gas < 10) {
            System.out.println("주유 필요!");
            changeState();
        }
    }
    public void showInfo() {
        System.out.println("버스 " + busNumber + "번의 승객은 " + passengerCount + "명이고, 버스 수입은 "
                + money + "원" + state  + "입니다.");
    }

}

