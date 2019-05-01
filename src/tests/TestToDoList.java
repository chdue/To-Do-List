package tests;

import model.Homework;
import model.Item;
import model.ToDoList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestToDoList {

    // Test to make sure the checkCorrectList() method works as expected
//    @Test
//    public void testCheckCorrectList(){
//        Item a = new Homework("a","","");
//        Item b = new Homework("b","","");
//        Item c = new Homework("c","","");
//        Item d = new Homework("d","","");
//
//        ToDoList testToDoList = new ToDoList();
//
//        b.list = testToDoList.helperMethods.completedItems;
//        c.list = testToDoList.helperMethods.completedItems;
//
//        testToDoList.helperMethods.toDoList.add(a);
//        testToDoList.helperMethods.toDoList.add(b);
//        testToDoList.helperMethods.completedItems.add(c);
//        testToDoList.helperMethods.completedItems.add(d);
//
//        testToDoList.helperMethods.checkCorrectList();
//
//        assertEquals(a, testToDoList.helperMethods.toDoList.get(0));
//        assertEquals(b, testToDoList.helperMethods.completedItems.get(1));
//        assertEquals(c, testToDoList.helperMethods.completedItems.get(0));
//        assertEquals(d, testToDoList.helperMethods.toDoList.get(1));
//    }
}
