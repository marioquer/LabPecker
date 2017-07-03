package cn.marioquer.labpecker.Presenter.Impl;

import java.util.List;

import cn.marioquer.labpecker.Bean.Student;
import cn.marioquer.labpecker.HttpService.TeacherService;
import cn.marioquer.labpecker.Presenter.GroupPresenter;
import cn.marioquer.labpecker.Util.RetrofitUtil;
import cn.marioquer.labpecker.View.GroupView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marioquer on 2017/7/3.
 */

public class GroupPresenterImpl implements GroupPresenter {

    GroupView groupView;
    TeacherService teacherService;

    public GroupPresenterImpl(GroupView groupView) {
        this.groupView = groupView;
        teacherService = RetrofitUtil.getRetroService(TeacherService.class);
    }

    @Override
    public void getStudents(int id) {
        Call<List<Student>> call = teacherService.getStudents(id);
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                groupView.initStudents(response.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

            }
        });
    }
}
