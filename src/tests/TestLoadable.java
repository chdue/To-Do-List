package tests;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestLoadable {

//    @Test
//    public void testLoad() throws IOException, ClassNotFoundException {
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
//        testToDoList.helperMethods.save("testList1", "testList2", "testList3");
//
//        testToDoList.helperMethods.toDoList.clear();
//        testToDoList.helperMethods.completedItems.clear();
//
//        testToDoList.helperMethods.load("testList1", "testList2", "testList3");
//
//        assertEquals(a.getName(), testToDoList.helperMethods.completedItems.get(0).getName());
//        assertEquals(b.getName(), testToDoList.helperMethods.completedItems.get(1).getName());
//        assertEquals(c.getName(), testToDoList.helperMethods.toDoList.get(0).getName());
//        assertEquals(d.getName(), testToDoList.helperMethods.toDoList.get(1).getName());
//    }
//
//    @Test
//    public void testFileNotFoundException(){
//        ToDoList testToDoList = new ToDoList();
//        try {
//            testToDoList.helperMethods.load("notHere", "notHereEither", "notHereAtAll");
//        } catch (IOException e) {
//            System.out.println("Caught the exception");
//        } catch (ClassNotFoundException e) {
//            fail("Did not, not find a file");
//        }
//    }
}
