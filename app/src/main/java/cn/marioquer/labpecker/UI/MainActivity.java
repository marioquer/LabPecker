package cn.marioquer.labpecker.UI;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import cn.marioquer.labpecker.Util.NetworkUtil;
import cn.marioquer.labpecker.R;

public class MainActivity extends AppCompatActivity {

    Context context = MainActivity.this;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.result_content);
        try {
            URL url = new URL("https://api.github.com/search/repositories?q=android&sort=stars");
            new getListTask().execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public class getListTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... params) {
            URL url = params[0];
            String st = null;
            try {
                st = NetworkUtil.getResponseFromHttpUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null && !s.equals("")) {
                textView.setText(s);
            }
        }


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
