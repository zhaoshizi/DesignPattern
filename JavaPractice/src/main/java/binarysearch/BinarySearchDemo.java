package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;
public class BinarySearchDemo {
    public static void main(String[] args){
        Student stu1 = new Student(20,"zs");
        Student stu2 = new Student(18,"ls");
        Student stu3 = new Student(22,"ww");
        Student stu4 = new Student(11,"ql");
        Student stu5 = new Student(50,"sq");
        Student stu6 = new Student(21,"wb");
        Student stu7 = new Student(21,"hj");

        List<Student> stuList =new  ArrayList<Student>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
        stuList.add(stu5);
        stuList.add(stu6);
        stuList.add(stu7);

        //Collections.sort(stuList,new StudentComparator());
        Collections.sort(stuList,(x,y)->{
            int r = Integer.compare(x.stuAge,y.stuAge);
            if (r == 0){
                return x.stuName.compareTo(y.stuName);
            }
            return r;
        });
        for (Student stu : stuList){
            System.out.println(stu.stuAge + "\t" + stu.stuName);
        }
        int i = BinarySearchStudent.binarySearch(stuList, stu6,0);
        System.out.println("次序为:" +i);

    }
}