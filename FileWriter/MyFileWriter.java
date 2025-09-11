package FileWriter;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void main(String[] args) {
        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeHidden() {
        String fileName = ".secretpassword.txt";
        String password = "getsendywiththepassword";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeRegular() {
        String dirName = ".classified";
        String fileName = "confidential.dat";
        String confidential = "very top top top secret information goe shere";
        File dir = new File(dirName);
        if (!dir.exists()) dir.mkdir();

        try (FileWriter writer = new FileWriter(dirName + "/" + fileName)) {
            writer.write(confidential);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}