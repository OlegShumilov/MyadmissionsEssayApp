package essay.freewriters.myessay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class page2 extends AppCompatActivity {
    ViewPager2 imageContainer;
    SliderAdapter adapter;
    Drawable list[];
    TextView[] dots;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_page2);
        Button buttonNew = (Button)findViewById(R.id.buttonNew);
        Button buttonOrders = (Button)findViewById(R.id.buttonOrders);
        Button buttonPrice = (Button)findViewById(R.id.buttonPrice);
        Button buttonSamples = (Button)findViewById(R.id.buttonSamples);
        Button buttonGuarant = (Button)findViewById(R.id.buttonGuarant);
        Button buttonReviews = (Button)findViewById(R.id.buttonReviews);

        TextView mLink = (TextView) findViewById(R.id.textLink);
        if (mLink != null) {
            mLink.setMovementMethod(LinkMovementMethod.getInstance());
        }



        imageContainer = findViewById(R.id.image_container);
        layout = findViewById(R.id.dots_container);

        dots = new TextView[5];

        list = new Drawable[5];
        list[0] = getResources().getDrawable(R.drawable.ic_slaid1);
        list[1] = getResources().getDrawable(R.drawable.ic_slaid2);
        list[2] = getResources().getDrawable(R.drawable.ic_slaid3);
        list[3] = getResources().getDrawable(R.drawable.ic_slaid4);
        list[4] = getResources().getDrawable(R.drawable.ic_slaid5);


        adapter = new SliderAdapter(list);
        imageContainer.setAdapter(adapter);

        setIndicators();

        imageContainer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                selectedDots(position);
                super.onPageSelected(position);
            }
        });



        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlString="https://myadmissionsessay.com/order.html?pid=22491";
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try { startActivity(intent); }
                catch (ActivityNotFoundException ex) { // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent); }
            }
        });

        buttonOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlString="https://admin.myadmissionsessay.com/orders?pid=22491";
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try { startActivity(intent); }
                catch (ActivityNotFoundException ex) { // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent); }
            }
        });

        buttonPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlString="https://myadmissionsessay.com/prices.html?pid=22491";
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try { startActivity(intent); }
                catch (ActivityNotFoundException ex) { // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent); }
            }
        });

        buttonSamples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlString="https://myadmissionsessay.com/samples?pid=22491";
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try { startActivity(intent); }
                catch (ActivityNotFoundException ex) { // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent); }
            }
        });

        buttonGuarant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlString="https://myadmissionsessay.com/money-back-guarantee.html?pid=22491";
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try { startActivity(intent); }
                catch (ActivityNotFoundException ex) { // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent); }
            }
        });

        buttonReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlString="https://myadmissionsessay.com/reviews.html?pid=22491";
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try { startActivity(intent); }
                catch (ActivityNotFoundException ex) { // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent); }
            }
        });

    }

    private void selectedDots(int position) {
        for (int i = 0; i < dots.length; i++) {
            if (i == position) {
                dots[i].setTextColor(getResources().getColor(R.color.black));
            } else {
                dots[i].setTextColor(getResources().getColor(R.color.grey));
            }
        }
    }

    private void setIndicators() {
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            layout.addView(dots[i]);
        }

    }

}