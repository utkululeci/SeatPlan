import java.util.ArrayList;
import java.util.List;

public abstract class Seat {
    public  static ArrayList<Seat> seatList = new ArrayList<>();
    public static ArrayList<Seat> getSeatList() {
        return seatList;
    }
    public static void createSeat(String command){}
    String gender;
    public  void setGender(String gender){this.gender = gender;}
    public String getGender(){return gender;}
    String label;
    boolean booked = true;
    public String identity;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isBooked() {
        return booked;
    }

    public String bookCheck(){
        if(booked == true){
            return "[ ]";
        }else if(booked != true){
            return "[X]";
        }
        return null;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getIdentity(){ return identity;}

    public void seatBooker(String command){}

    public void printSeatTable(String command){
    }
}
