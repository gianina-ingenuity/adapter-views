package ph.ingenuity.multiscreens.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ph.ingenuity.multiscreens.R;
import ph.ingenuity.multiscreens.activity.InformationActivity;
import ph.ingenuity.multiscreens.activity.MessageActivity;
import ph.ingenuity.multiscreens.model.Book;


/**
 * @author aeroheart-c6
 * @since 11/6/15
 */
public class WelcomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment__welcome, container, false);
        
        this.bootstrapHandlers(root);
        
        return root;
    }
    
    protected void bootstrapHandlers(View root) {
        ClickListener listener = new ClickListener();
        Button button;
        
        button = (Button)root.findViewById(R.id.message);
        button.setOnClickListener(listener);
        
        button = (Button)root.findViewById(R.id.ctulhu);
        button.setOnClickListener(listener);
        
        button = (Button)root.findViewById(R.id.timemachine);
        button.setOnClickListener(listener);
    }
    
    protected void transitionToMessage() {
        this.getActivity().startActivity(new Intent(
            this.getActivity(),
            MessageActivity.class
        ));
    }
    
    protected void transitionToInformation(Book book) {
        this.getActivity().startActivity(
            new Intent(this.getActivity(), InformationActivity.class)
                .putExtra("book", book)
        );
    }
    
    
    /*
     ***********************************************************************************************
     * Inner Classes
     ***********************************************************************************************
     */
    protected class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            WelcomeFragment self = WelcomeFragment.this;
            Book book;
            
            switch (view.getId()) {
                case R.id.message:
                    self.transitionToMessage();
                    break;
                
                case R.id.ctulhu:
                    book = new Book();
                    book.title = "The Call of Ctulhu";
                    book.author = "H. P. Lovecraft";
                    book.pageCount = 1532;
                    book.publishYear = 1926;
                    
                    book.chapters.add("The Horror in Clay");
                    book.chapters.add("The Tale of Inspector Legrasse");
                    book.chapters.add("The Madness from the Sea");
                    
                    self.transitionToInformation(book);
                    break;
                
                case R.id.timemachine:
                    book = new Book();
                    book.title = "The Time Machine";
                    book.author = "H. G. Wells";
                    book.pageCount = 675;
                    book.publishYear = 1895;
                    
                    book.chapters.add("Chapter I");
                    book.chapters.add("Chapter II");
                    book.chapters.add("Chapter III");
                    
                    self.transitionToInformation(book);
                    break;
            }
        }
    }
}
