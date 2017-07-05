package cn.marioquer.labpecker.UI.Student;

import android.content.Intent;
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

import cn.marioquer.labpecker.Bean.Assignment.Student.QuestionResult;
import cn.marioquer.labpecker.Bean.Assignment.Student.Readme;
import cn.marioquer.labpecker.Bean.Assignment.Student.TestCase;
import cn.marioquer.labpecker.Presenter.Impl.QuestionResultPresenterImpl;
import cn.marioquer.labpecker.Presenter.QuestionResultPresenter;
import cn.marioquer.labpecker.R;
import cn.marioquer.labpecker.View.QuestionResultView;

public class QuestionResultActivity extends AppCompatActivity implements QuestionResultView {
    int questionId, assignmentId, studentId;
    QuestionResultPresenter questionResultPresenter = null;
    QuestionResult questionResult = null;

    TextView mReadme = null;
    TextView mTitle = null;
    TextView mGitUrl = null;
    TextView mScore = null;
    TextView mLineCount = null;
    TextView mCommentCount = null;
    TextView mFieldCount = null;
    TextView mMethodCount = null;
    TextView mMaxCoc = null;
    TextView mCompileResult = null;
    TextView mTested = null;
    ListView mTestCase = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_result);
        questionResultPresenter = new QuestionResultPresenterImpl(this);
        Intent intent = getIntent();
        questionId = intent.getIntExtra("questionId", 0);
        assignmentId = intent.getIntExtra("assignmentId", 0);
        studentId = intent.getIntExtra("studentId", 0);
        questionResultPresenter.getReadme(assignmentId, studentId, questionId);
        questionResult = (QuestionResult) intent.getSerializableExtra("questionResult");

        mReadme = (TextView) findViewById(R.id.question_readme);
        mTitle = (TextView) findViewById(R.id.question_title);
        mGitUrl = (TextView) findViewById(R.id.question_giturl);
        mScore = (TextView) findViewById(R.id.question_score);
        mLineCount = (TextView) findViewById(R.id.question_line_count);
        mCommentCount = (TextView) findViewById(R.id.question_comment_count);
        mFieldCount = (TextView) findViewById(R.id.question_field_count);
        mMethodCount = (TextView) findViewById(R.id.question_method_count);
        mMaxCoc = (TextView) findViewById(R.id.question_max_coc);
        mCompileResult = (TextView) findViewById(R.id.question_compile_result);
        mTested = (TextView) findViewById(R.id.question_tested);
        mTestCase = (ListView) findViewById(R.id.testcase_container);


        mTitle.setText(questionResult.getQuestionTitle());
        mGitUrl.setText("项目Url：" + questionResult.getScoreResult().getGit_url());
        mScore.setText("得分：" + questionResult.getScoreResult().getScore() + "");
        mLineCount.setText("代码总行数：" + questionResult.getMetricData().getTotal_line_count() + "");
        mCommentCount.setText("注释行数：" + questionResult.getMetricData().getComment_line_count() + "");
        mFieldCount.setText("FieldCount：" + questionResult.getMetricData().getField_count() + "");
        mMethodCount.setText("方法总数：" + questionResult.getMetricData().getMethod_count() + "");
        mMaxCoc.setText("最大COC：" + questionResult.getMetricData().getMax_coc() + "");
        mCompileResult.setText("编译结果：" + (questionResult.getTestResult().isCompile_succeeded() ? "true" : "false"));
        mTested.setText("是否已测试：" + (questionResult.getTestResult().isTested() ? "true" : "false"));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("结果统计");
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
    }


    @Override
    public void initQuestionResult(Readme readme) {
        mReadme.setText(readme.getContent());
        ArrayList<TestCase> testCases = (ArrayList<TestCase>) questionResult.getTestResult().getTestCases();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (int i = 0; i < testCases.size(); i++) {
            map = new HashMap<String, Object>();
            map.put("name", testCases.get(i).getName());
            map.put("result", testCases.get(i).isPassed() ? "true" : "false");
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_testcase,
                new String[]{"name", "result"},
                new int[]{R.id.testcase_name, R.id.testcase_result});
        ListView listView = (ListView) findViewById(R.id.testcase_container);
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
