package com.sistemasinteligentes.itesm.feelinggood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    SharedPreferences sp;
    public static final String MY_PREFERENCES = "preferences";
    public static final String username = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences(MY_PREFERENCES, context.MODE_PRIVATE);
        if (sp.contains(username)) {
            System.out.println("User validated.");
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            System.out.print("Could't validate user.");
        }
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToSignIn(View view) {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}
