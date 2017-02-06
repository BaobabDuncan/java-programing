package sis.studentinfo;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2017-02-01.
 */
public class StudentTest extends TestCase {
    public void testCreate(){

        final String firstStudentName = "Jane Doe";
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());


        final String secondStudentName = "Joe Blow";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());

    }
}