package com.example.lenovo.tourism.activity.yaweather;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;


public class BDLocationUtils extends AppCompatActivity {
    public Context context;
    public static String City= "";
    public LocationClient mLocationClient = null;    //LocationClient类是定位SDK的核心类
    public BDLocationListener myListener = new MyLocationListener();
    public BDLocationUtils(Context context){
        this.context = context;
    }

    public void doLocation(){
        //声明LocationClient类
        mLocationClient = new LocationClient(context.getApplicationContext());
        //注册监听函数
        mLocationClient.registerLocationListener( myListener );
        //初始化定位
        initLocation(); //调用initLocation方法
    }

    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps
        mLocationClient.setLocOption(option);
    }

    private class MyLocationListener implements BDLocationListener {
            @Override
            public void onReceiveLocation(BDLocation location) {
                //获取定位结果
                StringBuffer sb = new StringBuffer(256);
                sb.append(location.getCity()); //获取城市
                sb.append(location.getStreet());
                City = location.getCity()+location.getStreet();//getCity().replace("市","");//replace 切割字符 去掉“市”
            }
        }
    }
