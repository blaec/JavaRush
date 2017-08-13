package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String fileWin = args[0];
        String fileUtf = args[1];
        Charset utf8 = Charset.forName("UTF-8");
        Charset win1251 = Charset.forName("Windows-1251");
//        String test = new String(win1251TestString.getBytes(), utf8);
//        System.out.println(new String(test.getBytes(win1251)));

        FileInputStream fis = new FileInputStream(fileWin);
        FileOutputStream fos = new FileOutputStream(fileUtf);

        if (fis.available() > 0) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String text = new String(buffer, utf8);
            buffer = text.getBytes(win1251);
            fos.write(buffer);
//            fos.write(new String(buffer, "UTF-8").getBytes("Windows-1251"));
            fos.flush();
        }

        fis.close();
        fos.close();
    }
}