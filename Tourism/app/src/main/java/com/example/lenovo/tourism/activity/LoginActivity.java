package com.example.lenovo.tourism.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.tourism.R;

import org.litepal.LitePal;

import java.util.List;

import Litepal.Book;
import Litepal.Login;
import Litepal.Register;
import utils.UserUtils;
import view.InputView;

public class LoginActivity extends BasicActivity {
    private InputView mInput_Phone, mInputPassword;
    public static String username_global,userphone_global;
    public EditText edit_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        Button button_login = (Button) findViewById(R.id.login_button);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 测试插入数据
                 * */
//                LitePal.getDatabase();
//                Book book=new Book();
//                book.setName("dads");
//                book.setAuthor("sda");
//                book.setPage(454);
//                book.setPrice(12);
//                book.setId(12);
//                book.save();
                onCommitClick(v);
//                List<Book> books = LitePal.findAll(Book.class);
//                for (Book booked : books) {
//                    Log.d("WeatherActivity", "" + booked.getName());
//                    Log.d("WeatherActivity", "" + booked.getAuthor());
//                    Log.d("WeatherActivity", "" + booked.getId());
//                    Log.d("WeatherActivity", "" + booked.getPage());
//                    Log.d("WeatherActivity", "" + booked.getPrice());
//                    Log.d("WeatherActivity", "" + booked.getPage());
//
//                }
            }
        });
/**
 * 立即注册点击事件
 * */
        TextView button_register = (TextView) findViewById(R.id.register_button_Login);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterAcitivy.class);
                startActivity(intent);

            }
        });
    }

    private void initView() {
        initNavBar(false, "登录", false);
        mInput_Phone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
    }

    public void onRegisterClick(View v) {

    }

    public void onCommitClick(View v) {
        String phone = mInput_Phone.getInputStr();
        String password = mInputPassword.getInputStr();



        //验证输入是否合法
        if (!UserUtils.validateLogin(this, phone, password)) {
            return;
        }
        /**
         * 扫描数据库字段
         *
         */
        mInput_Phone = (InputView) findViewById(R.id.input_phone);
        mInputPassword = (InputView) findViewById(R.id.input_password);
        LitePal.getDatabase();
        List<Register> registers = LitePal.where("puid=? and upassword=?", phone, password).find(Register.class);

        for (Register register1 : registers) {

            Log.d("操蛋的信息", register1.getPuid() + register1.getUsername());
        }
        if (!(registers.size() == 0 || registers.isEmpty()))

        {

            for (Register register1 : registers) {
                this.userphone_global=String.valueOf(register1.getPuid());
                this.username_global = String.valueOf(register1.getUsername());
                Log.d("操蛋的信息", register1.getPuid() + register1.getUsername());
            }




            //跳转到应用页面
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", this.username_global);
            //   Intent intent=new Intent(this,BannerGallery.class);
            Intent intent1 = new Intent(this, BannerGallery_hainan.class);
            Intent intent2 = new Intent(this, BannerGallery_yunnan.class);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(this,"请输入正确的账号密码",Toast.LENGTH_LONG).show();
    }
}
