package ss.com.bannerslidersample;

import android.os.Bundle;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.views.BannerSlider;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.events.OnBannerClickListener;
import ss.com.bannerslider.views.indicators.IndicatorShape;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();

        final BannerSlider bannerSlider1 = (BannerSlider) findViewById(R.id.banner_slider1);
        final BannerSlider bannerSlider2 = (BannerSlider) findViewById(R.id.banner_slider2);

        bannerSlider1.addBanner(new RemoteBanner("https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg"));
        bannerSlider1.addBanner(new RemoteBanner("https://assets.materialup.com/uploads/4b88d2c1-9f95-4c51-867b-bf977b0caa8c/preview.gif"));
        bannerSlider1.addBanner(new RemoteBanner("https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png"));
        bannerSlider1.addBanner(new RemoteBanner("https://assets.materialup.com/uploads/05e9b7d9-ade2-4aed-9cb4-9e24e5a3530d/preview.jpg"));


        bannerSlider2.addBanner(new DrawableBanner(R.drawable.creative_kids));
        bannerSlider2.addBanner(new DrawableBanner(R.drawable.mat_design));
        bannerSlider2.addBanner(new DrawableBanner(R.drawable.instant_banner));
        bannerSlider2.addBanner(new DrawableBanner(R.drawable.material_android_hive));

        bannerSlider1.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, "Banner with position " + String.valueOf(position) + " clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        List<String> indicatorsList=new ArrayList<>();
        indicatorsList.add("Circle");
        indicatorsList.add("Dash");
        indicatorsList.add("Round Square");
        indicatorsList.add("Square");
        indicatorsList.add("Custom");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,indicatorsList);
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        bannerSlider1.setDefaultIndicator(IndicatorShape.CIRCLE);
                        break;
                    case 1:
                        bannerSlider1.setDefaultIndicator(IndicatorShape.DASH);
                        break;
                    case 2:
                        bannerSlider1.setDefaultIndicator(IndicatorShape.ROUND_SQUARE);
                        break;
                    case 3:
                        bannerSlider1.setDefaultIndicator(IndicatorShape.SQUARE);
                        break;
                    case 4:
                        bannerSlider1.setCustomIndicator(VectorDrawableCompat.create(getResources(),R.drawable.selected_slide_indicator,null),
                                VectorDrawableCompat.create(getResources(),R.drawable.unselected_slide_indicator,null));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
