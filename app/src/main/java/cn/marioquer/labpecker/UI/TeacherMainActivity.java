package cn.marioquer.labpecker.UI;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import cn.marioquer.labpecker.R;

public class TeacherMainActivity extends AppCompatActivity {

    Context context = TeacherMainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("one").setIndicator("班级").setContent(R.id.group));
        tabHost.addTab(tabHost.newTabSpec("two").setIndicator("作业").setContent(R.id.homework));
        tabHost.addTab(tabHost.newTabSpec("three").setIndicator("考试").setContent(R.id.exam));
        tabHost.addTab(tabHost.newTabSpec("four").setIndicator("练习").setContent(R.id.practice));
    }

    //button的onclick方法
    public void jumpTo(View view) {
//        Intent intent = new Intent(this,LoginActivity.class);
//        intent.putExtra("message","wow!");
//        startActivity(intent);
        //give a toast
        Toast.makeText(context, "天气真好", Toast.LENGTH_LONG).show();
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
}
