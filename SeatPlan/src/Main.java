import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.valueOf;

public class Main {
    static Path commandsFilepath;
    static Path outputFilepath;


    public static void main(String[] args) {
        commandsFilepath = Paths.get(args[0]);
        outputFilepath = Paths.get(args[1]);

        // DON'T CHANGE LINES BELOW, IT RECORDS ALL YOUR OUTPUT TO OUTPUT FILE
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        // DON'T CHANGE THESE LINES, IT RECORDS ALL YOUR OUTPUT TO OUTPUT FILE
        List<String> input = new ArrayList<>();

        try {
            input = Files.readAllLines(Paths.get(commandsFilepath.toUri())); // for reading from a line
        } catch (IOException e) {
            e.printStackTrace();
        }


        for(int i = 0; i< input.size();i++){
            if(input.get(i).contains("ADD VEHICLE PLANE")){
                Plane plane = new Plane();
                plane.createVehicle(input.get(i));
                PlaneSeat planeSeat = new PlaneSeat();
                planeSeat.createSeat(input.get(i));
            }else if(input.get(i).contains("ADD VEHICLE BUS")){
                Bus bus = new Bus();
                bus.createVehicle(input.get(i));
                BusSeat busSeat = new BusSeat();
                busSeat.createSeat(input.get(i));
            }else if(input.get(i).contains("BOOK PLANESEAT")){
                PlaneSeat planeSeat = new PlaneSeat();
                planeSeat.seatBooker(input.get(i));
            }else if(input.get(i).contains("BOOK BUSSEAT")){
                BusSeat busSeat = new BusSeat();
                busSeat.seatBooker(input.get(i));
            }else if(input.get(i).contains("PRINT SEATTABLE")){
                BusSeat busSeat = new BusSeat();
                busSeat.printSeatTable(input.get(i));
            }

        }

        // DON'T CHANGE LINES BELOW, IT RECORDS ALL YOUR OUTPUT TO OUTPUT FILE
        try {
            Files.write(outputFilepath, Arrays.asList(baos.toString().trim().split("\n"+"\b")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // DON'T CHANGE THESE LINES, IT RECORDS ALL YOUR OUTPUT TO OUTPUT FILE
    }

}