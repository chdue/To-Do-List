package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    public List<AddingRemovingObserver> observers = new ArrayList<>();

    public void addObserver(AddingRemovingObserver o){
        if (!observers.contains (o)){
            observers.add(o);
        }
    }

    public void notifyObservers (String s){
        for (AddingRemovingObserver o : observers){
            o.update(s);
        }
    }

    public void printStats(){
        for (AddingRemovingObserver o : observers){
            System.out.println("This is the number of items you have added this session: " + o.getAddStat());
            System.out.println("This is the number of items you have removed this session: " + o.getRemoveStat());
        }
    }
}
