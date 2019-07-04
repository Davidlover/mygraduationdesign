package com.example.lenovo.tourism.activity.newmodel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.tourism.R;
import com.example.lenovo.tourism.activity.LoginActivity;
import com.example.lenovo.tourism.activity.Mycirle.Travel_diary;
import com.example.lenovo.tourism.activity.RegisterAcitivy;

import org.litepal.LitePal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;

import Litepal.Mycircle;
import Litepal.Register;
import utils.BitMap;

import static com.facebook.common.internal.ByteStreams.copy;


public class MomentActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private int flag;//记录日记的数目
private Bitmap b;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moment);
        /*
         * 熊圈用户名
         * */


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        /*
         * 定义需要填充的数据，作为数据层填充到View 层
         * 数据来源于 recycler view
         * 分别为：name, avatar, content, time, pic
         *
         * */
        TextView view = findViewById(R.id.username_me);
        List<Register> registers = LitePal.findAll(Register.class);
        List<Mycircle> mycircles = LitePal.where("usename=?", LoginActivity.username_global).find(Mycircle.class);


//        Register register = null;
//        for (Register r : registers) {
//            if (getIntent().getStringExtra("username").equals(r.getUsername())) {
//                register = r;
//                break;
//            }
//        }
//
//        if (register != null) {
//            view.setText(register.getUsername());
//        }
        //关于时间的转换
        SimpleDateFormat sd = new SimpleDateFormat("m");


        //    LitePal.deleteAll(Mycircle.class);
        //传递用户名过来
        String usrname = LoginActivity.username_global;
        int max = 0;
        for (Mycircle m : mycircles) {
            max=max+1;
            String form = sd.format(System.currentTimeMillis() - m.getTime());
            Log.d("number", Travel_diary.number_of_diary + "    " + m.getPhotonum() + "    " + m.getContent() + "    " + getIntent().getStringExtra("max_num") + form);
        }
        int num = 2;
      //  Toast.makeText(this, String.valueOf(max) + "个", Toast.LENGTH_SHORT).show();
        ItemData itemsData[] = new ItemData[max];
        max = max - 1;
//        itemsData[0] = new ItemData("bigsame", R.drawable.pony, "今天很开心！", "1分钟前", R.drawable.pic);
//        itemsData[1] = new ItemData("马化腾", R.drawable.pony, "Ladies and 乡亲们，今年打算给腾讯全体员工涨薪！哈哈哈哈哈哈哈哈哈哈哈哈哈哈", "1分钟前", null);
//        itemsData[2] = new ItemData("马化腾", R.drawable.pony, "Ladies and 乡亲们，今年打算给腾讯全体员工涨薪！哈哈哈哈哈哈哈哈哈哈哈哈哈哈", "1分钟前", R.drawable.pic);
        for (Mycircle mycircle : mycircles) {
            if (mycircles.size() == 0 || mycircles.isEmpty()) {
                // itemsData[num - 1] = new ItemData("马化腾", R.drawable.pony, "Ladies and 乡亲们，今年打算给腾讯全体员工涨薪！哈哈哈哈哈哈哈哈哈哈哈哈哈哈", "1分钟前", R.drawable.pic);
                Toast.makeText(this, "尚无内容", Toast.LENGTH_LONG).show();
            } else {
                String form = sd.format(System.currentTimeMillis() - mycircle.getTime());
                Toast.makeText(MomentActivity.this,"非空",Toast.LENGTH_SHORT).show();
                if (form.equals("0"))
                    form = "1";

                //图片路径转换bitmap
//                FileInputStream fis = null;
//                try {
//                    fis = new FileInputStream(mycircle.getPhotonum());
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
                //   Bitmap bitmap  = BitmapFactory.decodeStream(fis);

//GetLocalOrNetBitmap(mycircle.getPhotonum())
                b = BitMap.GetLocalOrNetBitmap(this,mycircle.getPhotonum());
                itemsData[max] = new ItemData(usrname, R.drawable.bear, mycircle.getContent(), form + "分钟前", b);
                Log.d("bitmapsss", mycircle.getPhotonum());

            }
            max = max - 1;
            if (max < 0)
                break;

        }

//        ItemData itemsData[] = {
//                new ItemData("马化腾", R.drawable.pony, "Ladies and 乡亲们，今年打算给腾讯全体员工涨薪！哈哈哈哈哈哈哈哈哈哈哈哈哈哈", "1分钟前", R.drawable.pic),
//                new ItemData("雷军", R.drawable.a2, "Ladies and 乡亲们，今年打算给小米全体员工涨薪！", "3分钟前", R.drawable.pic),
//                new ItemData("李开复", R.drawable.a4, "Ladies and 乡亲们，今年打算给创新工场全体员工涨薪！", "1小时前", R.drawable.pic),
//                new ItemData("罗永浩", R.drawable.a3, "Ladies and 乡亲们，今年打算给锤子全体员工涨薪！", "10分钟前", R.drawable.pic2),
//                new ItemData("周鸿祎", R.drawable.a5, "Ladies and 乡亲们，今年打算给360 全体员工涨薪！", "2小时前", R.drawable.pic),
//
//                new ItemData("张朝阳", R.drawable.a6, "Ladies and 乡亲们，今年打算给搜狐全体员工涨薪！", "1天前", R.drawable.pic),
//                new ItemData("张朝阳", R.drawable.a6, "Ladies and 乡亲们，今年打算给搜狐全体员工涨薪！", "1天前", R.drawable.pic),
//                new ItemData("张朝阳", R.drawable.a6, "Ladies and 乡亲们，今年打算给搜狐全体员工涨薪！", "1天前", R.drawable.pic),
//                new ItemData("张朝阳", R.drawable.a6, "Ladies and 乡亲们，今年打算给搜狐全体员工涨薪！", "1天前", R.drawable.pic),
//                new ItemData("张朝阳", R.drawable.a6, "Ladies and 乡亲们，今年打算给搜狐全体员工涨薪！", "1天前", R.drawable.pic),
//
//                new ItemData("比尔盖茨BillGates", R.drawable.a8, "Ladies and 乡亲们，今年打算盖茨基金会再裸捐50% 身家！", "2天前", R.drawable.pic3),
//                new ItemData("黄章", R.drawable.a7, "Ladies and 乡亲们，今年打算给魅族全体员工涨薪！", "2天前", R.drawable.pic),
//                new ItemData("谢盖尔 布林", R.drawable.a9, "Ladies and 乡亲们，今年打算给谷歌全体员工涨薪！", "2天前", R.drawable.pic)
//        };

        // 设置 layoutManger
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 创建一个 adapter
        mMyAdapter = new MyAdapter(itemsData,this);

        // 设置 adapter
        mRecyclerView.setAdapter(mMyAdapter);

        // 设置item 的动画（默认）
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //为RecyclerView添加HeaderView和FooterView
        setHeaderView(mRecyclerView);

    }

    // 增加 setHeaderView 方法
    private void setHeaderView(RecyclerView view) {
        View header = LayoutInflater.from(this).inflate(R.layout.header_view, view, false);
        mMyAdapter.setHeaderView(header);
    }

    // 增加 setFooterView 方法
    private void setFooterView(RecyclerView view) {
        View footer = LayoutInflater.from(this).inflate(R.layout.footer, view, false);
        mMyAdapter.setFooterView(footer);
    }


//    public Bitmap GetLocalOrNetBitmap(String url) {
//        InputStream in;
//        BufferedOutputStream out = null;
//        try {
//            in = getContentResolver().openInputStream(Uri.parse(url));
//
//            return BitmapFactory.decodeStream(in);
////            final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
////            out = new BufferedOutputStream(dataStream, 300 * 300);
////            copy(in, out);
////            out.flush();
////            byte[] data = dataStream.toByteArray();
////            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
////            data = null;
////            return bitmap;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


    public Bitmap getB() {
        return b;
    }
}
