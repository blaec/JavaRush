package com.javarush.task.task14.task1419;


import javax.management.BadAttributeValueExpException;
import javax.xml.xpath.XPathException;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.AlreadyBoundException;
import java.rmi.activation.ActivationException;
import java.security.acl.AclNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.exe"));
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] some = new int[2];
            System.out.println(some[10]);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ActivationException("anything");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new AclNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new AlreadyBoundException("ho-ho");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new AWTException("test");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new BackingStoreException("ho-ho");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new BadAttributeValueExpException("ho-ho");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new XPathException("D");
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
