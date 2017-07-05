package cn.marioquer.labpecker.View;

import android.view.View;

import java.util.List;

/**
 * Created by marioquer on 2017/7/5.
 */

public interface StudentMainView {
    //填充各选项卡内容
    public void initAssignments();

    public void initCourses();

    //跳转
    public void jumpToCourse(View view);

    public void jumpToAssignment(View view);

}
