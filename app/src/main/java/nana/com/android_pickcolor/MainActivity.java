package nana.com.android_pickcolor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;

public class MainActivity extends AppCompatActivity {

    private TextView vibrantView;
    private TextView vibrantLightView;
    private TextView vibrantDarkView;
    private TextView mutedView;
    private TextView mutedLightView;
    private TextView mutedDarkView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        paintTextBackground();
    }

    private void initViews() {
        vibrantView = (TextView) findViewById(R.id.vibrantView);
        vibrantLightView = (TextView) findViewById(R.id.vibrantLightView);
        vibrantDarkView = (TextView) findViewById(R.id.vibrantDarkView);
        mutedView = (TextView) findViewById(R.id.mutedView);
        mutedLightView = (TextView) findViewById(R.id.mutedLightView);
        mutedDarkView = (TextView) findViewById(R.id.mutedDarkView);

    }

    private void paintTextBackground() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wallpaper);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                //work with the palette here
                int defaultValue = 0x000000;
                int vibrant = palette.getVibrantColor(defaultValue);
                int vibrantLight = palette.getLightVibrantColor(defaultValue);
                int vibrantDark = palette.getDarkVibrantColor(defaultValue);
                int muted = palette.getMutedColor(defaultValue);
                int mutedLight = palette.getLightMutedColor(defaultValue);
                int mutedDark = palette.getDarkMutedColor(defaultValue);

                vibrantView.setBackgroundColor(vibrant);
                vibrantLightView.setBackgroundColor(vibrantLight);
                vibrantDarkView.setBackgroundColor(vibrantDark);
                mutedView.setBackgroundColor(muted);
                mutedLightView.setBackgroundColor(mutedLight);
                mutedDarkView.setBackgroundColor(mutedDark);
            }
        });


    }
}
