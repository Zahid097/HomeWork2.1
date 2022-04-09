package peaksoft;

public interface TruckService {

    void changeDriver(Truck truck, Driver driver);

    void startDriving(Truck truck, Driver driver);

    void startRepair(Truck truck, Driver driver);

}
