package tests;

import model.Homework;
import model.Item;
import model.Task;
import model.ToDoList;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSaveable {
//    @Test
//    public void testSave() throws IOException, ClassNotFoundException {
//        ToDoList testToDoList = new ToDoList();
//
//        Item a = new Homework("a","monday","math");
//        Item b = new Task("b");
//        Item c = new Task("c");
//        Item d = new Homework("d","thursday","programming");
//
//        testToDoList.helperMethods.completedItems.add(a);
//        testToDoList.helperMethods.completedItems.add(b);
//        testToDoList.helperMethods.toDoList.add(c);
//        testToDoList.helperMethods.toDoList.add(d);
//
//        ArrayList<Item> testList = new ArrayList<>();
//
//        testToDoList.helperMethods.save("testList1", "testList2", "testList3");
//
//        FileInputStream fis = new FileInputStream("testList1.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        testList = (ArrayList<Item>) ois.readObject();
//        ois.close();
//
//        assertEquals(testToDoList.helperMethods.toDoList.get(0).getName(), testList.get(0).getName());
//        assertEquals(testToDoList.helperMethods.toDoList.get(1).getName(), testList.get(1).getName());
//
//        FileInputStream fis2 = new FileInputStream("testList2.txt");
//        ObjectInputStream ois2 = new ObjectInputStream(fis2);
//        testList = (ArrayList<Item>) ois2.readObject();
//        ois2.close();
//
//        assertEquals(testToDoList.helperMethods.completedItems.get(0).getName(), testList.get(0).getName());
//        assertEquals(testToDoList.helperMethods.completedItems.get(1).getName(), testList.get(1).getName());
//
//    }
}
