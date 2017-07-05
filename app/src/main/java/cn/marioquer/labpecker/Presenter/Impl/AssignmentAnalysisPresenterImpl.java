package cn.marioquer.labpecker.Presenter.Impl;

import cn.marioquer.labpecker.Bean.Assignment.Student.Analysis;
import cn.marioquer.labpecker.HttpService.StudentService;
import cn.marioquer.labpecker.Presenter.AssignmentAnalysisPresenter;
import cn.marioquer.labpecker.Util.RetrofitUtil;
import cn.marioquer.labpecker.View.AssignmentAnalysisView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marioquer on 2017/7/5.
 */

public class AssignmentAnalysisPresenterImpl implements AssignmentAnalysisPresenter {

    AssignmentAnalysisView assignmentAnalysisView = null;
    StudentService studentService = null;

    public AssignmentAnalysisPresenterImpl(AssignmentAnalysisView assignmentAnalysisView) {
        this.assignmentAnalysisView = assignmentAnalysisView;
        studentService = RetrofitUtil.getRetroService(StudentService.class);
    }

    @Override
    public void getAssignmentAnalysis(int studentId, int assignmentId) {
        Call<Analysis> call = studentService.getAnalysis(assignmentId, studentId);
        call.enqueue(new Callback<Analysis>() {
            @Override
            public void onResponse(Call<Analysis> call, Response<Analysis> response) {
                assignmentAnalysisView.initAnalyses(response.body());
            }

            @Override
            public void onFailure(Call<Analysis> call, Throwable t) {
            }
        });
    }
}
