package ph.ingenuity.listview.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.fragment.LauncherFragment;


/**
 * @author aeroheart-c6
 * @since 11/2/15
 */
public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screen__launcher);
        
        LauncherFragment fragment;
        
        fragment = (LauncherFragment)this.getSupportFragmentManager().findFragmentById(R.id.content__main);
        fragment.addListener(new FragmentListener());
    }
    
    /*
     ***********************************************************************************************
     * Inner Classes
     ***********************************************************************************************
     */
    protected class FragmentListener implements LauncherFragment.Listener {
        @Override
        public void onListViewRequested() {
            LauncherActivity.this.startActivity(new Intent(
                LauncherActivity.this,
                ListViewActivity.class
            ));
        }
        
        public void onRecyclerRequested() {
            LauncherActivity.this.startActivity(new Intent(
                LauncherActivity.this,
                RecyclerViewActivity.class
            ));
        }
    }
}




