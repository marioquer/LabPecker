package cn.marioquer.labpecker.HttpService;

import java.util.List;

import cn.marioquer.labpecker.Bean.Group;
import cn.marioquer.labpecker.Bean.Student;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by marioquer on 2017/6/29.
 */

public interface TeacherService {

    @GET("group")
    Call<List<Group>> getGroups();

    @GET("group/{groupId}/students")
    Call<List<Student>> getStudents(@Path("groupId") int groupId);
}
