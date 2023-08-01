import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    String identifier;
    int capacity;
    String model;
    int bussinesSeats;
    public int getBussinesSeats(){ return bussinesSeats;}



    public static ArrayList<Vehicle> vehicles = new ArrayList<>();
    public abstract void printSeatsTable();

    public static ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }




    public static void createVehicle(String command){


    }



}
