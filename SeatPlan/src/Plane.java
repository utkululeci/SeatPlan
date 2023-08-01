public class Plane extends Vehicle {
    // Plane class should inherit from Vehicle abstract class and override its abstract methods

    /**
     * @param seatLabel: Seat label as string "13A", "21B" etc..
     * NOTE: If it's a business seat, still it does not start with an * asterisk.
     * Asterisk character is only used during seat table printing.
     */
    public int bussinesSeats;
    public void bookSeat(String seatLabel) {
        // TODO: implement seat booking operation here
    }
    public Plane(){}
    public int getBussinesSeats(){ return bussinesSeats;}

    public Plane(String model, String identifier, int capacity, int bussinesSeats){
        this.model = model;
        this.identifier = identifier;
        this.capacity = capacity;
        this.bussinesSeats = bussinesSeats;
    }

    @Override
    public String toString() {
        return "Plane ("+ this.identifier +"), model: "+ this.model +", capacity: "+this.capacity+ ", businessSeatCount: "+this.bussinesSeats; // TODO: this should return a string representation of object
    }

    @Override
    public void printSeatsTable() {

    }

    public static void createVehicle(String command){
        String[] seperatedCommand = command.split(" ");
        Plane plane = new Plane(seperatedCommand[3],seperatedCommand[4],Integer.parseInt(seperatedCommand[5]),Integer.parseInt(seperatedCommand[6]));
        vehicles.add(plane);
        System.out.println("Vehicle was added. "+plane.toString());
    }

}
