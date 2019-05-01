package tests;

import model.Homework;
import model.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestItem {

    // Test that the constructor parameters work as expected,
    //    and that the get___ methods work as expected
    @Test
    public void testConstructorParameters(){
        Item i = new Homework("name","due date","course");
        assertEquals(i.getName(), "name");
        assertEquals(i.getDueDate(), "due date");
        assertEquals(i.list, new ArrayList<Item>());
        assertEquals(i.getCourse(), "course");
    }

    // Test that the set___ methods work as expected
    @Test
    public void testChangeItemInfo(){
        Item i = new Homework("","","");
        i.setName("WebWork");
        assertEquals("WebWork", i.getName());

        i.setDueDate("Friday");
        assertEquals("Friday", i.getDueDate());

//        i.setStatus(true);
//        assertEquals(true, i.getStatus());

        i.setCourse("Math");
        assertEquals("Math", i.getCourse());
    }
}
