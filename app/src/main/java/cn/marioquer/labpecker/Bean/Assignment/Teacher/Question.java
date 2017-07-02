package cn.marioquer.labpecker.Bean.Assignment.Teacher;

import java.util.List;

/**
 * Created by marioquer on 2017/7/2.
 */

public class Question {
    QuestionInfo questionInfo;
    List<StudentScore> students;

    public QuestionInfo getQuestionInfo() {
        return questionInfo;
    }

    public void setQuestionInfo(QuestionInfo questionInfo) {
        this.questionInfo = questionInfo;
    }

    public List<StudentScore> getStudents() {
        return students;
    }

    public void setStudents(List<StudentScore> students) {
        this.students = students;
    }
}
