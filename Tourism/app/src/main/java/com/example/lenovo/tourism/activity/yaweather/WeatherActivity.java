package com.example.lenovo.tourism.activity.yaweather;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
/**
 *  implementation 'com.android.volley:volley:1.1.1'
 * */
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.tourism.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class WeatherActivity extends AppCompatActivity {

    private static final int BAIDU_READ_PHONE_STATE = 100;
    private BDLocationUtils bdLocationUtils;
    private TextView textView;
    private EditText editText;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);

        bdLocationUtils = new BDLocationUtils(WeatherActivity.this);
        textView = (TextView) findViewById(R.id.location_view);
        Button btn_start_location = (Button) findViewById(R.id.start_location);
        Button btn_start_weather = (Button) findViewById(R.id.start_weather);
        editText = (EditText) findViewById(R.id.et1);
        textView1 = (TextView) findViewById(R.id.weather_view);
        textView2 = (TextView) findViewById(R.id.weather1_view);
        textView3 = (TextView) findViewById(R.id.weather2_view);

        imageView1 = (ImageView) findViewById(R.id.iv1);
        imageView2 = (ImageView) findViewById(R.id.iv2);
        imageView3 = (ImageView) findViewById(R.id.iv3);

        btn_start_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED ||
                            checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                            checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义）
                        requestPermissions(new String[]{
                                Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,}, BAIDU_READ_PHONE_STATE);
                    }
                    bdLocationUtils.doLocation();//开启定位
                    bdLocationUtils.mLocationClient.start();//开始定位
                    textView.setText("当前位置:" + BDLocationUtils.City);
                    initView();

                } else {

                    Log.e("Permissions", "已经有权限了");
                }
            }
        });

        btn_start_weather.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //textView.setText("当前位置:"+BDLocationUtils.City);
                getView();
            }
        });
    }

    private void initView() {

        mRequestQueue = Volley.newRequestQueue(this);
        final String city = BDLocationUtils.City;
        String city_encode = null;
        try {
            city_encode = URLEncoder.encode(city, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(
                "http://wthrcdn.etouch.cn/weather_mini?city=" + city_encode,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject data = new JSONObject(response.getString("data"));
                            JSONArray forecast = data.getJSONArray("forecast");
                            JSONObject todayWeather = forecast.getJSONObject(0);


                            String wendu = data.getString("wendu") + "\n";
                            //String ganmao = data.getString("ganmao") + "\n";
                            String high = todayWeather.getString("high") + "\n";
                            String low = todayWeather.getString("low") + "~";
                            String date = todayWeather.getString("date") + "";
                            String type = todayWeather.getString("type") + "\n";
                            String city = data.getString("city") + "\n";
                            textView1.setText(city + date + type + "实时温度:" + wendu + low + high);

                            if (todayWeather.getString("type").toString().contains("多云")) {
                                imageView1.setImageResource(R.drawable.duoyun1);
                            } else if (todayWeather.getString("type").toString().contains("晴")) {
                                imageView1.setImageResource(R.drawable.qingtian);
                            } else if (todayWeather.getString("type").toString().contains("阴")) {
                                imageView1.setImageResource(R.drawable.yintian);
                            } else if (todayWeather.getString("type").toString().contains("阵雨")) {
                                imageView1.setImageResource(R.drawable.zhenyu);
                            } else if (todayWeather.getString("type").toString().contains("雷阵雨")) {
                                imageView1.setImageResource(R.drawable.leizhenyu2);
                            } else if (todayWeather.getString("type").toString().contains("小雨")) {
                                imageView1.setImageResource(R.drawable.xiaoyu);
                            } else if (todayWeather.getString("type").toString().contains("中雨")) {
                                imageView1.setImageResource(R.drawable.zhongyu);
                            } else if (todayWeather.getString("type").toString().contains("大雨")) {
                                imageView1.setImageResource(R.drawable.dayu);
                            } else if (todayWeather.getString("type").toString().contains("雾")) {
                                imageView1.setImageResource(R.drawable.wutian_l);
                            } else if (todayWeather.getString("type").toString().contains("霾")) {
                                imageView1.setImageResource(R.drawable.wutian_n);
                            } else if (todayWeather.getString("type").toString().contains("未知")) {
                                imageView1.setImageResource(R.drawable.weizhi);
                            }


                            if (imageView1 != null) {
                                JSONObject Tomorrow = forecast.getJSONObject(1);
                                String type1 = Tomorrow.getString("type") + "\n";
                                String high1 = Tomorrow.getString("high") + "\n";
                                String low1 = Tomorrow.getString("low") + "~";
                                String date1 = Tomorrow.getString("date") + "\n";
                                String wendu1 = data.getString("wendu") + "\n";
                                textView2.setText(date1 + type1 + "预计温度:" + wendu1 + low1 + high1);

                                if (Tomorrow.getString("type").toString().contains("多云")) {
                                    imageView2.setImageResource(R.drawable.duoyun1);
                                } else if (Tomorrow.getString("type").toString().contains("晴")) {
                                    imageView2.setImageResource(R.drawable.qingtian);
                                } else if (Tomorrow.getString("type").toString().contains("阴")) {
                                    imageView2.setImageResource(R.drawable.yintian);
                                } else if (Tomorrow.getString("type").toString().contains("阵雨")) {
                                    imageView2.setImageResource(R.drawable.zhenyu);
                                } else if (Tomorrow.getString("type").toString().contains("雷阵雨")) {
                                    imageView2.setImageResource(R.drawable.leizhenyu2);
                                } else if (Tomorrow.getString("type").toString().contains("小雨")) {
                                    imageView2.setImageResource(R.drawable.xiaoyu);
                                } else if (Tomorrow.getString("type").toString().contains("中雨")) {
                                    imageView2.setImageResource(R.drawable.zhongyu);
                                } else if (Tomorrow.getString("type").toString().contains("大雨")) {
                                    imageView2.setImageResource(R.drawable.dayu);
                                } else if (Tomorrow.getString("type").toString().contains("雾")) {
                                    imageView2.setImageResource(R.drawable.wutian_l);
                                } else if (Tomorrow.getString("type").toString().contains("霾")) {
                                    imageView2.setImageResource(R.drawable.wutian_n);
                                } else if (Tomorrow.getString("type").toString().contains("未知")) {
                                    imageView2.setImageResource(R.drawable.weizhi);
                                }
                            }

                            if (imageView2 != null) {
                                JSONObject postnatal = forecast.getJSONObject(2);
                                String type2 = postnatal.getString("type") + "\n";
                                String high2 = postnatal.getString("high") + "\n";
                                String low2 = postnatal.getString("low") + "~";
                                String date2 = postnatal.getString("date") + "\n";
                                String wendu2 = data.getString("wendu") + "\n";
                                textView3.setText(date2 + type2 + "预计温度:" + wendu2 + low2 + high2);

                                if (postnatal.getString("type").toString().contains("多云")) {
                                    imageView3.setImageResource(R.drawable.duoyun1);
                                } else if (postnatal.getString("type").toString().contains("晴")) {
                                    imageView3.setImageResource(R.drawable.qingtian);
                                } else if (postnatal.getString("type").toString().contains("阴")) {
                                    imageView3.setImageResource(R.drawable.yintian);
                                } else if (postnatal.getString("type").toString().contains("阵雨")) {
                                    imageView3.setImageResource(R.drawable.zhenyu);
                                } else if (postnatal.getString("type").toString().contains("雷阵雨")) {
                                    imageView3.setImageResource(R.drawable.leizhenyu2);
                                } else if (postnatal.getString("type").toString().contains("小雨")) {
                                    imageView3.setImageResource(R.drawable.xiaoyu);
                                } else if (postnatal.getString("type").toString().contains("中雨")) {
                                    imageView3.setImageResource(R.drawable.zhongyu);
                                } else if (postnatal.getString("type").toString().contains("大雨")) {
                                    imageView3.setImageResource(R.drawable.dayu);
                                } else if (postnatal.getString("type").toString().contains("雾")) {
                                    imageView3.setImageResource(R.drawable.wutian_l);
                                } else if (postnatal.getString("type").toString().contains("霾")) {
                                    imageView3.setImageResource(R.drawable.wutian_n);
                                } else if (postnatal.getString("type").toString().contains("未知")) {
                                    imageView3.setImageResource(R.drawable.weizhi);
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });

        mRequestQueue.add(mJsonObjectRequest);
    }

    private void getView() {

        mRequestQueue = Volley.newRequestQueue(this);
        String city = editText.getText().toString().trim();
        String city_encode = null;
        try {
            city_encode = URLEncoder.encode(city, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(
                "http://wthrcdn.etouch.cn/weather_mini?city=" + city_encode,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject data = new JSONObject(response.getString("data"));
                            JSONArray forecast = data.getJSONArray("forecast");
                            JSONObject todayWeather = forecast.getJSONObject(0);
                            String wendu = data.getString("wendu") + "\n";
                            //String ganmao = data.getString("ganmao") + "\n";
                            String high = todayWeather.getString("high") + "\n";
                            String low = todayWeather.getString("low") + "~";
                            String date = todayWeather.getString("date") + "\n";
                            String type = todayWeather.getString("type") + "\n";
                            String city = data.getString("city") + "\n";
                            textView1.setText(city + date + type + "实时温度:" + wendu + low + high);
                            /**
                             *Imageview  change
                             * * */
                            if (todayWeather.getString("type").toString().contains("多云")) {
                                imageView1.setImageResource(R.drawable.duoyun1);
                            } else if (todayWeather.getString("type").toString().contains("晴")) {
                                imageView1.setImageResource(R.drawable.qingtian);
                            } else if (todayWeather.getString("type").toString().contains("阴")) {
                                imageView1.setImageResource(R.drawable.yintian);
                            } else if (todayWeather.getString("type").toString().contains("阵雨")) {
                                imageView1.setImageResource(R.drawable.zhenyu);
                            } else if (todayWeather.getString("type").toString().contains("雷阵雨")) {
                                imageView1.setImageResource(R.drawable.leizhenyu2);
                            } else if (todayWeather.getString("type").toString().contains("小雨")) {
                                imageView1.setImageResource(R.drawable.xiaoyu);
                            } else if (todayWeather.getString("type").toString().contains("中雨")) {
                                imageView1.setImageResource(R.drawable.zhongyu);
                            } else if (todayWeather.getString("type").toString().contains("大雨")) {
                                imageView1.setImageResource(R.drawable.dayu);
                            } else if (todayWeather.getString("type").toString().contains("雾")) {
                                imageView1.setImageResource(R.drawable.wutian_l);
                            } else if (todayWeather.getString("type").toString().contains("霾")) {
                                imageView1.setImageResource(R.drawable.wutian_n);
                            } else if (todayWeather.getString("type").toString().contains("未知")) {
                                imageView1.setImageResource(R.drawable.weizhi);
                            }

                            if (imageView1 != null) {
                                JSONObject Tomorrow = forecast.getJSONObject(1);
                                String type1 = Tomorrow.getString("type") + "\n";
                                String high1 = Tomorrow.getString("high") + "\n";
                                String low1 = Tomorrow.getString("low") + "~";
                                String date1 = Tomorrow.getString("date") + "\n";
                                String wendu1 = data.getString("wendu") + "\n";
                                textView2.setText(date1 + type1 + "预计温度:" + wendu1 + low1 + high1);

                                if (Tomorrow.getString("type").toString().contains("多云")) {
                                    imageView2.setImageResource(R.drawable.duoyun1);
                                } else if (Tomorrow.getString("type").toString().contains("晴")) {
                                    imageView2.setImageResource(R.drawable.qingtian);
                                } else if (Tomorrow.getString("type").toString().contains("阴")) {
                                    imageView2.setImageResource(R.drawable.yintian);
                                } else if (Tomorrow.getString("type").toString().contains("阵雨")) {
                                    imageView2.setImageResource(R.drawable.zhenyu);
                                } else if (Tomorrow.getString("type").toString().contains("雷阵雨")) {
                                    imageView2.setImageResource(R.drawable.leizhenyu2);
                                } else if (Tomorrow.getString("type").toString().contains("小雨")) {
                                    imageView2.setImageResource(R.drawable.xiaoyu);
                                } else if (Tomorrow.getString("type").toString().contains("中雨")) {
                                    imageView2.setImageResource(R.drawable.zhongyu);
                                } else if (Tomorrow.getString("type").toString().contains("大雨")) {
                                    imageView2.setImageResource(R.drawable.dayu);
                                } else if (Tomorrow.getString("type").toString().contains("雾")) {
                                    imageView2.setImageResource(R.drawable.wutian_l);
                                } else if (Tomorrow.getString("type").toString().contains("霾")) {
                                    imageView2.setImageResource(R.drawable.wutian_n);
                                } else if (Tomorrow.getString("type").toString().contains("未知")) {
                                    imageView2.setImageResource(R.drawable.weizhi);
                                }
                            }

                            if (imageView2 != null) {
                                JSONObject postnatal = forecast.getJSONObject(2);
                                String type2 = postnatal.getString("type") + "\n";
                                String high2 = postnatal.getString("high") + "\n";
                                String low2 = postnatal.getString("low") + "~";
                                String date2 = postnatal.getString("date") + "\n";
                                String wendu2 = data.getString("wendu") + "\n";
                                textView3.setText(date2 + type2 + "预计温度:" + wendu2 + low2 + high2);

                                if (postnatal.getString("type").toString().contains("多云")) {
                                    imageView3.setImageResource(R.drawable.duoyun1);
                                } else if (postnatal.getString("type").toString().contains("晴")) {
                                    imageView3.setImageResource(R.drawable.qingtian);
                                } else if (postnatal.getString("type").toString().contains("阴")) {
                                    imageView3.setImageResource(R.drawable.yintian);
                                } else if (postnatal.getString("type").toString().contains("阵雨")) {
                                    imageView3.setImageResource(R.drawable.zhenyu);
                                } else if (postnatal.getString("type").toString().contains("雷阵雨")) {
                                    imageView3.setImageResource(R.drawable.leizhenyu2);
                                } else if (postnatal.getString("type").toString().contains("小雨")) {
                                    imageView3.setImageResource(R.drawable.xiaoyu);
                                } else if (postnatal.getString("type").toString().contains("中雨")) {
                                    imageView3.setImageResource(R.drawable.zhongyu);
                                } else if (postnatal.getString("type").toString().contains("大雨")) {
                                    imageView3.setImageResource(R.drawable.dayu);
                                } else if (postnatal.getString("type").toString().contains("雾")) {
                                    imageView3.setImageResource(R.drawable.wutian_l);
                                } else if (postnatal.getString("type").toString().contains("霾")) {
                                    imageView3.setImageResource(R.drawable.wutian_n);
                                } else if (postnatal.getString("type").toString().contains("未知")) {
                                    imageView3.setImageResource(R.drawable.weizhi);
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });

        mRequestQueue.add(mJsonObjectRequest);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            //requestCode即所声明的权限获取码，在checkSelfPermission时传入
            case 1:
                BAIDU_READ_PHONE_STATE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //获取到权限，做相应处理
                    //调用定位SDK应确保相关权限均被授权，否则会引起定位失败
                    bdLocationUtils.doLocation();//开启定位
                    bdLocationUtils.mLocationClient.start();//开始定位
                } else {
                    //没有获取到权限，做特殊处理
                    Log.e("Permissions", "没有权限定位失败");
                }
                break;
            default:
                break;
        }
    }
}
