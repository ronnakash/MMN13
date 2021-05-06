public class Student implements Comparable {
    String name;
    String id;
    int grade;

    public Student (String name, String id, int grade){
        this.grade = grade;
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (o==null  || !(o instanceof Student))
            try {
                throw (new ClassNotFoundException("Object to compare is not of type Student"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        if (this.grade == ((Student) o).grade) return 0;
            return this.grade > ((Student) o).grade ? 1 : -1;
    }

    public String toString(){
        return "Student Name: " + name + "\nStudent id: " + id + "\nStudent Grade: " + grade;
    }
}
