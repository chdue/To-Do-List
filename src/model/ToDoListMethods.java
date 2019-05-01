package model;

import observer.AddingRemovingObserver;
import ui.GUI;

import java.io.*;
import java.util.*;

public class ToDoListMethods implements Loadable, Saveable, AddingRemovingObserver {
    public ArrayList<Item> toDoList;
    public ArrayList<Item> completedItems;
    public Map<String, List<Item>> days = new HashMap<>();
    int addStat=0;
    int removeStat=0;
    GUI gui = new GUI();

    // REQUIRES: nothing
    // MODIFIES: nothing
    // EFFECTS: prints out every item in both lists (completed and to do) with some information about the items
    public void printLists() {
        checkCorrectList();
        gui.printThroughAList(completedItems, "Completed Items", false);
        gui.printThroughAList(toDoList, "To-Do List", false);
//        System.out.println("------------------------------");
//        System.out.println("Items on List:");
//        System.out.println("------------------------------");
//        for (Item item: toDoList){
//            if (item.getType().equals("Task")){
//                System.out.println("Task: "+ item.getName());
//            }
//        }
//        sortItems();
//        System.out.println("------------------------------");
//        System.out.println("Completed Items:");
//        System.out.println("------------------------------");
//        for (Item item: completedItems){
//            if (item.getType().equals("Homework")){
//                System.out.println("Homework: "+ item.getCourse()+ ": " + item.getName() + ": Was due on: " + item.getDueDate());
//            }
//            else{
//                System.out.println("Task: " + item.getName());
//            }
//        }
        gui.setQuestion("Is there an error? [Y] or [N]?");
        String choice = gui.waitForInput();
        if (choice.equals ("Y") || choice.equals("y")){
            findError();
        }
    }

    public String getDate(String s){
        while(true) {
            if (s.equals("1")) {
                return "Monday";
            } else if (s.equals("2")) {
                return "Tuesday";
            } else if (s.equals("3")) {
                return "Wednesday";
            } else if (s.equals("4")) {
                return "Thursday";
            } else if (s.equals("5")) {
                return "Friday";
            } else if (s.equals("6")) {
                return "Saturday";
            } else if (s.equals("7")) {
                return "Sunday";
            }else {
                // Might want to make a new label that says "Try Again"
                gui.setQuestion("When is it due? [1] Monday, [2] Tuesday, [3] Wednesday, [4] Thursday, [5] Friday, [6] Saturday, [7] Sunday");
            }
        }
    }

    // REQUIRES: nothing
    // MODIFIES: moves an item over to the correct list if it is not in it already by checking status
    public void checkCorrectList() {
        ArrayList<Item> clearingList = new ArrayList<>();
        for (Item item: toDoList){
            if (item.list == completedItems){
                clearingList.add(item);
            }
        }
        for (Item item: clearingList){
            addToList(item, completedItems);
            removeFromList(item, toDoList);
        }
        clearingList.clear();

        for (Item item: completedItems){
            if (item.list == toDoList){
                clearingList.add(item);
            }
        }
        for (Item item: clearingList){
            addToList(item, toDoList);
            removeFromList(item, completedItems);
        }
        clearingList.clear();
    }

    public void addNewDay(String itemDueDate){
        List<Item> items = new ArrayList<>();
        if (!days.containsKey(itemDueDate)) {
            days.put(itemDueDate, items);
        }
    }

    public void addToDay(Item item, String day){
        List<Item> items = days.get(day);
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    // REQUIRES: nothing
    // MODIFIES: nothing
    // EFFECTS: sort items in the ToDoList into different categories based on due date and course
    public void sortItems(){
        List<Item> emptyList = new ArrayList<>();
        for (String day:days.keySet()) {
            if (!days.get(day).equals(emptyList)) {
                System.out.println("*Here are the items for " + day + " :");
                List<Item> items = days.get(day);
                for (Item item : items) {
                    if (toDoList.contains(item)) {
                        System.out.println(item.getCourse() + ": " + item.getName());
                    }
                }
            }
        }
    }

    // REQUIRES: nothing
    // MODIFIES: nothing
    // EFFECTS: grabs the item for correction and passes it into modifyItem
    public void findError() {
        gui.setQuestion("Is the error in the To-Do List [1] or the Completed List [2]?");
        String choice = gui.waitForInput();
        if (choice.equals ("1")){
            gui.printThroughAList(toDoList, "Which item?", true);
//            int i = 1;
//            for (Item item: toDoList){
//                System.out.println(i + ". " + item.getName());
//                i++;
//            }
            gui.setQuestion("Which item would you like to change?");
            String num = gui.waitForInput();
            int itemIndex = Integer.parseInt(num) - 1;
            modifyItem(toDoList.get(itemIndex));
        }
        else if (choice.equals ("2")){
            gui.printThroughAList(completedItems, "Which item?", true);
//            int i = 1;
//            for (Item item: completedItems){
//                System.out.println(i + ". " + item.getName());
//                i++;
//            }
            gui.setQuestion("Which item would you like to change?");
            String num = gui.waitForInput();
            int itemIndex = Integer.parseInt(num) - 1;
            modifyItem(completedItems.get(itemIndex));
        }
    }

    // REQUIRES: an item
    // MODIFIES: one of the item's parameters (information)
    public void modifyItem(Item item) {
        gui.setQuestion ("What is the error? Item Name [1]? Item Due Date [2]? Wrong List [3]? Item's Course [4] or Delete the Item [5]?");
        String choice = gui.waitForInput();
        if (choice.equals ("1")){
            gui.setQuestion("What would you like to change it to?");
            item.setName (gui.waitForInput());
        }
        else if (choice.equals ("2")){
            gui.setQuestion("What would you like to change it to?");
            item.setDueDate (gui.waitForInput());
        }
        else if (choice.equals ("3")){
            if (item.list == toDoList){
                addToList(item, completedItems);
                removeFromList(item, toDoList);
            }
            else if (item.list == completedItems){
                addToList(item, toDoList);
                removeFromList(item, completedItems);
            }
        }
        else if (choice.equals ("4")){
            gui.setQuestion("What would you like to change it to?");
            item.setCourse (gui.waitForInput());
        }
        else if (choice.equals("5")){
            if (item.list == toDoList){
                removeFromList(item, toDoList);
            }
            else{
                removeFromList(item, completedItems);
            }
        }
        printLists();
    }

    public static void addToList(Item item, ArrayList<Item> list){
        if(!list.contains(item)) {
            list.add(item);
            item.addList(list);
        }
    }

    public static void removeFromList(Item item, ArrayList<Item> list){
        if (list.contains(item)) {
            list.remove(item);
            item.removeList(list);
        }
    }

    public void addHW(){
        gui.setQuestion("What would you like to add to the list?");
        String name = gui.waitForInput();
        gui.setQuestion("When is it due? [1] Monday, [2] Tuesday, [3] Wednesday, [4] Thursday, [5] Friday, [6] Saturday, [7] Sunday");
        String dueDate = getDate(gui.waitForInput());
        gui.setQuestion("What class is it for?");
        String course = gui.waitForInput();
        Homework hw = new Homework(name, dueDate, course);
        addNewDay(hw.getDueDate());
        addToDay(hw, hw.dueDate);
        addToList(hw, toDoList);
        gui.Animation("Item Added");
        printLists();
    }

    public void addTask(){
        gui.setQuestion("What would you like to add to the list?");
        String name = gui.waitForInput();
        Task task = new Task(name);
        addToList(task, toDoList);
        gui.Animation("Item Added");
        printLists();
    }

    public void crossOffItem(){
        checkCorrectList();
        gui.printThroughAList(toDoList, "Cross off an item: ", true);
//        int i = 1;
//        for (Item item: toDoList){
//            System.out.println(i + ". " + item.getName());
//            i++;
//        }
        gui.setQuestion("What item would you like to cross off the list?");
        String crossOff = gui.waitForInput();
        int itemIndex = Integer.parseInt(crossOff) - 1;
        Item item = toDoList.get(itemIndex);
        addToList(item, completedItems);
        //item.addList(completedItems);
        removeFromList(item, toDoList);
        //item.removeList(ToDoList);
        gui.Animation("Item Completed");
        printLists();
    }

    @Override
    public void save(String s1, String s2, String s3) throws IOException {
        FileOutputStream fos = new FileOutputStream(s1+".txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(toDoList);
        oos.close();

        FileOutputStream fos2 = new FileOutputStream(s2+".txt");
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeObject(completedItems);
        oos2.close();

        FileOutputStream fos3 = new FileOutputStream(s3+".txt");
        ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
        oos3.writeObject(days);
        oos3.close();
    }

    @Override
    public void load(String s1, String s2, String s3) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(s1+".txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        toDoList = (ArrayList<Item>) ois.readObject();
        ois.close();

        FileInputStream fis2 = new FileInputStream(s2+".txt");
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        completedItems = (ArrayList<Item>) ois2.readObject();
        ois2.close();

        FileInputStream fis3 = new FileInputStream(s3+".txt");
        ObjectInputStream ois3 = new ObjectInputStream(fis3);
        days = (Map<String, List<Item>>) ois3.readObject();
        ois3.close();
    }

    public void createEmptyLists (){
        toDoList = new ArrayList<Item>();
        completedItems = new ArrayList<Item>();
        days = new HashMap<>();
    }

    @Override
    public void update(String s){
        if (s.equals("add")){
            addStat++;
        }
        else if (s.equals("remove")){
            removeStat++;
        }
    }

    @Override
    public int getAddStat(){
        return addStat;
    }

    @Override
    public int getRemoveStat(){
        return removeStat;
    }
}
