package cn.marioquer.labpecker.View;

import android.view.View;

import java.util.List;

import cn.marioquer.labpecker.Bean.Assignment.Teacher.Question;

/**
 * Created by marioquer on 2017/7/5.
 */

public interface AssignmentView {

    public void initQuestions(List<Question> questions);

    public void jumpToQuestion(View view);
}
