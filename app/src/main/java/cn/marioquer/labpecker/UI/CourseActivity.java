package cn.marioquer.labpecker.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.marioquer.labpecker.Bean.Course.Project;
import cn.marioquer.labpecker.Presenter.CoursePresenter;
import cn.marioquer.labpecker.Presenter.Impl.CoursePresenterImpl;
import cn.marioquer.labpecker.Presenter.Impl.TeacherMainPresenterImpl;
import cn.marioquer.labpecker.R;
import cn.marioquer.labpecker.View.CourseView;

public class CourseActivity extends AppCompatActivity implements CourseView {

    CoursePresenter coursePresenter;
    List<Project> exams;
    List<Project> homeworks;
    List<Project> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        coursePresenter = new CoursePresenterImpl(this);
        final Intent intent = getIntent();
        final int courseId = Integer.parseInt(intent.getStringExtra("courseId"));
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("exam").setIndicator("考试").setContent(R.id.exam));
        tabHost.addTab(tabHost.newTabSpec("homework").setIndicator("作业").setContent(R.id.homework));
        tabHost.addTab(tabHost.newTabSpec("exercise").setIndicator("练习").setContent(R.id.exercise));
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                switch (s) {
                    case "homework":
                        coursePresenter.getHomeworks(courseId);
                        break;
                    case "exercise":
                        coursePresenter.getExercises(courseId);
                        break;
                }
            }
        });
        coursePresenter.getExams(courseId);
    }


    @Override
    public void initExams(List<Project> exams) {
        this.exams = exams;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (Project i : exams) {
            map = new HashMap<String, Object>();
            map.put("title", i.getTitle());
            map.put("id", i.getId());
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_exam,
                new String[]{"title", "id"},
                new int[]{R.id.info_text, R.id.item_id});
        ListView listView = (ListView) findViewById(R.id.exam_container);
        listView.setAdapter(adapter);

    }

    @Override
    public void initHomeworks(List<Project> homeworks) {
        this.homeworks = homeworks;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (Project i : homeworks) {
            map = new HashMap<String, Object>();
            map.put("title", i.getTitle());
            map.put("id", i.getId());
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_homework,
                new String[]{"title", "id"},
                new int[]{R.id.info_text, R.id.item_id});
        ListView listView = (ListView) findViewById(R.id.homework_container);
        listView.setAdapter(adapter);
    }

    @Override
    public void initExercises(List<Project> exercises) {
        this.exercises = exercises;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (Project i : exercises) {
            map = new HashMap<String, Object>();
            map.put("title", i.getTitle());
            map.put("id", i.getId());
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_exercise,
                new String[]{"title", "id"},
                new int[]{R.id.info_text, R.id.item_id});
        ListView listView = (ListView) findViewById(R.id.exercise_container);
        listView.setAdapter(adapter);
    }

    @Override
    public void jumpToExam(View view) {
        TextView textView = (TextView) view.findViewById(R.id.item_id);
        Intent intent = new Intent(this, ProjectDetailActivity.class);

        for (Project p : exams) {
            if (textView.getText().toString().equals(p.getId() + "")) {
                intent.putExtra("detail", p);
            }
        }
        startActivity(intent);
    }

    @Override
    public void jumpToHomework(View view) {
        TextView textView = (TextView) view.findViewById(R.id.item_id);
        Intent intent = new Intent(this, ProjectDetailActivity.class);

        for (Project p : homeworks) {
            if (textView.getText().toString().equals(p.getId() + "")) {
                intent.putExtra("detail", p);
            }
        }
        startActivity(intent);
    }

    @Override
    public void jumpToExercise(View view) {
        TextView textView = (TextView) view.findViewById(R.id.item_id);
        Intent intent = new Intent(this, ProjectDetailActivity.class);

        for (Project p : exercises) {
            if (textView.getText().toString().equals(p.getId() + "")) {
                intent.putExtra("detail", p);
            }
        }
        startActivity(intent);
    }
}
