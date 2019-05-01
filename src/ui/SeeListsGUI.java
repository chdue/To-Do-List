package ui;

import model.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeeListsGUI extends JFrame {
    JPanel jp;
    JLabel text;
    JLabel title;
    JPanel titlePanel;

    public SeeListsGUI(ArrayList<Item> arrayList, String s, boolean numbered){
        JPanel grid = new JPanel();

        int width = 200;
        setTitle(s);
        setSize(width, 800);
        setVisible(true);

        titlePanel = new JPanel();
        title = new JLabel(s);

        titlePanel.add(title);
        add(titlePanel);

        getContentPane().add(titlePanel, BorderLayout.NORTH);
        getContentPane().add(grid, BorderLayout.CENTER);

        int counter = 0;
        for (Item i : arrayList){
            jp = new JPanel();
            text = new JLabel();

            if (i.getType().equals("Task")) {
                if (numbered){
                    text.setText((counter+1) + ". Task: " + i.getName());
                }
                else {
                    text.setText("Task: " + i.getName());
                }
            }
            else{
                if (numbered) {
                    text.setText((counter+1) + ". Homework: " + i.getName());
                }
                else{
                    text.setText("Homework: " + i.getName());
                }
            }

            jp.add(text);
            grid.add(jp);
            counter++;
        }
        grid.setPreferredSize(new Dimension(width, counter));
        add(grid);
    }
}
