package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.model.Box;
import com.javarush.task.task34.task3410.model.Home;
import com.javarush.task.task34.task3410.model.Player;
import com.javarush.task.task34.task3410.model.Wall;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private View view;

    public Field(View view) throws HeadlessException {
        this.view = view;
    }

    // https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
    public void paint(Graphics g) {
        Player player = new Player(70, 70);
        Home home = new Home(70,70);
        Box box = new Box(70, 70);
        Wall wall = new Wall(100,100);
        player.draw(g);
        home.draw(g);
        box.draw(g);
        wall.draw(g);
    }
}
