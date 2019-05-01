package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Homework extends Item implements Serializable {
//    private String dueDate;
//    private String course;

    public Homework(String name, String dueDate, String course) {
        this.name = name;
        this.dueDate = dueDate;
        //this.status = false;
        this.course = course;
        this.list = new ArrayList<Item>();
    }

    // REQUIRES: an item and a string
    // MODIFIES: the item's due date
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    // REQUIRES: an item and a string
    // MODIFIES: the item's course
    public void setCourse(String course){
        this.course = course;
    }

    // REQUIRES: an item
    // MODIFIES: nothing
    // EFFECTS: returns the item's due date
    public String getDueDate(){
        return (dueDate);
    }

    // REQUIRES: an item
    // MODIFIES: nothing
    // EFFECTS: returns the item's course
    public String getCourse(){
        return(course);
    }

    public String getType(){
        return ("Homework");
    }
}
