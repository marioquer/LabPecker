package cn.marioquer.labpecker.UI.Teacher;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.marioquer.labpecker.Bean.Student;
import cn.marioquer.labpecker.Presenter.GroupPresenter;
import cn.marioquer.labpecker.Presenter.Impl.GroupPresenterImpl;
import cn.marioquer.labpecker.R;
import cn.marioquer.labpecker.View.GroupView;

public class GroupActivity extends AppCompatActivity implements GroupView {

    GroupPresenter groupPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        groupPresenter = new GroupPresenterImpl(this);
        int groupId = Integer.parseInt(getIntent().getStringExtra("groupId").toString());
        groupPresenter.getStudents(groupId);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("学生列表");
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
    }

    @Override
    public void initStudents(List<Student> students) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (Student i : students) {
            map = new HashMap<String, Object>();
            map.put("name", i.getName());
            map.put("number", i.getNumber());
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_student,
                new String[]{"name", "number"},
                new int[]{R.id.student_name, R.id.student_number});
        ListView listView = (ListView) findViewById(R.id.student_container);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:// 点击返回图标事件
                this.finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
