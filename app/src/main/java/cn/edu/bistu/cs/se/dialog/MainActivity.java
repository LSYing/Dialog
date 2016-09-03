

package cn.edu.bistu.cs.se.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //提示对话框
        Button alertButton = (Button) this.findViewById(R.id.AlertButton);
        alertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("你点击了提示对话框")//显示的消息内容
                        .setTitle("提示对话框");//对话框标题

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你按下了确认按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你按下了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你按下了忽略按钮", Toast.LENGTH_LONG).show();

                    }

                });
                builder.show();
            }
        });


        //登录对话框
        Button loginDialog = (Button) findViewById(R.id.LoginDialog);
        loginDialog.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                //创建自定义对话框
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                //得到自定义对话框
                final View DialogView = inflater.inflate(R.layout.login_dialog,null);

                builder.setView(inflater.inflate(R.layout.login_dialog, null))
                        .setTitle("登录对话框")
                        .setView(DialogView)
                        // Add action buttons
                        .setPositiveButton("登录", new DialogInterface.OnClickListener() {


                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText edtUserName = (EditText)DialogView.findViewById(R.id.editTextUserId);
                                String strUserName = edtUserName.getText().toString();

                                EditText edtPassward = (EditText)DialogView.findViewById(R.id.editTextPwd);
                                String strPassward = edtPassward.getText().toString();

                                //Log.d("dialog",strPassward);

                                if(strUserName.equals("abc")&&strPassward.equals("123")){
                                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_LONG).show();


                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "你已取消登录", Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
