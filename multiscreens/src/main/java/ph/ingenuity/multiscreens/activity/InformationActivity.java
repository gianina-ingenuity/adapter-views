package ph.ingenuity.multiscreens.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
        
        this.renderInfoFragment((Book)this.getIntent().getParcelableExtra("book"));
    }
    
    protected void renderInfoFragment(Book book) {
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction;
        InformationFragment fragment;
        Bundle arguments;
        
        arguments = new Bundle();
        arguments.putParcelable("book", book);
        
        fragment = new InformationFragment();
        fragment.setArguments(arguments);
        
        transaction = manager.beginTransaction();
        transaction.add(R.id.content, fragment);
        transaction.commit();
    }
}
