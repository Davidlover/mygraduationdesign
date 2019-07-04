package com.example.lenovo.tourism.activity;

    import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.lenovo.tourism.FindWeb.WebfoundActivity;
import com.example.lenovo.tourism.R;
import com.example.lenovo.tourism.activity.City.StrategyContentActivity;
import com.example.lenovo.tourism.activity.Mycirle.LbsActivity;
import com.example.lenovo.tourism.activity.Mycirle.Travel_diary;
import com.example.lenovo.tourism.activity.News.NewsContentActivity;
import com.example.lenovo.tourism.activity.News.NewsContentFragment;
import com.example.lenovo.tourism.activity.newmodel.MomentActivity;
import com.example.lenovo.tourism.activity.newmodel.ScrollingActivity;
import com.example.lenovo.tourism.activity.yaweather.WeatherActivity;
import com.example.lenovo.tourism.yunanFragment;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

import Adapter.Beijing;
import Adapter.BeijingAdapter;
import Adapter.Me;
import Adapter.MeAdapter;
import Litepal.Login;
import Litepal.Register;
import view.GlideImageLoader;

import static com.example.lenovo.tourism.activity.Mycirle.Travel_diary.SELECT_PHOTO;

public class MainActivity extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener {
{
    private ImageView imageView;
    private TextView mTextMessage;

//   //定义beijing的泛型
    /**
     * 底部view
     */
    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView bottomNavigationView;
    private List<Me> meList = new ArrayList<>();
    private Button to_login=null;
private BaseFragment baseFragment = BaseFragment.newInstance(R.layout.home);
    //    private List<Beijing> beijingList=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fresco.initialize(MainActivity.this);

        //viewpager
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();





        NavigationView navigationView = findViewById(R.id.nav_view);

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_camera) {
                    drawer.closeDrawer(Gravity.START);
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    } else {
                        Intent intent = new Intent("android.intent.action.GET_CONTENT");
                        intent.setType("image/*");
                        startActivityForResult(intent, SELECT_PHOTO);
                    }
                }
                if (menuItem.getItemId() == R.id.nav_gallery) {
                    drawer.closeDrawer(Gravity.START);
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    } else {
                        Intent intent = new Intent("android.intent.action.GET_CONTENT");
                        intent.setType("image/*");
                        startActivityForResult(intent, SELECT_PHOTO);
                    }
                }

                if (menuItem.getItemId() == R.id.nav_slideshow) {
                    drawer.closeDrawer(Gravity.START);
                    Intent intent = new Intent(MainActivity.this, MomentActivity.class);
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.nav_share) {
                    drawer.closeDrawer(Gravity.START);
                    Intent intent = new Intent(MainActivity.this, WebfoundActivity.class);
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.nav_send) {
                    drawer.closeDrawer(Gravity.START);
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

                    Toast.makeText(MainActivity.this,"dsdaas=dd",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

/**
 * 新的bottomnavigation
 * */
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                main_pic();
                                viewPager.setCurrentItem(0);

                                break;
//                            case R.id.navigation_dashboard:
//                                viewPager.setCurrentItem(1);
////                                Intent intent = new Intent(MainActivity.this, MomentActivity.class);
//                                // Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
////                                FragmentManager fragmentManager = getSupportFragmentManager();
////                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////                                fragmentTransaction.add(R.id.playboy, b1).commit();
////                                startActivity(intent);
//
//                                break;
                            case R.id.navigation_notifications:
                                //   Toast.makeText(MainActivity.this, "ddd", Toast.LENGTH_SHORT).show();
                                viewPager.setCurrentItem(1);
                                TextView view = findViewById(R.id.username_me);
                                TextView view1 = findViewById(R.id.youji_num);
                                TextView view2 = findViewById(R.id.chang_num);
                                TextView view3 = findViewById(R.id.weather_num);
                                view1.setText(String.valueOf(yunanFragment.youjinum));
                                view2.setText(String.valueOf(yunanFragment.changenum));
                                view3.setText(String.valueOf(yunanFragment.tianqinum));
                                List<Register> registers = LitePal.findAll(Register.class);
                                Register register = null;
                                for (Register r : registers) {
                                    if (getIntent().getStringExtra("username").equals(r.getUsername())) {
                                        register = r;
                                        break;
                                    }
                                }
                                if (register != null) {
                                    view.setText(register.getUsername());
                                }

                                break;

                        }
                        return false;
                    }
                });
//        View view1 = LayoutInflater.from().inflate(R.layout.home, null, false);
//        ImageView ImageView = view1.findViewById(R.id.home_1);
//        ImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Travel_diary.class);
//                startActivity(intent);
//            }
//        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //禁止ViewPager滑动
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

        setupViewPager(viewPager);
    }

    /*
     * 初始化me_item
     * */
    public void initme() {
        Me me1 = new Me(R.drawable.qunaer, "item1");
        meList.add(me1);
        Me me2 = new Me(R.drawable.qunaer, "item2");
        meList.add(me2);
        Me me3 = new Me(R.drawable.qunaer, "item3");
        meList.add(me3);
        Me me4 = new Me(R.drawable.qunaer, "item4");
        meList.add(me4);
    }

    public void to_login() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        BaseFragment.newInstance(R.layout.activity_banner_gallery_yunnan)
        //   adapter.addFragment(BaseFragment.newInstance(R.layout.home));
        adapter.addFragment(yunanFragment.newInstance());
//        adapter.addFragment(baseFragment);
        adapter.addFragment(BaseFragment.newInstance(R.layout.about_me));
//        initme();
//        RecyclerView recyclerView = baseFragment.getView().findViewById(R.id.listview);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(new MeAdapter(meList));
//        adapter.addFragment(baseFragment);


        // adapter.addFragment(BaseFragment.newInstance(R.layout.activity_banner_gallery_hainan));
        viewPager.setAdapter(adapter);
    }

    public void OnBannerClick(int position) {
        Toast.makeText(this, "你点了第" + (position + 1) + "张轮播图", Toast.LENGTH_SHORT).show();

    }

    public void main_pic() {

        Banner banner = (Banner) findViewById(R.id.main_banner);
        Integer[] images = {R.mipmap.beijing1, R.mipmap.sanya1, R.mipmap.yunnan4};
        banner.setImages(Arrays.asList(images)).setImageLoader(new GlideImageLoader()).start();
        banner.setOnBannerListener(new OnBannerListener() {

            @Override
            public void OnBannerClick(int position) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, BannerGallery.class);
                        startActivity(intent);

                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this, BannerGallery_hainan.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, BannerGallery_yunnan.class);
                        startActivity(intent2);
                        break;
                }
            }

            public boolean OnBannerClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.mipmap.beijing1:
                        main_pic();


                        break;
                    case R.mipmap.sanya1:
                        main_pic();
                        break;
                    case R.mipmap.yunnan4:
                        main_pic();
                        break;

                }
                return false;

            }
        });
    }

    private void setOnBannerClickListener() {
        Intent intent = new Intent(this, BannerGallery.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//        Log.e("赛马", "onNavigationItemSelected: "+id );
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//            Toast.makeText(this,"密码不一致",Toast.LENGTH_SHORT).show();
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }


    @Override
    protected void onResume() {
        /*
//         * 退出
//         * */


        super.onResume();
    }
}
