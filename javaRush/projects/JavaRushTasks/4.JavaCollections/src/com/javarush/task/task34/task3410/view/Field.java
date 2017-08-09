package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class Field extends JPanel {
    private EventListener eventListener;
    private View view;

    public Field(View view) throws HeadlessException {
        this.view = view;
    }

    // https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1000,1000);

        Set<GameObject> gameObjectSet = view.getGameObjects().getAll();

        for (GameObject gameObject : gameObjectSet) {
            gameObject.draw(g);
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
