package cn.marioquer.labpecker.HttpService;

import java.util.List;

import cn.marioquer.labpecker.Bean.Project;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by marioquer on 2017/6/30.
 */

public interface CommonService {
    @GET("course/{courseId}/exam")
    Call<List<Project>> getExam(@Path("courseId") int courseid);

    @GET("course/{courseId}/homework")
    Call<List<Project>> getHomework(@Path("courseId") int courseid);

    @GET("course/{courseId}/exercise")
    Call<List<Project>> getExercise(@Path("courseId") int courseid);
}
