package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        int filePartCount = 3;
        String[] fileNamePart = new String[filePartCount];
        fileNamePart[0] = ("C:\\Users\\blaec\\TEMP_JAVA\\song.7z.001");
        fileNamePart[1] = ("C:\\Users\\blaec\\TEMP_JAVA\\song.7z.002");
        fileNamePart[2] = ("C:\\Users\\blaec\\TEMP_JAVA\\song.7z.003");
        String resultFileName = "C:\\Users\\blaec\\TEMP_JAVA\\song.mp3";


//        if (args.length < 2) return;

//        String resultFileName = args[0];
//        int filePartCount = args.length - 1;
//        String[] fileNamePart = new String[filePartCount];
//        for (int i = 0; i < filePartCount; i++)
//        {
//            fileNamePart[i] = args[i + 1];
//        }
//        Arrays.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++)
        {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }
        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buf = new byte[1024 * 1024];
        while (zipInStream.getNextEntry() != null)
        {
            int count;
            while ((count = zipInStream.read(buf)) != -1)
            {
                fileOutStream.write(buf, 0, count);
            }
        }
        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
}