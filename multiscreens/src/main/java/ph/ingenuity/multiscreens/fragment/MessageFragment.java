package ph.ingenuity.multiscreens.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ph.ingenuity.multiscreens.R;


/**
 * @author aeroheart-c6
 * @since 11/6/15
 */
public class MessageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__message, container, false);
    }
}
