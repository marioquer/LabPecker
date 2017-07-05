package cn.marioquer.labpecker.Presenter.Impl;

import cn.marioquer.labpecker.Bean.Assignment.Teacher.AssignmentDetail;
import cn.marioquer.labpecker.HttpService.TeacherService;
import cn.marioquer.labpecker.Presenter.AssignmentAnalysisPresenter;
import cn.marioquer.labpecker.Presenter.AssignmentPresenter;
import cn.marioquer.labpecker.Util.RetrofitUtil;
import cn.marioquer.labpecker.View.AssignmentView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marioquer on 2017/7/5.
 */

public class AssignmentPresenterImpl implements AssignmentPresenter {
    AssignmentView assignmentView;
    TeacherService teacherService;

    public AssignmentPresenterImpl(AssignmentView assignmentView) {
        this.assignmentView = assignmentView;
        teacherService = RetrofitUtil.getRetroService(TeacherService.class);
    }

    @Override
    public void getAssignment(int assignmentId) {
        Call<AssignmentDetail> call = teacherService.getAssignmentDetail(assignmentId);
        call.enqueue(new Callback<AssignmentDetail>() {
            @Override
            public void onResponse(Call<AssignmentDetail> call, Response<AssignmentDetail> response) {
                assignmentView.initQuestions(response.body().getQuestions());
            }

            @Override
            public void onFailure(Call<AssignmentDetail> call, Throwable t) {
            }
        });
    }
}
