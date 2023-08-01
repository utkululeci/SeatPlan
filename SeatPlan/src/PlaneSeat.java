import java.util.ArrayList;

public class PlaneSeat extends Seat{
    // PlaneSeat class should inherit from Seat abstract class


    public PlaneSeat(){}
    @Override
    public String toString() {
        return this.label+" "+this.identity+" "+this.bussines; // TODO: this should return a string representation of object
    }
    public boolean bussines;

    public PlaneSeat(String label, String identity){
        this.label = label;
        this.identity = identity;
    }

    public PlaneSeat(String label, String identity,boolean bussines){
        this.label = label;
        this.identity = identity;
        this.bussines = bussines;
    }

    public static void createSeat(String command){
        String[] seperatedCommand = command.split(" ");
        String[] labels = {"A","B","C","D","E","F"};
        for(int i = 1; i<=(Integer.parseInt(seperatedCommand[6])/6) ; i++){
            for(int s = 0; s <= 5 ; s++){
                PlaneSeat planeSeat = new PlaneSeat((String.valueOf(i)+labels[s]),seperatedCommand[4],true );
                seatList.add(planeSeat);
            }
        }

        for(int i = 1+(Integer.parseInt(seperatedCommand[6])/6); i<=(Integer.parseInt(seperatedCommand[5])/6) ; i++){
            for(int s = 0; s <= 5 ; s++){
                PlaneSeat planeSeat = new PlaneSeat((String.valueOf(i)+labels[s]),seperatedCommand[4],false );
                seatList.add(planeSeat);

            }
        }
    }


    public void seatBooker(String command) {
        String[] seperatedCommand = command.split(" ");
        PlaneSeat planeSeat = new PlaneSeat(seperatedCommand[2],seperatedCommand[4]);
        boolean checker = true;
        for(int i = 0; i<seatList.size();i++){
            if(seatList.get(i).getLabel().equals(seperatedCommand[2])&&seatList.get(i).getIdentity().equals(seperatedCommand[4])){
                checker = false;
                if(seatList.get(i).isBooked()){
                    seatList.get(i).setBooked(false);
                    System.out.println(planeSeat.label+ " booked.");
                }else{
                    System.out.println(planeSeat.label+ " cannot be booked, it's already booked.");
                }
            }

        }
        if(checker){
            System.out.println("No such seat exists.");
        }
    }
    public void printSeatTable(String command){
        String[] seperatedCommand = command.split(" ");
        String identity = seperatedCommand[2];
        ArrayList<Vehicle> vehicles = Vehicle.getVehicles();
        Vehicle plane;
        ArrayList<Seat> planeSeats = new ArrayList<>();
        for(int p = 0; p < vehicles.size();p ++){
            if(vehicles.get(p).getClass()==Plane.class){
                System.out.println("-------------------------------------------------------------------");
            }
        }
    }
}
