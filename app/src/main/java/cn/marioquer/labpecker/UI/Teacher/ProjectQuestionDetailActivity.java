package cn.marioquer.labpecker.UI.Teacher;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import cn.marioquer.labpecker.Bean.Course.Question;
import cn.marioquer.labpecker.R;

public class ProjectQuestionDetailActivity extends AppCompatActivity {

    Question question;
    TextView mTitle;
    TextView mDescription;
    TextView mDifficulty;
    TextView mGitUrl;
    TextView mType;
    TextView mCreator;
    TextView mDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_question_detail);
        question = (Question) getIntent().getSerializableExtra("question");

        mTitle = (TextView) findViewById(R.id.question_title);
        mDescription = (TextView) findViewById(R.id.question_description);
        mDifficulty = (TextView) findViewById(R.id.question_difficulty);
        mGitUrl = (TextView) findViewById(R.id.question_giturl);
        mType = (TextView) findViewById(R.id.question_type);
        mCreator = (TextView) findViewById(R.id.question_creator);
        mDuration = (TextView) findViewById(R.id.question_duration);

        mTitle.setText(question.getTitle());
        mDescription.setText("介绍: " + question.getDescription());
        mDifficulty.setText("难度: " + question.getDifficulty());
        mGitUrl.setText("项目Url: " + question.getGitUrl());
        mType.setText("问题类别: " + question.getType());
        mCreator.setText("创建人: " + question.getCreator().getName());
        mDuration.setText("持续时间: " + question.getDuration() + "h");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("问题详情");
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
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
