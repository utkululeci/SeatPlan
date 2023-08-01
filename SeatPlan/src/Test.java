import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(testOutputFile(args[0], args[1]));
    }


    private static double testOutputFile(String outputFilepath, String expectedOutputFilepath) {
        try {
            List<String> outputLines = mergeLineBlocks(Files.readAllLines(Paths.get(outputFilepath)));
            List<String> expectedOutputLines = mergeLineBlocks(Files.readAllLines(Paths.get(expectedOutputFilepath)));

            int correct = 0;
            for(int i = 0; i < outputLines.size(); i++) {
                try {
                    if(outputLines.get(i).equalsIgnoreCase(expectedOutputLines.get(i)))
                        correct++;
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }

            return correct / (double) expectedOutputLines.size();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> mergeLineBlocks(List<String> lines) {
        List<String> outputLines = new ArrayList<>();
        boolean inLinesBlock = false;
        String tempLine = "";
        for(String line : lines) {
            if(line.trim().isEmpty())
                continue; // skip blank lines

            if(line.trim().startsWith("### START OF")) {
                inLinesBlock = true;
                continue;
            } else if(line.trim().startsWith("### END OF")) {
                inLinesBlock = false;
                outputLines.add(tempLine);
                tempLine = "";
                continue;
            } else if (!inLinesBlock) {
                // we're not in a lines block. this is a plain line like => Studio Software (C447) admitted Tulay Akyol (21921310).
                outputLines.add(line);
                continue;
            }

            if(inLinesBlock)
                tempLine += line.trim() + " "; // we merge line blocks into a single line
        }
        return outputLines;
    }
}
