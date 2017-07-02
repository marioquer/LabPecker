package cn.marioquer.labpecker.Bean.Assignment.Teacher;

import java.util.List;

/**
 * Created by marioquer on 2017/7/2.
 */

public class AssignmentDetail {
    int assignmentId;
    List<Question> questions;

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }
}
