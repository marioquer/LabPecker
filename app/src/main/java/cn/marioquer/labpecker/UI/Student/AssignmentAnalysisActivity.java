package cn.marioquer.labpecker.UI.Student;

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

import cn.marioquer.labpecker.Bean.Assignment.Student.Analysis;
import cn.marioquer.labpecker.Bean.Assignment.Student.QuestionResult;
import cn.marioquer.labpecker.Presenter.AssignmentAnalysisPresenter;
import cn.marioquer.labpecker.Presenter.Impl.AssignmentAnalysisPresenterImpl;
import cn.marioquer.labpecker.R;
import cn.marioquer.labpecker.View.AssignmentAnalysisView;

public class AssignmentAnalysisActivity extends AppCompatActivity implements AssignmentAnalysisView {
    int studentId, assignmentId;
    ArrayList<QuestionResult> questionResultList;
    AssignmentAnalysisPresenter assignmentAnalysisPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_analysis);
        studentId = getIntent().getIntExtra("studentId", 227);
        assignmentId = Integer.parseInt(getIntent().getStringExtra("assignmentId").toString());
        assignmentAnalysisPresenter = new AssignmentAnalysisPresenterImpl(this);
        assignmentAnalysisPresenter.getAssignmentAnalysis(studentId, assignmentId);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("问题列表");
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);

    }

    @Override
    public void initAnalyses(Analysis analysis) {
        questionResultList = (ArrayList<QuestionResult>) analysis.getQuestionResults();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (int i = 0; i < questionResultList.size(); i++) {
            map = new HashMap<String, Object>();
            map.put("title", questionResultList.get(i).getQuestionTitle());
            map.put("index", i);
            map.put("id", questionResultList.get(i).getQuestionId());
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_question_result,
                new String[]{"title", "index", "id"},
                new int[]{R.id.info_text, R.id.item_index, R.id.item_id});
        ListView listView = (ListView) findViewById(R.id.question_result_container);
        listView.setAdapter(adapter);
    }

    @Override
    public void jumpToQuestionResult(View view) {
        TextView indexTextView = (TextView) view.findViewById(R.id.item_index);
        TextView idTextView = (TextView) view.findViewById(R.id.item_id);
        Intent intent = new Intent(this, QuestionResultActivity.class);
        intent.putExtra("questionResult", questionResultList.get(Integer.parseInt(indexTextView.getText().toString())));
        intent.putExtra("studentId", studentId);
        intent.putExtra("assignmentId", assignmentId);
        intent.putExtra("questionId", Integer.parseInt(idTextView.getText().toString()));
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
