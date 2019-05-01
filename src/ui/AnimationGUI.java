package ui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnimationGUI extends JFrame {
    private static Object lock = new Object();

    JPanel jp;
    JLabel text;
    ImageIcon img;

    public AnimationGUI(String title){
        jp = new JPanel();
        if (title.equals("Item Added")) {
            img = new ImageIcon("images/itemAdded.gif");
        }
        else if (title.equals("Item Completed")){
            img = new ImageIcon("images/itemCompleted.gif");
        }
        text = new JLabel(img, JLabel.CENTER);

        setTitle(title);
        setSize(250, 250);
        setVisible(true);

        jp.add(text);
        add(jp);

        // Below was a method taken from the answer here: https://stackoverflow.com/questions/1341699/how-do-i-make-a-thread-wait-for-jframe-to-close-in-java
        // This method makes the program wait for the user to close the animation frame

        Thread t = new Thread() {
            public void run() {
                synchronized(lock) {
                    while (isVisible())
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        };
        t.start();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent arg0) {
                synchronized (lock) {
                    setVisible(false);
                    lock.notify();
                }
            }

        });

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
