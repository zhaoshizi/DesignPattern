package binarysearch;


public class Student{
    public int stuAge;
    public String stuName;
    Student(int stuAge, String stuName){
        this.stuAge = stuAge;
        this.stuName = stuName;
    }

    public int compareTo(Student stu){
        if(this == stu)
            return 0;
        else if(this!=null && stu==null)
            return 1;
        else 
            if (this.stuAge > stu.stuAge)
                return 1;
            else if(this.stuAge < stu.stuAge)
                return -1;
            else
                if(this.stuName.compareTo(stu.stuName) > 0)
                    return 1;
                else if(this.stuName.compareTo(stu.stuName) < 0)
                    return -1;
                else
                    return 0;
    }

    @Override
    public boolean equals(Object obj){
        Student stu = (Student)obj;
        if (this.stuAge == stu.stuAge && this.stuName.equals(stu.stuName))
            return true;
        return false;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 0;
        result = prime * result + this.stuAge%prime;
        result = prime * result + ((this.stuName==null)?0:stuName.hashCode());
        return result;
    }
}