package ph.ingenuity.listview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ph.ingenuity.listview.R;


/**
 * @author aeroheart-c6
 * @since 1/1/16
 */
public class LauncherFragment extends Fragment {
    protected List<Listener> listeners;
    
    public LauncherFragment() {
        super();
        this.listeners = new ArrayList<>();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment__launcher, container, false);
        ClickListener listener = new ClickListener();
        
        root.findViewById(R.id.listview).setOnClickListener(listener);
        root.findViewById(R.id.recyclerview).setOnClickListener(listener);
        
        return root;
    }
    
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }
    
    protected void fireListRequest() {
        for (Listener listener : this.listeners)
            listener.onListViewRequested();
    }
    
    protected void fireRecyclerRequest() {
        for (Listener listener : this.listeners)
            listener.onRecyclerRequested();
    }
    
    /*
     ***********************************************************************************************
     * Inner Classes
     ***********************************************************************************************
     */
    protected class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View source) {
            LauncherFragment self = LauncherFragment.this;
            
            if (source.getId() == R.id.listview)
                self.fireListRequest();
            else if (source.getId() == R.id.recyclerview)
                self.fireRecyclerRequest();
        }
    }
    
    public interface Listener {
        void onListViewRequested();
        void onRecyclerRequested();
    }
}
