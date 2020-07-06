package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radio_usr;
    private RadioButton rbtn_new;
    private RadioButton rbtn_old;
    private Button btn;
    private EditText edtex_user_account;
    private EditText edtex_user_password;
    private Switch switch_showpassword;

    private String account = "Wogua";
    private String password = "1234567";
    private String usrtype = "新用户";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radio_usr = findViewById(R.id.L6_radioGroup2);
        final RadioButton rbtn_new = findViewById(R.id.L6_g2_radiobt1);
        RadioButton rbtn_old = findViewById(R.id.L6_g2_radiobt2);
        Button btn = findViewById(R.id.button1);
        EditText edtex_user_account = findViewById(R.id.edtex_user_account);
        EditText edtex_user_password = findViewById(R.id.edtex_user_password);
        Switch switch_showpassword = findViewById(R.id.switch_showpassword);

        rbtn_new.setChecked(true);


        class _RadioGroupListener implements RadioGroup.OnCheckedChangeListener{

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rbtn_new.isChecked()){
                    usrtype = "新用户";
                    Log.i("222222", "RadioGroup:New User");
                }
                else{
                    usrtype = "老用户";
                    Log.i("333333", "RadioGroup:Old User");
                }
            }
        }

        radio_usr.setOnCheckedChangeListener(new _RadioGroupListener());
        final String UsrAccount = edtex_user_account.getText().toString();


        final TextView tv = findViewById(R.id.tv_title);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tv.setText(UsrAccount+"登陆成功");
                tv.setText(UsrAccount);
                Log.i("111111", "Button Down");
            }

        });




    }
}
