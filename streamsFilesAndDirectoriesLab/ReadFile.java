package streamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\Runador\\Documents\\Java Advanced\\Java-Advanced\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";

        try (FileInputStream inputStream = new FileInputStream(path)){
            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                /*System.out.printf("%c ", (char) oneByte);*/
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
