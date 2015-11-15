package ph.ingenuity.multiscreens.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.ingenuity.multiscreens.R;
import ph.ingenuity.multiscreens.fragment.InformationFragment;
import ph.ingenuity.multiscreens.fragment.MessageFragment;
import ph.ingenuity.multiscreens.fragment.WelcomeFragment;
import ph.ingenuity.multiscreens.model.Book;


/**
 * @author aeroheart-c6
 * @since 11/6/15
 */
public class WelcomeActivity extends AppCompatActivity {
    protected InformationFragment bookFragment;
    protected MessageFragment messageFragment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screen__welcome);
        
        WelcomeFragment fragment;
        
        fragment = (WelcomeFragment)this.getSupportFragmentManager()
                                        .findFragmentById(R.id.content);
        fragment.addListener(new WelcomeFragmentListener());
    }
    
    protected void transitionToMessage() {
        if (this.findViewById(R.id.subcontent) == null)
            this.startActivity(new Intent(this, MessageActivity.class));
        else if (this.messageFragment == null) {
            this.messageFragment = new MessageFragment();
            this.bookFragment = null;
            
            this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.subcontent, this.messageFragment)
                .commit();
            
        }
        else
            return;
    }
    
    protected void transitionToBook(Book book) {
        if (this.findViewById(R.id.subcontent) == null)
            this.startActivity(
                new Intent(this, InformationActivity.class)
                    .putExtra("book", book)
            );
        else {
            if (this.bookFragment == null) {
                Bundle arguments;
                
                arguments = new Bundle();
                arguments.putParcelable("book", book);
                
                this.messageFragment = null;
                
                this.bookFragment = new InformationFragment();
                this.bookFragment.setArguments(arguments);

                this.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.subcontent, this.bookFragment)
                    .commit();
            }
            else
                this.bookFragment.render(book);
        }
    }
    
    /*
     ***********************************************************************************************
     * Inner Classes
     ***********************************************************************************************
     */
    protected class WelcomeFragmentListener implements WelcomeFragment.Listener {
        public void onMessageSelected() {
            WelcomeActivity.this.transitionToMessage();
        }
        
        public void onBookSelected(Book book) {
            WelcomeActivity.this.transitionToBook(book);
        }
    }
}
