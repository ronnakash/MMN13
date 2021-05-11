import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SortedGroup<T extends Comparable<T>> {
    private ArrayList<T> sortedGroup;

    public SortedGroup(){
        sortedGroup = new ArrayList<T>();
    }

    public ArrayList<T> getSortedGroup() {
        return sortedGroup;
    }

    private void sortGroup(){
        Collections.sort(sortedGroup);
    }

    public void add(T newT){
        sortedGroup.add(newT);
        sortGroup();
    }

    public int remove(Object toRemove){
        int size = sortedGroup.size();
        sortedGroup.remove(toRemove);
        return size-sortedGroup.size();
    }

    public Iterator<T> iterator(){
        return sortedGroup.iterator();
    }

}
