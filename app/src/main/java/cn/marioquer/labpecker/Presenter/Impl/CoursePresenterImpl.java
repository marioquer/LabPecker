package cn.marioquer.labpecker.Presenter.Impl;

import java.util.List;

import cn.marioquer.labpecker.Bean.Course.Project;
import cn.marioquer.labpecker.HttpService.CommonService;
import cn.marioquer.labpecker.Presenter.CoursePresenter;
import cn.marioquer.labpecker.Util.RetrofitUtil;
import cn.marioquer.labpecker.View.CourseView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marioquer on 2017/7/3.
 */

public class CoursePresenterImpl implements CoursePresenter {

    CourseView courseView = null;
    CommonService commonService = null;

    public CoursePresenterImpl(CourseView courseView) {
        this.courseView = courseView;
        commonService = RetrofitUtil.getRetroService(CommonService.class);
    }

    @Override
    public void getExams(int courseId) {
        Call<List<Project>> call = commonService.getExams(courseId);
        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                courseView.initExams(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getHomeworks(int courseId) {
        Call<List<Project>> call = commonService.getHomeworks(courseId);
        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                courseView.initHomeworks(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getExercises(int courseId) {
        Call<List<Project>> call = commonService.getExercises(courseId);
        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                courseView.initExercises(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

            }
        });
    }
}
