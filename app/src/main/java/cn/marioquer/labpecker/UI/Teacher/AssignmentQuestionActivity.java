package cn.marioquer.labpecker.UI.Teacher;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.marioquer.labpecker.Bean.Assignment.Teacher.Question;
import cn.marioquer.labpecker.Bean.Assignment.Teacher.StudentScore;
import cn.marioquer.labpecker.R;
import cn.marioquer.labpecker.View.AssignmentQuestionView;

public class AssignmentQuestionActivity extends AppCompatActivity implements AssignmentQuestionView {

    Question question;
    ListView listView;
    TextView mTitle;
    TextView mDescription;
    TextView mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_question);

        question = (Question) getIntent().getSerializableExtra("question");
        mTitle = (TextView) findViewById(R.id.question_title);
        mDescription = (TextView) findViewById(R.id.question_description);
        mType = (TextView) findViewById(R.id.question_type);
        listView = (ListView) findViewById(R.id.student_container);

        mTitle.setText(question.getQuestionInfo().getTitle());
        mDescription.setText("介绍：" + question.getQuestionInfo().getDescription());
        mType.setText("问题类型：" + question.getQuestionInfo().getType());
        initQuestions();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("问题详情");
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
    }

    @Override
    public void initQuestions() {
        ArrayList<StudentScore> students = (ArrayList<StudentScore>) question.getStudents();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (int i = 0; i < students.size(); i++) {
            StudentScore studentScore = students.get(i);
            map = new HashMap<String, Object>();
            map.put("name", studentScore.getStudentName() + "  " + studentScore.getStudentNumber());
            map.put("result", (studentScore.isScored() ? "已评分" : "未评分") + "  " + "分数：" + studentScore.getScore());
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_student,
                new String[]{"name", "result"},
                new int[]{R.id.student_name, R.id.student_number});
        ListView listView = (ListView) findViewById(R.id.student_container);
        listView.setAdapter(adapter);


        //设置listview的layout
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
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
