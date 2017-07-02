package cn.marioquer.labpecker.HttpService;

import cn.marioquer.labpecker.Bean.Assignment.Student.Analysis;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by marioquer on 2017/6/29.
 */

public interface StudentService {
    /**
     * 查看某次作业、练习和考试学生考试分析
     * @param assignmentId
     * @param studentId
     * @return
     */
    @GET("assignment/{assignmentId}/student/{studentId}/analysis")
    Call<Analysis> getAnalysis(@Path("assignmentId") int assignmentId, @Path("studentId") int studentId);
}
