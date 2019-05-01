package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Task extends Item implements Serializable {

    public Task(String name) {
        this.name = name;
        //this.status = false;
        this.list = new ArrayList<Item>();
    }

    public String getType(){
        return ("Task");
    }
}
