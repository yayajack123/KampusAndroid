package com.example.kampusku;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.kampusku.ApiHelper.AccessToken;
import com.example.kampusku.ApiHelper.BaseApiHelper;
import com.example.kampusku.ApiHelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView regis;
    EditText etEmail;
    EditText etPassword;
    CircularProgressButton btnLogin;
    Button btnRegister;
    ProgressDialog loading;
    SharedPreferences sharedPreferences;
    Context mContext;
    BaseApiHelper mApiService;
    boolean session = false;
    TokenManager tokenManager;
    String token;
    final String SHARED_PREFERENCES_NAME = "shared_preferences";
    final String SESSION_STATUS = "session";
    public final static String TAG_TOKEN = "token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        session = sharedPreferences.getBoolean(SESSION_STATUS, false);
        token = sharedPreferences.getString(TAG_TOKEN, null);
        if (session){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra(TAG_TOKEN, token);
            finish();
            startActivity(intent);
        }


        initComponents();
    }


    private void initComponents() {
        etEmail = (EditText) findViewById(R.id.iemail);
        etPassword = (EditText) findViewById(R.id.ipassword);
        btnLogin = (CircularProgressButton) findViewById(R.id.blogin);
        btnRegister = (Button) findViewById(R.id.bregis);
        regis = (TextView) findViewById(R.id.regis);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                Login();
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, RegisterActivity.class));
            }
        });
    }


    private void requestLogin() {
        mApiService.loginRequest(etEmail.getText().toString(), etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                String test = response.body().string();
                                Log.d("anjya", "onResponse: "+test);
                                token = test;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(mContext, "Berhasil Login", Toast.LENGTH_SHORT).show();
                            loading.dismiss();
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean(SESSION_STATUS, true);
                            editor.putString(TAG_TOKEN,token );
                            editor.apply();
                            Intent intent = new Intent(mContext, MainActivity.class);
                            startActivity(intent);
                                } else {
                                    // Jika login gagal
                                    Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
                                    loading.dismiss();
                                }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }

                });
    }

    private void Login() {
        mApiService.loginRequest(etEmail.getText().toString(), etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("status").equals("success")) {
                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.

                                    String name = jsonRESULTS.getJSONObject("data").getString("token");
                                    Log.d("wanjay", "onResponse: "+name);
                                    token = name;
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putBoolean(SESSION_STATUS, true);
                                    editor.putString(TAG_TOKEN,token );
                                    editor.apply();
                                    Toast.makeText(mContext, "token "+name, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    // Jika login gagal
                                    Toast.makeText(mContext, "EEROOR", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }

                });
    }

}
