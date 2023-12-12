import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {
    public static void main(String[] args) throws IOException {
        Map<String, String> numMap = new HashMap<>();
        numMap.put("zero","z0o");
        numMap.put("one", "o1e");
        numMap.put("two","t2o");
        numMap.put("three","t3e");
        numMap.put("four","f4r");
        numMap.put("five","f5e");
        numMap.put("six","s6x");
        numMap.put("seven","s7n");
        numMap.put("eight","e8t");
        numMap.put("nine","n9e");

        int total = 0;
        List<String> listOfStrings = Files.readAllLines(Paths.get("input.txt"));
        String[] inputArray = listOfStrings.toArray(new String[0]);

        for (String s : inputArray) {
            for(Map.Entry<String, String> entry : numMap.entrySet()){
                s = s.replace( entry.getKey(), entry.getValue());
            }
            String calibrationNum = s.replaceAll("[A-Za-z]+", "");
            int fixedCalibrationNum = Integer.parseInt(calibrationNum.charAt(0) + calibrationNum.substring(calibrationNum.length() - 1));
            total += fixedCalibrationNum;
        }
        System.out.println(total);
    }
}