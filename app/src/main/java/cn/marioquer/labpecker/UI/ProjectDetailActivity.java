package cn.marioquer.labpecker.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.marioquer.labpecker.Bean.Course.Project;
import cn.marioquer.labpecker.Bean.Course.Question;
import cn.marioquer.labpecker.R;
import cn.marioquer.labpecker.View.ProjectDetailView;

public class ProjectDetailActivity extends AppCompatActivity implements ProjectDetailView {

    TextView mTitle;
    TextView mDescription;
    TextView mStartAt;
    TextView mEndAt;
    TextView mStatus;
    Project project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        mTitle = (TextView) findViewById(R.id.project_title);
        mDescription = (TextView) findViewById(R.id.project_description);
        mStartAt = (TextView) findViewById(R.id.project_startAt);
        mEndAt = (TextView) findViewById(R.id.project_endAt);
        mStatus = (TextView) findViewById(R.id.project_status);

        Intent intent = getIntent();
        project = (Project) intent.getSerializableExtra("detail");
        mTitle.setText(project.getTitle());
        mDescription.setText(project.getDescription());
        mStartAt.setText("开始时间: " + project.getStartAt());
        mEndAt.setText("结束时间: " + project.getEndAt());
        switch (project.getStatus()) {
            case "newly":
                mStatus.setText("刚刚新建");
                break;
            case "initing":
                mStatus.setText("正在初始化");
                break;
            case "initFail":
                mStatus.setText("初始化失败");
                break;
            case "initSuccess":
                mStatus.setText("初始化成功");
                break;
            case "ongoing":
                mStatus.setText("正在进行");
                break;
            case "timeup":
                mStatus.setText("时间到");
                break;
            case "analyzing":
                mStatus.setText("正在分析结果");
                break;
            case "analyzingFinish":
                mStatus.setText("结果分析完毕");
                break;
        }
        initQuestions();
    }

    @Override
    public void initQuestions() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        Toast.makeText(getApplicationContext(), project.getQuestions().size() + "", Toast.LENGTH_SHORT);
        for (int i = 0; i < project.getQuestions().size(); i++) {
            map = new HashMap<String, Object>();
            map.put("title", project.getQuestions().get(i).getTitle());
            map.put("index", i);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.listitem_question,
                new String[]{"title", "index"},
                new int[]{R.id.info_text, R.id.item_id});
        ListView listView = (ListView) findViewById(R.id.project_question_container);
        listView.setAdapter(adapter);
    }

    @Override
    public void jumpToQuestion(View view) {
        TextView textView = (TextView) view.findViewById(R.id.item_id);
        Intent intent = new Intent(this, ProjectQuestionDetailActivity.class);
        intent.putExtra("question", project.getQuestions().get(Integer.parseInt(textView.getText().toString())));
        startActivity(intent);
    }
}
