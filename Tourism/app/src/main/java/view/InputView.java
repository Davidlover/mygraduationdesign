package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.example.lenovo.tourism.R;

/**
 * 1、input——icon：输入框
 * 2、input---password：密码
 * 3、ispassword
 */
public class InputView extends FrameLayout {
    private int inputicon;
    private String inputHint;
    private boolean isPassword;

    private View mView;
    private ImageView mIvIcon;
    private EditText mEtInput;

    public InputView(Context context) {
        this(context, null);
    }

    public InputView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        //获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.inputView);
        inputicon = typedArray.getResourceId(R.styleable.inputView_input_icon, R.mipmap.login_pic);
        inputHint = typedArray.getString(R.styleable.inputView_input_hint);
        isPassword = typedArray.getBoolean(R.styleable.inputView_is_password, false);
        typedArray.recycle();//释放
//绑定layout布局
        mView=LayoutInflater.from(context).inflate(R.layout.input_view,this,false);
        mIvIcon=mView.findViewById(R.id.account);
        mEtInput=mView.findViewById(R.id.IV_input);
        //布局关联属性
        mIvIcon.setImageResource(inputicon);
        mEtInput.setHint(inputHint);
        mEtInput.setInputType(isPassword?InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD:InputType.TYPE_CLASS_PHONE);
        addView(mView);

    }
    public String getInputStr(){
        return  mEtInput.getText().toString().trim();
    }
}
