package ph.ingenuity.helloworld.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.ingenuity.helloworld.R;


/**
 * @author aeroheart-c6
 * @since 11/2/15
 */
public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screen__launcher);
    }
}
