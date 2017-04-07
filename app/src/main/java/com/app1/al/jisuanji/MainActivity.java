package com.app1.al.jisuanji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;


public class MainActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_LEFT_ICON);
        setContentView(R.layout.activity_main);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_about:
            {
                //Toast.makeText(MainActivity.this,"错误！",Toast.LENGTH_SHORT).show();;
                Intent i = new Intent(this,AboutActivity.class);
                startActivity(i);
            }
            break;
        }

        return true;
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_0:
            {
                Toast.makeText(MainActivity.this,"错误！",Toast.LENGTH_SHORT).show();;
                Intent i = new Intent(this,AboutActivity.class);
                startActivity(i);
            }
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_dian:
            case R.id.btn_divde:
            case R.id.btn_add:
            case R.id.btn_minus:
            case R.id.btn_time:
            {
                Button btn = (Button) view;
                String stradded = btn.getText().toString();
                TextView data = (TextView) findViewById(R.id.area_in);
                String strcontent = data.getText().toString();
                String strnew = strcontent+ stradded;
                data.setText(strnew);

            }
            break;
            case R.id.btn_del:
            {
                TextView data = (TextView) findViewById(R.id.area_in);
                String strcontent = data.getText().toString();
                if(strcontent.length() > 0)
                {
                    strcontent = strcontent.substring(0,strcontent.length() - 1);
                    data.setText(strcontent);
                }
            }
            break;
            case R.id.btn_equal:
            {
                TextView data = (TextView) findViewById(R.id.area_in);
                String strcontent = data.getText().toString();

                try{
                    Symbols s = new Symbols();
                    double res = s.eval(strcontent);

                    TextView result = (TextView) findViewById(R.id.area_result);
                    result.setText(String.valueOf(res));
                    data.setText("");

                }
                catch(SyntaxException e)
                {
                    Toast.makeText(MainActivity.this,"错误！",Toast.LENGTH_SHORT).show();;
                }

            }
            break;

        }
    }
}
