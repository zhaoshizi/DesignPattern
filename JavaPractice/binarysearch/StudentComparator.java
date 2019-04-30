package binarysearch;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student stu1, Student stu2) {
        return stu1.compareTo(stu2);
    }
    
}