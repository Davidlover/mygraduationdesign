package com.example.lenovo.tourism.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.tourism.R;

import org.litepal.LitePal;

import java.util.List;

import Litepal.Register;
import view.InputView;

public class ChangeActivity extends BasicActivity {
    private InputView inputView_old, inputView_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        final String tag = LoginActivity.username_global;
        final String tag1 = LoginActivity.userphone_global;
        Button bn1 = findViewById(R.id.register_button);

        /*
         * inputview的绑定
         * */

        TextView textView = findViewById(R.id.username);
        textView.setText(tag);
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputView_new = (InputView) findViewById(R.id.input_phone);
                inputView_old = (InputView)findViewById(R.id.input_password);

                final String input_new = inputView_new.getInputStr();
                final String input_old = inputView_old.getInputStr();
                LitePal.getDatabase();
                Register register = new Register();
                if (input_new.equals(input_old)) {
                    register.setUpassword(input_new);

                    register.updateAll("puid=? and username=?", tag1, tag);

                    Toast.makeText(ChangeActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(ChangeActivity.this, "修改失败", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
