import java.io.Serializable;
import java.util.Hashtable;

public class MemoTable implements Serializable {
    private Hashtable<Date,Memo> memoHashTable;

    public MemoTable() {
        this.memoHashTable = new Hashtable<Date,Memo>();
    }

    public void add(Date date, Memo memo){
        memoHashTable.put(date, memo);
    }

    public void remove(Date date){
        memoHashTable.remove(date);
    }

    public Memo getMemo(Date date){ // returns memo from select date, if there is none return new empty memo
        Memo temp = memoHashTable.get(date);
        return temp == null ? new Memo("") : temp;
    }

}