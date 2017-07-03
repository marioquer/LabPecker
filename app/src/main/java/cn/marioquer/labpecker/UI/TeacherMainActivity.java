package cn.marioquer.labpecker.UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
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

import cn.marioquer.labpecker.Bean.Group;
import cn.marioquer.labpecker.Presenter.Impl.TeacherMainPresenterImpl;
import cn.marioquer.labpecker.Presenter.TeacherMainPresenter;
import cn.marioquer.labpecker.R;
import cn.marioquer.labpecker.View.TeacherMainView;

public class TeacherMainActivity extends AppCompatActivity implements TeacherMainView {

    Context context = TeacherMainActivity.this;
    TeacherMainPresenter teacherMainPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("group").setIndicator("班级").setContent(R.id.group));
        tabHost.addTab(tabHost.newTabSpec("course").setIndicator("课程").setContent(R.id.course));
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (s == "course")
                    teacherMainPresenter.getCourses();
            }
        });
        teacherMainPresenter = new TeacherMainPresenterImpl(this);
        teacherMainPresenter.getGroups();
    }

    //进入课程页面
    @Override
    public void jumpToCourse(View view) {
        TextView textView = (TextView) view.findViewById(R.id.item_id);
        Intent intent = new Intent(this, CourseActivity.class);
        intent.putExtra("courseId", textView.getText());
        startActivity(intent);
    }

    //使用自定义的menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            Toast.makeText(context, "你想搜东西！", Toast.LENGTH_LONG).show();
        }
        return true;
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


    @Override
    public void initGroups(List<Group> groups) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (Group i : groups) {
            map = new HashMap<String, Object>();
            map.put("group", i.getName());
            map.put("id", i.getId());
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_group,
                new String[]{"group", "id"},
                new int[]{R.id.info_text, R.id.item_id});
        ListView listView = (ListView) findViewById(R.id.group_container);
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
}
