package ph.ingenuity.listview.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.fragment.DetailFragment;
import ph.ingenuity.listview.model.Car;


/**
 * @author aeroheart-c6
 * @since 1/3/16
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screen__detail);
        
        Bundle extras = this.getIntent().getExtras();
        DetailFragment fragment;
        
        fragment = (DetailFragment)this.getSupportFragmentManager().findFragmentById(R.id.content__main);
        fragment.setCar((Car)extras.getParcelable("car"));
        fragment.refresh();
    }
}
