package cn.marioquer.labpecker.Presenter.Impl;

import cn.marioquer.labpecker.Bean.Assignment.Student.Readme;
import cn.marioquer.labpecker.HttpService.StudentService;
import cn.marioquer.labpecker.Presenter.QuestionResultPresenter;
import cn.marioquer.labpecker.Util.RetrofitUtil;
import cn.marioquer.labpecker.View.QuestionResultView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marioquer on 2017/7/5.
 */

public class QuestionResultPresenterImpl implements QuestionResultPresenter {

    QuestionResultView questionResultView = null;
    StudentService studentService = null;

    public QuestionResultPresenterImpl(QuestionResultView questionResultView) {
        this.questionResultView = questionResultView;
        studentService = RetrofitUtil.getRetroService(StudentService.class);
    }

    @Override
    public void getReadme(int assignmentId, int studentId, int questionId) {
        Call<Readme> call = studentService.getReadme(assignmentId, studentId, questionId);
        call.enqueue(new Callback<Readme>() {
            @Override
            public void onResponse(Call<Readme> call, Response<Readme> response) {
                questionResultView.initQuestionResult(response.body());
            }

            @Override
            public void onFailure(Call<Readme> call, Throwable t) {
            }
        });
    }
}
