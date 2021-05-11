import java.util.Iterator;
import java.util.Random;

public class Q1Main {

    public static <T extends Comparable<T>> SortedGroup<T> reduce(SortedGroup<T> sGroup, T toCompare){
        SortedGroup<T> reduced = new SortedGroup<T>();
        Iterator<T> groupIt = sGroup.iterator();
        while (groupIt.hasNext()){
            T tempT = groupIt.next();
            if(tempT.compareTo(toCompare) == 1)
                reduced.add(tempT);
        }
        return reduced;
    }

    public static void main(String[] args) {
        SortedGroup studentGroup = new SortedGroup<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Student tempStudent = new Student("Student","12345678", random.nextInt(100));
            studentGroup.add(tempStudent);
            System.out.println(tempStudent);
        }
        SortedGroup passingGradesGroup = reduce(studentGroup, new Student("","",60));
        System.out.println("\n\nsize after: "+ passingGradesGroup.getSortedGroup().size() + "\n\n");
        Iterator<Student> passingGradesIterator = passingGradesGroup.iterator();
        while (passingGradesIterator.hasNext())
            System.out.println(passingGradesIterator.next());
    }

}
