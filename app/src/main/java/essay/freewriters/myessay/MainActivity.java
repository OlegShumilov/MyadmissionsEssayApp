package essay.freewriters.myessay;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
       // setContentView(R.layout.activity_main);

            SharedPreferences sp = getSharedPreferences("hasVisited",
                    Context.MODE_PRIVATE);
            // проверяем, первый ли раз открывается программа (Если вход первый то вернет false)
            boolean hasVisited = sp.getBoolean("hasVisited", false);

            if (!hasVisited) {  // Чтобы вернуть назад нужно написать условие   !hasVisited
                // Сработает если Вход первый

                //Ставим метку что вход уже был
                SharedPreferences.Editor ee = sp.edit();
                ee.putBoolean("hasVisited", true);
                ee.commit(); //После этого hasVisited будет уже true и будет означать, что вход уже был

                //Ниже запускаем активность которая нужна при первом входе
                try {
                    Intent intent = new Intent(MainActivity.this, page1.class);
                    startActivity(intent);
                    finish();}
                catch (Exception e) {}


            }else {

                //Сработает если вход в приложение уже был
                //Ниже запускаем активность которая нужна при последующих входах
                //setContentView(R.layout.activity_page2);
                try {
                    Intent intent = new Intent(MainActivity.this, page2.class);
                    startActivity(intent);
                    finish();}
                catch (Exception e) {}

            }







    }
}