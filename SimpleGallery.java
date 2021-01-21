import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import com.example.memorydemo.R;

public class SimpleGallery extends Activity {

    private static final String TAG = "SimpleGallery";

    @Override
    protected void onCreate(Bundle onSavedInstance) {
        super.onCreate(onSavedInstance);
        setContentView(R.layout.simple_gallery_layout);

        Gallery gallery = findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));
    }

    private class ImageAdapter extends BaseAdapter {

        // 这里我们使用Android原生的资源图标
        private int[] imageIds = {
                android.R.drawable.btn_minus,
                android.R.drawable.btn_radio,
                android.R.drawable.ic_lock_idle_low_battery,
                android.R.drawable.ic_menu_camera };

        private Context mContext;

        public ImageAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public Object getItem(int position) {
            return imageIds[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           ImageView imageView;
            if (convertView == null) {
                Log.i(TAG, "convertView is null, create new imageview");
                imageView = new ImageView(mContext);
            } else {
                Log.i(TAG, "Cast convertView to ImageView");
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(imageIds[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));
            return imageView;
        }
    }

}
