package cn.marioquer.labpecker.Presenter.Impl;

import cn.marioquer.labpecker.Presenter.StudentMainPresenter;
import cn.marioquer.labpecker.View.StudentMainView;

/**
 * Created by marioquer on 2017/7/5.
 */

public class StudentMainPresenterImpl implements StudentMainPresenter {

    StudentMainView studentMainView = null;

    public StudentMainPresenterImpl(StudentMainView studentMainView) {
        this.studentMainView = studentMainView;
    }

    @Override
    public void getCourses() {
        studentMainView.initCourses();
    }

    @Override
    public void getAssignments() {
        studentMainView.initAssignments();
    }
}
