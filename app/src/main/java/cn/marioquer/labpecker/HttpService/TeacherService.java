package cn.marioquer.labpecker.HttpService;

import java.util.List;

import cn.marioquer.labpecker.Bean.Assignment.Teacher.AssignmentDetail;
import cn.marioquer.labpecker.Bean.Group;
import cn.marioquer.labpecker.Bean.Student;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by marioquer on 2017/6/29.
 */

public interface TeacherService {
    /**
     * 获取所有班级
     * @return
     */
    @GET("group")
    Call<List<Group>> getGroups();

    /**
     * 获取一个班级的学生列表
     * @param groupId
     * @return
     */
    @GET("group/{groupId}/students")
    Call<List<Student>> getStudents(@Path("groupId") int groupId);

    /**
     * 获取所有学生某次作业的分数
     * @param assignmentId
     * @return
     */
    @GET("assignment/{assignmentId}/score")
    Call<AssignmentDetail> getAssignmentDetail(@Path("assignmentId") int assignmentId);
}
