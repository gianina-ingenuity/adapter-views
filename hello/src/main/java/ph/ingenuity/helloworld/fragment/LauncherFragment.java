package ph.ingenuity.helloworld.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ph.ingenuity.helloworld.R;


/**
 * @author aeroheart-c6
 * @since 11/3/15
 */
public class LauncherFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__launcher, container, false);
    }
}
