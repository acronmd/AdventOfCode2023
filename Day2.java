import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> maxMap = new HashMap<>();
        maxMap.put(12, "red");
        maxMap.put(13, "green");
        maxMap.put(14, "blue");

        List<String> listOfStrings = Files.readAllLines(Paths.get("input2.txt"));
        String[] inputArray = listOfStrings.toArray(new String[0]);

        ///int gameIDs = 0;
        int total = 0;


        for( int ii = 0; ii < inputArray.length; ii++  ){
            ///boolean illegalFlag = false;
            int[] highestValues = {0,0,0};
            inputArray[ii] = inputArray[ii].substring(inputArray[ii].indexOf(":") + 1);
            inputArray[ii] = inputArray[ii].replace(";", ",");
            String[] gamePlays = inputArray[ii].split(",");
            for (String gamePlay : gamePlays) {
                int spaceIndex = gamePlay.lastIndexOf(" ");
                for (Map.Entry<Integer, String> entry : maxMap.entrySet()) {
                    if (!(entry.getValue().equals(gamePlay.substring(spaceIndex + 1)))) {
                        ///Continues if the text doesn't match the hash text
                    } else {
                        int number = Integer.parseInt(gamePlay.substring(gamePlay.indexOf(" ") + 1, spaceIndex));
                        if( number > highestValues[entry.getKey() - 12]){
                            System.out.println("Old Highest " + entry.getValue() + " : " + highestValues[entry.getKey()-12]);
                            highestValues[entry.getKey()-12] = number;
                            System.out.println("New Highest " + entry.getValue() + " : " + highestValues[entry.getKey()-12]);
                        }
                        /*
                        if (entry.getKey() < Integer.parseInt(gamePlay.substring(gamePlay.indexOf(" ") + 1, spaceIndex))) {
                            illegalFlag = true;
                        }*/
                    }
                }
                /*
                if (illegalFlag) {
                    ///Continues if the flag has been set
                }
                 */
            }
            int multiple = highestValues[0] * highestValues[1] * highestValues[2];
            total += multiple;
            ///if(!illegalFlag){ gameIDs += ii + 1; }
        }
        System.out.println(total);
    }
}