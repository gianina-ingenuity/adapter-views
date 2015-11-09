package ph.ingenuity.layouts.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.ingenuity.layouts.R;


/**
 * @author aeroheart-c6
 * @since 11/9/15
 */
public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screen__launcher);
    }
}
