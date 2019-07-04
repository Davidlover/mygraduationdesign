import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.Utils;

public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);

    }
}
