package cn.marioquer.labpecker.UI.Student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.marioquer.labpecker.Presenter.Impl.StudentMainPresenterImpl;
import cn.marioquer.labpecker.Presenter.StudentMainPresenter;
import cn.marioquer.labpecker.R;
import cn.marioquer.labpecker.UI.Common.CourseActivity;
import cn.marioquer.labpecker.View.StudentMainView;

public class StudentMainActivity extends AppCompatActivity implements StudentMainView {

    StudentMainPresenter studentMainPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);
        studentMainPresenter = new StudentMainPresenterImpl(this);
        studentMainPresenter.getCourses();
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("course").setIndicator("课程").setContent(R.id.course));
        tabHost.addTab(tabHost.newTabSpec("assignment").setIndicator("任务").setContent(R.id.assignment));
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (s.equals("assignment"))
                    studentMainPresenter.getAssignments();
            }
        });
    }

    @Override
    public void initAssignments() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "任务98");
        map.put("id", 98);
        list.add(map);
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_assignment_student,
                new String[]{"title", "id"},
                new int[]{R.id.info_text, R.id.item_id});
        ListView listView = (ListView) findViewById(R.id.assignment_container);
        listView.setAdapter(adapter);
    }

    @Override
    public void initCourses() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("course", "软工一");
        map.put("id", 1);
        list.add(map);
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_course,
                new String[]{"course", "id"},
                new int[]{R.id.info_text, R.id.item_id});
        ListView listView = (ListView) findViewById(R.id.course_container);
        listView.setAdapter(adapter);
    }

    @Override
    public void jumpToCourse(View view) {
        TextView textView = (TextView) view.findViewById(R.id.item_id);
        Intent intent = new Intent(this, CourseActivity.class);
        intent.putExtra("courseId", textView.getText());
        startActivity(intent);
    }

    @Override
    public void jumpToAssignment(View view) {
        TextView textView = (TextView) view.findViewById(R.id.item_id);
        Intent intent = new Intent(this, AssignmentAnalysisActivity.class);
        intent.putExtra("assignmentId", textView.getText());
        intent.putExtra("studentId", 227);
        startActivity(intent);
    }

    //用于双击返回退出
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
                return true;
            } else {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                System.exit(0);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
