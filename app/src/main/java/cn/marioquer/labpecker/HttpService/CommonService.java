package cn.marioquer.labpecker.HttpService;

import java.util.List;

import cn.marioquer.labpecker.Bean.Course.Project;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by marioquer on 2017/6/30.
 */

public interface CommonService {
    /**
     * 查看自己账户的考试列表
     * @param courseid
     * @return
     */
    @GET("course/{courseId}/exam")
    Call<List<Project>> getExams(@Path("courseId") int courseid);

    /**
     * 查看自己账户的作业列表
     * @param courseid
     * @return
     */
    @GET("course/{courseId}/homework")
    Call<List<Project>> getHomeworks(@Path("courseId") int courseid);

    /**
     * 查看自己账户的练习列表
     * @param courseid
     * @return
     */
    @GET("course/{courseId}/exercise")
    Call<List<Project>> getExercises(@Path("courseId") int courseid);
}
