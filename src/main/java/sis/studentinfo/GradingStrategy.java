package sis.studentinfo;

/**
 * Created by Administrator on 2017-02-14.
 */
public interface GradingStrategy {
    int getGradePointsFor(Student.Grade grade);
}
