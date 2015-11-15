package ph.ingenuity.multiscreens.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ph.ingenuity.multiscreens.R;
import ph.ingenuity.multiscreens.model.Book;


/**
 * @author aeroheart-c6
 * @since 11/6/15
 */
public class InformationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment__info, container, false);
        Book book;
        
        if (this.getArguments() != null) {
            book = this.getArguments().getParcelable("book");
            this.renderBook(root, book);
        }
        
        return root;
    }
    
    public void render(Book book) {
        this.renderBook(this.getView(), book);
    }
    
    protected void renderBook(View root, Book book) {
        LinearLayout chaptersHolder;

        ((TextView)root.findViewById(R.id.title)).setText(book.title);
        ((TextView)root.findViewById(R.id.author)).setText(book.author);
        ((TextView)root.findViewById(R.id.pagecount)).setText(String.valueOf(book.pageCount));
        ((TextView)root.findViewById(R.id.publishyear)).setText(String.valueOf(book.publishYear));

        chaptersHolder = (LinearLayout)root.findViewById(R.id.chapters__holder);
        chaptersHolder.removeAllViews();

        for (String chapter : book.chapters)
            chaptersHolder.addView(this.renderChapter(chaptersHolder, chapter));
    }
    
    protected View renderChapter(LinearLayout container, String chapter) {
        View view = LayoutInflater.from(container.getContext()).inflate(
            R.layout.cell__chapter,
            container,
            false
        );
        TextView label;
        
        label = (TextView)view.findViewById(R.id.label);
        label.setText(chapter);
        
        return view;
    }
}
