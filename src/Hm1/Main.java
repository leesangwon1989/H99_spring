package Hm1;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(1);
        bus.board(2);
        bus.refuel(-50);
        System.out.println("주유량 = " + bus.currentGas);
        bus.busStatus(false);
        bus.refuel(10);
        bus.currentBus();
        bus.busStatus(true);
        bus.board(45);
        bus.board(5);
        bus.refuel(-55);
        bus.currentBus();
        bus.refuel(55);
        bus.changeSpeed(30);
    }
}