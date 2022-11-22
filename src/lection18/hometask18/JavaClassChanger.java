package lection18.hometask18;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaClassChanger {
    private File file;

    private String fileContent;

    public JavaClassChanger(String filePath) {
        this.file = new File(filePath);
    }

    public void changeModifierInClassMembers(String oldModifier, String newModifier) {
        readFileContent();
        String stringToChange = oldModifier + "(?!( class| static class))";
        fileContent = fileContent.replaceAll(stringToChange, newModifier);
        writeFileContent(file.getPath());
    }

    public void revertLinesInFile(String newFile) {
        readFileContent();
        StringBuilder newString = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        String[] linesInFile = fileContent.split("\n");
        for (String str : linesInFile) {
            stringBuilder.append(str);
            stringBuilder.reverse();
            newString.append(stringBuilder).append("\n");
            stringBuilder.delete(0, stringBuilder.length());
        }
        fileContent = newString.toString();
        writeFileContent(newFile);
    }

    private void readFileContent() {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try (var bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileContent = stringBuilder.toString();
    }

    public void changeWordCase(int minWordLengthLimit) {
        readFileContent();

        String[] words = fileContent.split("\\p{Punct}|\\n|\\s+");
        List<String> wordsWithParticularLength = new ArrayList<>();
        for (String word : words) {
            if (word.length() > minWordLengthLimit) {
                wordsWithParticularLength.add(word);
            }
        }
        for (String word : wordsWithParticularLength) {
            fileContent = fileContent.replaceAll(word, word.toUpperCase());
        }
        writeFileContent(file.getPath());
    }

    public void removeRedundantSpaces() {
        readFileContent();

        StringBuilder changedContent = new StringBuilder();
        String[] lines = fileContent.split("\n");
        for (String line : lines) {
            line = line.trim().replaceAll("\\s+", " ");
            if (!line.equals("")) {
                changedContent.append(line).append("\n");
            }
        }

        fileContent = changedContent.toString();
        writeFileContent(file.getPath());
    }

    public void removeComments() {
        readFileContent();

        fileContent = fileContent.replaceAll("(//.*\n)|(/\\*(.|\n)*\\*/)|(/\\*\\*(.|\n)*\\*/)", "");

        writeFileContent(file.getPath());
    }

    private void writeFileContent(String filePath) {
        try (var printWriter = new PrintWriter(new BufferedWriter(
                new FileWriter(filePath)
        ))) {
            printWriter.print(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
