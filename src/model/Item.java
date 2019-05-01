package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Item implements Serializable {
    public String name;
    //public boolean status;
    public String dueDate;
    public String course;
    public ArrayList<Item> list;

    public void setName(String name){
        this.name = name;
    }
//    public void setStatus(Boolean status){
//        this.status = status;
//    }

    public String getName(){
        return name;
    }
//    public Boolean getStatus(){
//        return status;
//    }
    public ArrayList<Item> getList() {
        return list;
    }

    public void setDueDate(String dueDate){
    }
    public void setCourse(String course){
    }
    public String getDueDate(){
        return null;
    }
    public String getCourse(){
        return null;
    }

    public abstract String getType();

    public void addList(ArrayList<Item> list){
        if(this.list!=list) {
            this.list = list;
            ToDoListMethods.addToList(this, list);
        }
    }
    public void removeList(ArrayList<Item> list) {
        if(this.list == list) {
            this.list = new ArrayList<Item>();
            ToDoListMethods.removeFromList(this, list);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(dueDate, item.dueDate) &&
                Objects.equals(course, item.course);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, dueDate, course);
    }
}
