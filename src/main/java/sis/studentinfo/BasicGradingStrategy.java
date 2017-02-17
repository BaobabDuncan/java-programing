package sis.studentinfo;

/**
 * Created by Administrator on 2017-02-16.
 */
public class BasicGradingStrategy implements GradingStrategy {
    public int getGradePointsFor(Student.Grade grade){
        return grade.getPoints();
    }
}
