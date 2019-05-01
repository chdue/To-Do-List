package observer;

public interface AddingRemovingObserver {

    void update(String s);

    int getAddStat();

    int getRemoveStat();
}
