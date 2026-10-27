package com.pluralsight;
import java.io.*;
import java.util.*;

public class StoryReader {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String storyToRead = getInputFromConsole("Enter a story to display: ", s, false);
        s.close();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + storyToRead));
            int lineCount = 1;
            do {
                System.out.println(lineCount + ". " + reader.readLine());
                lineCount++;
            } while (reader.readLine() != null);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getInputFromConsole(String display, Scanner s, boolean clearBuffer) {
        if (clearBuffer) s.nextLine();
        System.out.println(display);
        return s.nextLine().trim();
    }
}
