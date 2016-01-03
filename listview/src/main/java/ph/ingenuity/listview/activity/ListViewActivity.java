package ph.ingenuity.listview.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.fragment.ListViewFragment;
import ph.ingenuity.listview.model.Car;


/**
 * @author aeroheart-c6
 * @since 12/17/15
 */
public class ListViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screen__list);
        
        ListViewFragment fragment;
        
        fragment = (ListViewFragment)this.getSupportFragmentManager().findFragmentById(R.id.content__main);
        fragment.addListener(new FragmentListener());
    }
    
    /*
     ***********************************************************************************************
     * Inner Classes
     ***********************************************************************************************
     */
    protected class FragmentListener implements ListViewFragment.Listener {
        @Override
        public void onCarSelected(Car car) {
            ListViewActivity self = ListViewActivity.this;
            Bundle extras;
            
            extras = new Bundle();
            extras.putParcelable("car", car);
            
            self.startActivity(
                new Intent(self, DetailActivity.class)
                    .putExtras(extras)
            );
        }
    }
}
