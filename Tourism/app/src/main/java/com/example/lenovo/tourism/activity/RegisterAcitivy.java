package com.example.lenovo.tourism.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
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
import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

import java.util.List;

import Litepal.Register;
import utils.UserUtils;
import view.InputView;

public class RegisterAcitivy extends BasicActivity {
    private InputView mInput_Phone_R, mInputPassword_R, mInputuername_R, mIPasswordcomfirm_R;
    private EditText edit_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acitivy);
        Button register_button = (Button) findViewById(R.id.register_button);
        LitePal.getDatabase();//加载数据库
/**
 * icon大小调整
 *
 * */
        EditText searchEdit = findViewById(R.id.edit);
        Drawable searchEditDraw = this.getResources().getDrawable(R.mipmap.icon_account);
        searchEditDraw.setBounds(0, 0, 72, 72);
        searchEdit.setCompoundDrawables(searchEditDraw, null, null, null);
/**
 * 设置bar控件的可见性
 * */
        initNavBar(true, "用户注册", false);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 实例化三个控件
                 * */


                edit_username = findViewById(R.id.edit);
//                mInputuername_R = (InputView) findViewById(R.id.username);
                mInput_Phone_R = (InputView) findViewById(R.id.input_phone);
                mInputPassword_R = (InputView) findViewById(R.id.input_password);
                mIPasswordcomfirm_R = (InputView) findViewById(R.id.input_password_confirm);
                onCommitClick(v);
            }


        });
    }

    public void onCommitClick(View view) {
        String phone = mInput_Phone_R.getInputStr();
        String password = mInputPassword_R.getInputStr();
        Editable username = edit_username.getText();
        String username1 = String.valueOf(username);
        String passwordcomfirm = mIPasswordcomfirm_R.getInputStr();

        /**
         * 输入数据
         * */
        LitePal.getDatabase();
//        Register register = new Register();
//        register.setUsername(username1);
//        register.setPuid(phone);
//        register.setManager(1);//1是普通用户
//        register.setUpassword(password);
//        register.save();

        /**
         * 判断手机号码是否被注册过
         * */
        List<Register> registers = LitePal.where("puid=?", phone).find(Register.class);//select("puid", "username", "upassword").find(Register.class);


        /**
         *清除数据
         */

 //       LitePal.deleteAll(Register.class);
//        List<Register> registers1 = LitePal.findAll(Register.class);
        for (Register register1 : registers) {

            Log.d("操蛋的信息", register1.getPuid() + register1.getUsername());
        }


        if (registers.size() == 0 || registers.isEmpty()) {


//验证输入合法性
            if (!UserUtils.validateLogin(this, phone, password)) {
                return;
            }

            Register register = new Register();
            register.setUsername(username1);
            register.setPuid(phone);


            //验证手机号合法性
            register.setManager(1);//1是普通用户
            register.setUpassword(password);
            if (password.equals(passwordcomfirm)) {
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                register.save();


            } else
                Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
            Log.d("WeatherActivity", "" + phone + password + passwordcomfirm + username);
        } else
            Toast.makeText(this, "该号码已经被注册过了", Toast.LENGTH_LONG).show();


    }


}
