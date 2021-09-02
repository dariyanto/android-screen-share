package com.oddcn.screensharetobrowser.main.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.oddcn.screensharetobrowser.R;
import com.oddcn.screensharetobrowser.main.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, new MainFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (MainViewModel.isServerRunning.get()) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.warning)
                    .setMessage(R.string.dialog_exit_message)
                    .setPositiveButton(getResources().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton(getResources().getString(android.R.string.cancel), null)
                    .show();
        } else {
            finish();
        }
    }
}
