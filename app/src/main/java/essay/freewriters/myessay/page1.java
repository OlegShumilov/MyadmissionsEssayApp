package essay.freewriters.myessay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class page1 extends AppCompatActivity {

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
        setContentView(R.layout.activity_page1);
        Button buttonEmail = (Button)findViewById(R.id.buttonEmail);


        imageContainer = findViewById(R.id.image_container);
        layout = findViewById(R.id.dots_container);

        dots = new TextView[3];

        list = new Drawable[3];
        list[0] = getResources().getDrawable(R.drawable.ic_writers);
        list[1] = getResources().getDrawable(R.drawable.ic_grades);;
        list[2] = getResources().getDrawable(R.drawable.ic_doubt);;


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



        buttonEmail.setOnClickListener(new View.OnClickListener() {
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