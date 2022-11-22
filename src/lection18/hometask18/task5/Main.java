package lection18.hometask18.task5;

import org.json.JSONObject;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> students = readFile("src/lection18/hometask18/task5/students.json");

        Map<String, Object> changedStudents = new HashMap<>();
        double sum;
        double averageMark;

        for (Map.Entry<String, Object> student : students.entrySet()) {
            sum = 0;
            for (BigDecimal mark : (ArrayList<BigDecimal>) student.getValue()) {
                sum += mark.doubleValue();
            }
            averageMark = sum / ((ArrayList<BigDecimal>) student.getValue()).size();
            System.out.println(averageMark);
            if (averageMark > 7) {
                changedStudents.put(student.getKey().toUpperCase(), student.getValue());
            } else {
                changedStudents.put(student.getKey(), student.getValue());
            }
        }

        JSONObject jsonObject = new JSONObject(changedStudents);

        writeFile("src/lection18/hometask18/task5/students.json", jsonObject.toString());
    }


    public static Map<String, Object> readFile(String filePath) {
        String line;
        StringBuilder fileContent = new StringBuilder();

        try (var bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(fileContent.toString());
        return jsonObject.toMap();
    }

    public static void writeFile(String filePath, String fileContent) {
        try (var printWriter = new PrintWriter(new BufferedWriter(
                new FileWriter(filePath)
        ))) {
            printWriter.print(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
