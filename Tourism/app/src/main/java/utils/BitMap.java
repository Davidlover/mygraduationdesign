package utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.content.ContextCompat;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BitMap {

    public static Bitmap GetLocalOrNetBitmap(Context context, String url) {
        InputStream in;
        BufferedOutputStream out = null;
        try {
            in = context.getContentResolver().openInputStream(Uri.parse(url));

            return BitmapFactory.decodeStream(in);
//            final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
//            out = new BufferedOutputStream(dataStream, 300 * 300);
//            copy(in, out);
//            out.flush();
//            byte[] data = dataStream.toByteArray();
//            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
//            data = null;
//            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
