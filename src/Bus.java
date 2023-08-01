import java.util.ArrayList;

public class Bus extends Vehicle{
   // Bus class should inherit from Vehicle abstract class and override its abstract methods

    /**
     *
     * @param seatLabel: Seat label as string "13", "21" etc..
     * @param gender: Either "M" or "F" as a char variable
     */


    public void bookSeat(String seatLabel, char gender) {
        // TODO: implement seat booking operation here

    }
    public Bus(){}

    public Bus(String model,String identifier,int capacity){
        this.setModel(model);
        this.identifier = identifier;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bus ("+this.identifier+"), model: "+this.model+", capacity: "+this.capacity; // TODO: this should return a string representation of object
    }

    @Override
    public void printSeatsTable() {

    }


     public static void createVehicle(String command){
         String[] seperatedCommand = command.split(" ");
         Bus bus = new Bus(seperatedCommand[3],seperatedCommand[4],Integer.parseInt(seperatedCommand[5]));
         vehicles.add(bus);
         System.out.println("Vehicle was added. "+bus.toString());
    }


}
