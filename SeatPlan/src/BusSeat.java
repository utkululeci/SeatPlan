import java.sql.SQLOutput;
import java.util.ArrayList;

public class BusSeat extends Seat {
    // BusSeat class should inherit from Seat abstract class
    String gender = "[ ]";
    public BusSeat(){}
    public  void setGender(String gender){this.gender = gender;}
    public String getGender(){return gender;}



    public BusSeat(String label, String identity){
        this.label = label;
        this.identity = identity;

    }

    public static void createSeat(String command){
        String[] seperatedCommand = command.split(" ");
        int capacity = Integer.parseInt(seperatedCommand[5]);
        String identity = seperatedCommand[4];
        for(int i = 1; i <= capacity; i++){
            BusSeat busSeat = new BusSeat(String.valueOf(i),identity);
            seatList.add(busSeat);
        }


    }

    public void seatBooker (String command){
        String[] seperatedCommand = command.split(" ");
        BusSeat busSeat = new BusSeat(seperatedCommand[2],seperatedCommand[5]);
        boolean checker = true;
        for(int i = 0; i < seatList.size(); i++){

            if(seatList.get(i).getLabel().equals(seperatedCommand[2])&&seatList.get(i).getIdentity().equals(seperatedCommand[5])){
                checker = false;
                if(seatList.get(i).isBooked()){
                    int remain = Integer.parseInt(seatList.get(i).getLabel())%2;
                    if(remain == 1){
                        if(seatList.get(i+1).isBooked()){
                            seatList.get(i).setBooked(false);
                            seatList.get(i).setGender("["+seperatedCommand[3]+"]");
                            System.out.println(busSeat.label+" booked.");
                        }else{
                            if(seatList.get(i+1).getGender().equals("["+seperatedCommand[3]+"]")){
                                seatList.get(i).setBooked(false);
                                seatList.get(i).setGender("["+seperatedCommand[3]+"]");
                                System.out.println(busSeat.label+" booked.");
                            }else{
                                System.out.println(seperatedCommand[2]+" cannot be booked because neighbor seat was booked by different gender person.");
                            }

                        }
                    }else if(remain == 0){
                        if(seatList.get(i-1).isBooked()){
                            seatList.get(i).setBooked(false);
                            seatList.get(i).setGender("["+seperatedCommand[3]+"]");
                            System.out.println(busSeat.label+" booked.");

                        }else{

                            if(seatList.get(i-1).getGender().equals("["+seperatedCommand[3]+"]")){
                                seatList.get(i).setBooked(false);
                                seatList.get(i).setGender("["+seperatedCommand[3]+"]");
                                System.out.println(busSeat.label+" booked.");
                            }else{
                                System.out.println(seperatedCommand[2]+" cannot be booked because neighbor seat was booked by different gender person.");
                            }

                        }
                    }

                }else{
                    System.out.println(busSeat.label+ " cannot be booked, it's already booked.");
                }
            }

        }
        if(checker){ System.out.println("No such seat exists.");}
    }
    @Override
    public String toString() {
        return this.label +" " +this.identity; // TODO: this should return a string representation of object
    }

    @Override
    public void printSeatTable(String command) {
        String[] seperatedCommand = command.split(" ");
        String identity = seperatedCommand[2];
        ArrayList<Vehicle> vehicles = Vehicle.getVehicles();
        Vehicle bus;
        ArrayList<Seat> busSeats = new ArrayList<>();
        Vehicle plane;
        ArrayList<Seat> planeSeats = new ArrayList<>();
        String vehicleOptions = null;
        for(int p = 0; p< vehicles.size();p++){

            if(vehicles.get(p).getIdentifier().equals(identity)){
                if(vehicles.get(p).getClass() == Bus.class){
                    vehicleOptions = "Bus";
                } else if (vehicles.get(p).getClass() == Plane.class) {
                    vehicleOptions = "Plane";
                }
            }


            }
        if(vehicleOptions.equals("Bus")){
            try{for(int t = 0; t< seatList.size();t++){
                if(seatList.get(t).getIdentity().equals(identity)){
                    busSeats.add(seatList.get(t));
                }
            }
            }catch (NullPointerException e){}

            int capacity = 0;
            String model= null;
            for(int j = 0 ; j < vehicles.size(); j++){
                if(vehicles.get(j).getIdentifier().equals(identity)){
                    bus = vehicles.get(j);
                    capacity = bus.getCapacity();
                    model = bus.getModel();
                }
            }
            System.out.println("### START OF BUS INFO ###");
            System.out.println("Bus ("+identity+"), model: "+model+", capacity: "+capacity);
            for(int i = 0; i<capacity/4;i++){
                System.out.println(busSeats.get(0+(4*i)).getLabel()+"  "+busSeats.get(0+(4*i)).getGender()+"  "+busSeats.get(1+(4*i)).getLabel()+"  "+busSeats.get(1+(4*i)).getGender()+"      "+busSeats.get(2+(4*i)).getLabel()+"  "+busSeats.get(2+(4*i)).getGender()+"  "+busSeats.get(3+(4*i)).getLabel()+"  "+busSeats.get(3+(4*i)).getGender());
            }
            System.out.println("### END OF BUS INFO ###");
        }
        else if (vehicleOptions.equals("Plane")) {
            try{for(int t = 0; t< seatList.size();t++){
                if(seatList.get(t).getIdentity().equals(identity)){
                    planeSeats.add(seatList.get(t));
                }
            }
            }catch (NullPointerException e){}
            int capacity = 0;
            String model = null;
            int bussinesSeatCount = 0;

            for(int j = 0 ; j < vehicles.size(); j++){
                if(vehicles.get(j).getIdentifier().equals(identity)){
                    plane = vehicles.get(j);
                    capacity = plane.getCapacity();
                    model = plane.getModel();
                    bussinesSeatCount = plane.getBussinesSeats();
                }
            }
            System.out.println("### START OF PLANE INFO ###");
            System.out.println("Plane ("+identity+"), model: "+model+", capacity: "+capacity+", businessSeatCount: "+bussinesSeatCount);
            for(int i = 0; i<capacity/6; i++){
                String bussinesCheck = "";
                if(i < bussinesSeatCount/6){
                    bussinesCheck = "*";
                }else{
                    bussinesCheck = "";
                }
                System.out.println(bussinesCheck+planeSeats.get(0+(6*i)).getLabel()+"  "+planeSeats.get(0+(6*i)).bookCheck()+"  "+bussinesCheck+planeSeats.get(1+(6*i)).getLabel()+"  "+planeSeats.get(1+(6*i)).bookCheck()+"  "+bussinesCheck+planeSeats.get(2+(6*i)).getLabel()+"  "+planeSeats.get(2+(6*i)).bookCheck()+"        "+bussinesCheck+planeSeats.get(3+(6*i)).getLabel()+"  "+planeSeats.get(3+(6*i)).bookCheck()+"  "+bussinesCheck+planeSeats.get(4+(6*i)).getLabel()+"  "+planeSeats.get(4+(6*i)).bookCheck()+"  "+bussinesCheck+planeSeats.get(5+(6*i)).getLabel()+"  "+planeSeats.get(5+(6*i)).bookCheck());
            }
            System.out.println("### END OF PLANE INFO ###");
        }



    }
}

