package cn.marioquer.labpecker.UI.Teacher;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.marioquer.labpecker.Bean.Assignment.Teacher.Question;
import cn.marioquer.labpecker.Presenter.AssignmentPresenter;
import cn.marioquer.labpecker.Presenter.Impl.AssignmentPresenterImpl;
import cn.marioquer.labpecker.R;
import cn.marioquer.labpecker.View.AssignmentView;

public class AssignmentActivity extends AppCompatActivity implements AssignmentView {
    int assignmentId;
    AssignmentPresenter assignmentPresenter;
    ArrayList<Question> questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("问题列表");
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);

        assignmentId = Integer.parseInt(getIntent().getStringExtra("assignmentId").toString());
        assignmentPresenter = new AssignmentPresenterImpl(this);
        assignmentPresenter.getAssignment(assignmentId);
    }

    @Override
    public void initQuestions(List<Question> questions) {
        this.questions = (ArrayList<Question>) questions;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (int i = 0; i < questions.size(); i++) {
            map = new HashMap<String, Object>();
            map.put("title", questions.get(i).getQuestionInfo().getTitle());
            map.put("index", i);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_question,
                new String[]{"title", "index"},
                new int[]{R.id.info_text, R.id.item_id});
        ListView listView = (ListView) findViewById(R.id.assignment_container);
        listView.setAdapter(adapter);
    }

    @Override
    public void jumpToQuestion(View view) {
        TextView textView = (TextView) view.findViewById(R.id.item_id);
        Intent intent = new Intent(this, AssignmentQuestionActivity.class);
        intent.putExtra("question", questions.get(Integer.parseInt(textView.getText().toString())));
        startActivity(intent);
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
