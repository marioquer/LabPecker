package cn.marioquer.labpecker.Bean.Assignment.Student;

import java.util.List;

/**
 * Created by marioquer on 2017/7/2.
 */

public class Analysis {
    int studentId;
    int assignmentId;
    List<QuestionResult> questionResults;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public List<QuestionResult> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(List<QuestionResult> questionResults) {
        this.questionResults = questionResults;
    }
}
