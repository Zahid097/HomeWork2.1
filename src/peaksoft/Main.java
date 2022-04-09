package peaksoft;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Truck[] trucks = {new Truck(1, "Mazda", "", "base"),
                new Truck(2, "Volvo", "", "base"),
                new Truck(3, "Lada ", "", "base")
        };
        Driver[] drivers = {new Driver(1, "Andrey", "driver-1"),
                new Driver(2, "Volodya", "driver-2"),
                new Driver(3, "Aleksey", "driver-3")
        };

        print(trucks);
        print(drivers);
        System.out.println("******************************");
        while (true) {
            System.out.println("Выберите один из грузовиков: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            Driver.getInfo(trucks[input - 1]);
            Service service = new Service();
            getInstruction();
            String action = scanner.nextLine();
            if (action.equals("1")) {
                service.changeDriver(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("2")) {
                service.startDriving(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("3")) {
                service.startRepair(trucks[input - 1], drivers[input - 1]);
            }
            print(trucks);
            print(drivers);

        }
    }

    public static void print(Truck[] trucks) {
        System.out.println("~~~~~~~~~~~~ * TRUCKS * ~~~~~~~~~~~~");
        System.out.println(" # |    Bus    |  State  |  Driver");
        System.out.println("---+-----------+----------+---------");
        for (int j = 0; j < trucks.length; j++) {
            System.out.println(trucks[j]);

        }
    }

    public static void print(Driver[] drivers) {
        System.out.println("~~~~~~~~~~ * DRIVERS * ~~~~~~~~~~~~~");
        System.out.println("     #    |   Driver   |   Bus      ");
        System.out.println("----------+------------+------------");
        for (int j = 0; j < drivers.length; j++) {
            System.out.println(drivers[j]);
        }
    }

    public static void getInstruction() {
        System.out.println("Выберите -1- чтобы поменять водителя.");
        System.out.println("Выберите -2- чтобы начать движение.");
        System.out.println("Выберите -3- чтобы начать ремонтирование.");
    }
}
