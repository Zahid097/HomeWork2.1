package peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Driver {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./drivers.json");

    private int id;
    private String driver;
    private String truck;

    public Driver(int id, String driver, String truck) {
        this.id = id;
        this.driver = driver;
        this.truck = truck;
    }

    public Driver() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public static void getDrivers() {

        Driver[] drivers = {new Driver(1, "driver-1", "Andrey"),
                new Driver(2, "driver-2", "Volodya"),
                new Driver(3, "driver-3", "Aleksey")
        };

        Gson gson = new Gson();
        String json = GSON.toJson(drivers);
        System.out.println(readDriverFile());
        writeDriverFile(json);

        Driver[] drivers1 = GSON.fromJson(readDriverFile(), Driver[].class);
        for (Driver driver : drivers1) {
            System.out.println(driver.toString());
        }
    }

    private static void writeDriverFile(String object) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readDriverFile() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int id;
            while ((id = fileReader.read()) != -1) {
                json += (char) id;
            }
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static void getInfo(Truck truck) {
        System.out.println(
                "ID: " + truck.getId() + "\n" +
                        "Name: " + truck.getName() + "\n" +
                        "Driver: " + truck.getDriver() + "\n" +
                        "State: " + truck.getState()
        );
    }


    @Override
    public String toString() {
        return "     " + id + "    | " + driver + "   | " + truck;
    }
}
