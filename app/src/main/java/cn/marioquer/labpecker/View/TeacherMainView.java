package cn.marioquer.labpecker.View;

import android.view.View;

import java.util.List;

import cn.marioquer.labpecker.Bean.Course.Project;
import cn.marioquer.labpecker.Bean.Group;

/**
 * Created by marioquer on 2017/7/3.
 */

public interface TeacherMainView {

    //填充各选项卡内容
    public void initGroups(List<Group> groups);

    public void initCourses();


    //跳转
    public void jumpToCourse(View view);

    public void jumpToGroup(View view);

}
