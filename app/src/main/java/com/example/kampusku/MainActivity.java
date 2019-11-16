package com.example.kampusku;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kampusku.Kampus.KampusList;

public class MainActivity extends AppCompatActivity {

    Button btnKampus;
    TextView tvResultName;
    String resultName;
    SharedPreferences sharedPreferences;
    boolean session = false;
    String token;
    final String SHARED_PREFERENCES_NAME = "shared_preferences";
    final String SESSION_STATUS = "session";
    public final static String TAG_TOKEN = "token";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        session = sharedPreferences.getBoolean(SESSION_STATUS, false);
        token = sharedPreferences.getString(TAG_TOKEN, null);

        initComponents();
        // untuk mendapatkan data dari activity sebelumnya, yaitu activity login.
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            resultName = extras.getString("result_name");
        tvResultName.setText(resultName);
        btnKampus = (Button) findViewById(R.id.btnkampus);

        btnKampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), KampusList.class));
                finish();
            }
        });
        /* Men-set Status dan User yang sedang login menjadi default atau kosong di
         * Data Preferences. Kemudian menuju ke LoginActivity*/
        findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menghapus Status login dan kembali ke Login Activity
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(SESSION_STATUS);
                editor.remove(TAG_TOKEN);
                editor.apply();
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        });


    }

    private void initComponents() {
        tvResultName = (TextView) findViewById(R.id.tv_namaMain);
    }
}
