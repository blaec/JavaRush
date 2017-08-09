package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Field extends JPanel {
    private EventListener eventListener;
    private View view;


    public Field(View view) throws HeadlessException {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
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

    public class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case (KeyEvent.VK_LEFT):    eventListener.move(Direction.LEFT);     break;
                case (KeyEvent.VK_RIGHT):   eventListener.move(Direction.RIGHT);    break;
                case (KeyEvent.VK_UP):      eventListener.move(Direction.UP);       break;
                case (KeyEvent.VK_DOWN):    eventListener.move(Direction.DOWN);     break;
                case (KeyEvent.VK_R):       eventListener.restart();                break;
            }
        }
    }
}
