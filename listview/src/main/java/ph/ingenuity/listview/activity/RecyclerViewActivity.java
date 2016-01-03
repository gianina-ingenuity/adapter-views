package ph.ingenuity.listview.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.fragment.ListViewFragment;
import ph.ingenuity.listview.fragment.RecyclerViewFragment;
import ph.ingenuity.listview.model.Car;


/**
 * @author aeroheart-c6
 * @since 12/25/15
 */
public class RecyclerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screen__recycler);

        RecyclerViewFragment fragment;

        fragment = (RecyclerViewFragment)this.getSupportFragmentManager().findFragmentById(R.id.content__main);
        fragment.addListener(new FragmentListener());
    }

    /*
     ***********************************************************************************************
     * Inner Classes
     ***********************************************************************************************
     */
    protected class FragmentListener implements RecyclerViewFragment.Listener {
        @Override
        public void onCarSelected(Car car) {
            RecyclerViewActivity self = RecyclerViewActivity.this;
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
