package cn.marioquer.labpecker.View;

import android.view.View;

import java.util.List;

import cn.marioquer.labpecker.Bean.Course.Project;

/**
 * Created by marioquer on 2017/7/3.
 */

public interface CourseView {

    //填充数据
    public void initExams(List<Project> exams);

    public void initHomeworks(List<Project> homeworks);

    public void initExercises(List<Project> exercises);

    //跳转逻辑
    public void jumpToExam(View view);

    public void jumpToHomework(View view);

    public void jumpToExercise(View view);
}
