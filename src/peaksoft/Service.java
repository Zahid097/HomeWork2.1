package peaksoft;

import java.util.Random;

public class Service implements TruckService {

    @Override
    public void changeDriver(Truck truck, Driver driver) {
        if (truck.getState().equals("base")) {
            truck.setDriver(driver.getDriver());
            driver.setTruck(truck.getName());
        } else if (truck.getState().equals("route")) {
            System.out.println("Водитель уже в пути.");
        } else {
            System.out.println("Вы не можете поменять водителя!");
        }
    }

    @Override
    public void startDriving(Truck truck, Driver driver) {
        if (truck.getState().equals("base")) {
            if (!truck.getDriver().equals("")) {
                truck.setState("route");
                System.out.println("Водитель успешно начал свой путь.");
            } else {
                System.out.println("Здесь нет водителя!");
            }
        } else if (truck.getState().equals("route")) {
            System.out.println("Водитель уже в пути.");
        } else {
            Random random = new Random();
            int road = random.nextInt(2);
            if (road == 0) {
                truck.setState("route");
                System.out.println("Грузовик уже в пути.");
            } else {
                truck.setState("base");
                System.out.println("Грузовик на базе.");

            }
        }

    }


    @Override
    public void startRepair(Truck truck, Driver driver) {
        if (truck.getState().equals("base")) {
            truck.setState("repair");
            System.out.println("Грузовик находится в СТО.");
        } else if (truck.getState().equals("route")) {
            truck.setState("repair");
        } else {
            System.out.println("Грузовик в ремонте.");
        }
    }
}
