package ui;

import model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {

    JPanel jpInput;
    JLabel jlWritten;
    JTextField jt;
    public JButton jb;

    JLabel question;

    JPanel panel;
    JPanel panel2;

    public GUI(){
        panel = new JPanel();
        jpInput = new JPanel();
        panel2 = new JPanel();

        jlWritten = new JLabel();
        jt = new JTextField(30);
        jb = new JButton("Enter");

        setTitle("ToDoList Application");
        setSize(800, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        JLabel youWrote = new JLabel("You Wrote: ");

        jpInput.add(jt);
        jpInput.add(jb);
        jpInput.add(youWrote);
        jpInput.add(jlWritten);
        add(jpInput);

        question = new JLabel();

        panel.add(question);
        add(panel);

        JLabel pleaseRespond = new JLabel("Please Respond: ");

        panel2.add(pleaseRespond);
        add(panel2);

        getContentPane().add(jpInput, BorderLayout.SOUTH);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(panel2, BorderLayout.NORTH);

        jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = jt.getText();
                jlWritten.setText(input);
                jt.setText("");
            }
        });

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = jt.getText();
                jlWritten.setText(input);
                jt.setText("");
            }
        });
    }

    public String waitForInput() {
        String s = jlWritten.getText();
        while (jlWritten.getText() == s){
            jlWritten.setText(s);
        }
        return jlWritten.getText();
    }

    public void printThroughAList(ArrayList<Item> arrayList, String s, boolean numbered){
        SeeListsGUI sLGUI = new SeeListsGUI(arrayList, s, numbered);
    }

    public void setQuestion(String question) {
        this.question.setText(question);
    }

    public void Animation(String s) {
        AnimationGUI aGUI = new AnimationGUI(s);
        while (aGUI.isVisible()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
