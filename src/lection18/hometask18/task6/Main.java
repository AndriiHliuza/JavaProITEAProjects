package lection18.hometask18.task6;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonObject = readFile("src/lection18/hometask18/task6/data.json");
        ArrayList<String> elements = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            String text;
            while (!(text = scanner.nextLine()).equals("ESC")) {
                elements.addAll(Arrays.stream(text.split("\\s+")).toList());
            }
        }

        JSONObject newJSonObject = addToJSONObject(jsonObject, elements);
        writeFile("src/lection18/hometask18/task6/data.json", newJSonObject.toString());
    }

    public static JSONObject addToJSONObject(JSONObject jsonObject, List<String> elements) {
        StringBuilder words = new StringBuilder("[");
        StringBuilder integers = new StringBuilder("[");
        StringBuilder symbols = new StringBuilder("[");
        StringBuilder floats = new StringBuilder("[");
        for (String element : elements) {
            if (element.matches("\\D\\D+")) {
                words.append(element).append(", ");
            } else if (element.matches("\\D")) {
                symbols.append(element).append(", ");
            } else if (element.matches("\\d+")) {
                integers.append(element).append(", ");
            } else if (element.matches("\\d+.\\d+")) {
                floats.append(element).append(", ");
            }
        }

        if (!words.toString().equals("[]")) {
            words.setLength(words.length() - 2);
        } else if (!integers.toString().equals("[]")) {
            integers.setLength(integers.length() - 2);
        } else if (!symbols.toString().equals("[]")) {
            symbols.setLength(symbols.length() - 2);
        } else if (!floats.toString().equals("[]")) {
            floats.setLength(floats.length() - 2);
        }

        words.append("]");
        integers.append("]");
        symbols.append("]");
        floats.append("]");

        JSONArray jsonWords = new JSONArray(words.toString());
        JSONArray jsonIntegers = new JSONArray(integers.toString());
        JSONArray jsonSymbols = new JSONArray(symbols.toString());
        JSONArray jsonFloats = new JSONArray(floats.toString());

        jsonObject.put("Integers", jsonIntegers);
        jsonObject.put("Words", jsonWords);
        jsonObject.put("Floating point", jsonFloats);
        jsonObject.put("Symbols", jsonSymbols);

        return jsonObject;
    }

    public static JSONObject readFile(String filePath) {
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

        return new JSONObject(fileContent.toString());
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
