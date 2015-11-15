package ph.ingenuity.multiscreens.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.ingenuity.multiscreens.R;
import ph.ingenuity.multiscreens.fragment.InformationFragment;
import ph.ingenuity.multiscreens.model.Book;


/**
 * @author aeroheart-c6
 * @since 11/6/15
 */
public class InformationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screen__info);
        
        InformationFragment fragment;
        
        fragment = (InformationFragment)this.getSupportFragmentManager()
                                            .findFragmentById(R.id.content);
        fragment.render((Book)this.getIntent().getParcelableExtra("book"));
    }
}
