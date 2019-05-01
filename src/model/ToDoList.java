package model;

import observer.Subject;

import java.io.*;

public class ToDoList extends Subject {
    public ToDoListMethods helperMethods = new ToDoListMethods();

    public void run() {
        try {
            helperMethods.load("ToDoList", "completedItems", "days");
        } catch (IOException e) {
            System.out.println("No save file found, starting a new set of lists");
            helperMethods.createEmptyLists();
        }catch (ClassNotFoundException e) {
            System.out.println("Empty file, starting a new set of lists");
            helperMethods.createEmptyLists();
        }

        addObserver(helperMethods);

        while (true){
            helperMethods.gui.setQuestion("Would you like to see the list [1], add to the list [2], cross off an item [3], save [4]?");
            //System.out.println("Would you like to see the list [1], add to the list [2], cross off an item [3], save [4], or view stats [5]?");
            String choice = helperMethods.gui.waitForInput();
            if (choice.equals ("1")){
                helperMethods.printLists();
            }
            else if (choice.equals ("2")){
                helperMethods.checkCorrectList();
                helperMethods.gui.setQuestion("Is it homework [1] or a task [2]?");
                String nextChoice = helperMethods.gui.waitForInput();
                if (nextChoice.equals("1")) {
                    helperMethods.addHW();
                    notifyObservers("add");
                }
                else if (nextChoice.equals("2")) {
                    helperMethods.addTask();
                    notifyObservers("add");
                }
            }
            else if (choice.equals ("3")){
                helperMethods.crossOffItem();
                notifyObservers("remove");
            }
            else if (choice.equals("4")){
                try {
                    helperMethods.save("ToDoList", "completedItems", "days");
                } catch (IOException e) {
                    System.out.println("IOException, could not save");
                }
            }
//            else if (choice.equals("5")){
//                printStats();
//            }
        }
    }
}
