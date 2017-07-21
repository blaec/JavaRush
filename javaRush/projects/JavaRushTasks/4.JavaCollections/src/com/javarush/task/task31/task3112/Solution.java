package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
//        Path passwords = downloadFile("https://www.amigo.com/ship/secretPassword.txt", Paths.get("D:/MyDownloads"));
        Path passwords = downloadFile("https://github.com/danielmiessler/SecLists/blob/master/Passwords/10_million_password_list_top_100.txt", Paths.get("C:/Users/blaec/TEMP_JAVA"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile("temp3112-","tmp");
        Files.copy(inputStream,tempFile, StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();

        String fileName=urlString.substring(urlString.lastIndexOf("/"));
        Path resultFile = Paths.get(downloadDirectory.toString() + fileName);
        Files.move(tempFile, resultFile, StandardCopyOption.REPLACE_EXISTING);
        return resultFile;
    }
}
