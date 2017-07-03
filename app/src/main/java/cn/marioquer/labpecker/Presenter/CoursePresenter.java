package cn.marioquer.labpecker.Presenter;

import java.util.List;

import cn.marioquer.labpecker.Bean.Course.Project;

/**
 * Created by marioquer on 2017/7/3.
 */

public interface CoursePresenter {
    public void getExams(int courseId);

    public void getHomeworks(int courseId);

    public void getExercises(int courseId);
}
