package lection18.hometask18;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileChanger {
    private File file;

    private String fileContent;

    public FileChanger(String filePath) {
        this.file = new File(filePath);
    }

    public void deleteMaxEvenNumberOfWordsInTheLine(int startPosition, int endPosition) {
        readFileContent();
        StringBuilder changedContent = new StringBuilder();
        int index;
        int lengthOfWordTORemove;
        List<String> wordsInLine;
        List<Integer> indexOfWordToDelete = new ArrayList<>();
        String[] lines = fileContent.split("\\n");
        for (String line : lines) {
            wordsInLine = new ArrayList<>(Arrays.stream(line.split("\\b")).toList());
            for (int i = 0; i < wordsInLine.size(); i++) {
                if (wordsInLine.get(i).matches("\\w+") && wordsInLine.get(i).length() >= startPosition && wordsInLine.get(i).length() <= endPosition) {
                    indexOfWordToDelete.add(i);
                    if (indexOfWordToDelete.size() == 2) {
                        index = indexOfWordToDelete.get(0);
                        lengthOfWordTORemove = wordsInLine.get(index).length();
                        wordsInLine.remove(index);
                        wordsInLine.add(index, " ".repeat(lengthOfWordTORemove));

                        index = indexOfWordToDelete.get(1);
                        lengthOfWordTORemove = wordsInLine.get(index).length();
                        wordsInLine.remove(index);
                        wordsInLine.add(index, " ".repeat(lengthOfWordTORemove));

                        indexOfWordToDelete.clear();
                    }
                }
            }

            for (String word : wordsInLine) {
                changedContent.append(word);
            }
            changedContent.append("\n");
        }
        fileContent = changedContent.toString();
        writeFileContent(file.getPath());
    }

    public void changeLastAndFirstWordOFTheLine() {
        readFileContent();

        StringBuilder resultContent = new StringBuilder();

        String[] punctuation;
        String[] words;
        String temp;

        String[] lines = fileContent.split("\n");
        for (String line : lines) {
            words = line.split("\\p{Punct}\\s*|\\n|\\s+");
            punctuation = line.split("\\w+");

            temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;

            for (int i = 0; i < words.length; i++) {
                resultContent.append(punctuation[i]).append(words[i]);
            }

            if (line.matches(".*\\p{Punct}")) {
                resultContent.append(punctuation[punctuation.length - 1]);
            }
            resultContent.append("\n");
        }
        fileContent = resultContent.toString();
        writeFileContent(file.getPath());
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
