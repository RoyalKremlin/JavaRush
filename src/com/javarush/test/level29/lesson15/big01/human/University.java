package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University  {

    private List<Student> students = new ArrayList<>();
    protected int age;
    protected String name;

    public University(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }



    public Student getStudentWithAverageGrade(double averageGrade) {
        Student student = null;
        for (Student student1 : students)
        {
            if (student1.getAverageGrade()==averageGrade)
            {
                student = student1;
                break;
            }
        }
        //TODO:
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        List<Student> students = getStudents();
        return Collections.max(students, new Comparator<Student>()
        {
            @Override
            public int compare(Student o1, Student o2)
            {
                return Double.compare(o1.getAverageGrade(),o2.getAverageGrade());
            }
        });
    }

    public Student getStudentWithMinAverageGrade(){
        return Collections.min(students, new Comparator<Student>()
        {
            @Override
            public int compare(Student o1, Student o2)
            {
                return Double.compare(o1.getAverageGrade(),o2.getAverageGrade());
            }
        });
    }

    public void expel(Student student){
        students.remove(student);
    }
}
