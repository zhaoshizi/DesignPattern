package binarysearch;

import java.util.List;

public class BinarySearchStudent {
    public static int binarySearch(List<Student> array,Student student,int begin) {
        if (array.isEmpty())
            return -1;
        Student tempStu = array.get(array.size()/2);
        int i = tempStu.compareTo(student);
        if (i == 0)
            return begin + array.size()/2;
        else if (i>0)
            return binarySearch(array.subList(0, array.size()/2),student,begin);
        else
            return binarySearch(array.subList(array.size()/2,array.size()),student,begin+array.size()/2);
        
    }
}