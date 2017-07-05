package cn.marioquer.labpecker.View;

import android.view.View;

import java.util.List;

import cn.marioquer.labpecker.Bean.Assignment.Student.Analysis;

/**
 * Created by marioquer on 2017/7/5.
 */

public interface AssignmentAnalysisView {

    public void initAnalyses(Analysis analysis);

    public void jumpToQuestionResult(View view);
}
