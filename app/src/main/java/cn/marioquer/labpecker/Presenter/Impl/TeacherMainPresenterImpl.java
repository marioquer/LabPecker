package cn.marioquer.labpecker.Presenter.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.marioquer.labpecker.Bean.Group;
import cn.marioquer.labpecker.HttpService.TeacherService;
import cn.marioquer.labpecker.Presenter.TeacherMainPresenter;
import cn.marioquer.labpecker.Util.RetrofitUtil;
import cn.marioquer.labpecker.View.TeacherMainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marioquer on 2017/7/3.
 */

public class TeacherMainPresenterImpl implements TeacherMainPresenter {

    private TeacherMainView teacherMainView = null;
    private TeacherService teacherService = null;

    public TeacherMainPresenterImpl(TeacherMainView teacherMainView) {
        this.teacherMainView = teacherMainView;
        teacherService = RetrofitUtil.getRetroService(TeacherService.class);
    }

    @Override
    public void getGroups() {
        Call<List<Group>> call = teacherService.getGroups();
        call.enqueue(new Callback<List<Group>>() {
            @Override
            public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                teacherMainView.initGroups(response.body());
            }

            @Override
            public void onFailure(Call<List<Group>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getCourses() {
        teacherMainView.initCourses();
    }
}
