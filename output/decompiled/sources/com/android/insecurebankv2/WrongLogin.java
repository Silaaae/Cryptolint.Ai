package com.android.insecurebankv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class WrongLogin extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0230R.layout.activity_wrong_login);
        Toast.makeText(getApplicationContext(), "Invalid Credentials!!", 1).show();
        Intent backtoLogin = new Intent(this, (Class<?>) LoginActivity.class);
        startActivity(backtoLogin);
        finish();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0230R.menu.main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == C0230R.id.action_settings) {
            callPreferences();
            return true;
        }
        if (id == C0230R.id.action_exit) {
            Intent i = new Intent(getBaseContext(), (Class<?>) LoginActivity.class);
            i.addFlags(67108864);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void callPreferences() {
        Intent i = new Intent(this, (Class<?>) FilePrefActivity.class);
        startActivity(i);
    }
}
