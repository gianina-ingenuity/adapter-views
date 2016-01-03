package ph.ingenuity.listview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.adapter.ListViewAdapter;
import ph.ingenuity.listview.model.Car;
import ph.ingenuity.listview.util.AssetUtil;


/**
 * @author aeroheart-c6
 * @since 12/25/15
 */
public class ListViewFragment extends Fragment {
    protected List<Listener> listeners;
    protected List<Car> cars;
    protected ListViewAdapter carsAdapter;
    
    public ListViewFragment() {
        super();
        
        this.listeners = new ArrayList<>();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__list, container, false);

        this.cars = AssetUtil.loadCars(this.getActivity().getAssets());
        this.carsAdapter = new ListViewAdapter(this.cars);

        this.bootstrapViews(view);
        
        return view;
    }

    protected void bootstrapViews(View view) {
        ListView cars;

        cars = (ListView)view.findViewById(R.id.cars);
        cars.setAdapter(this.carsAdapter);
        cars.setOnItemClickListener(new ItemClickListener());
    }
    
    protected void fireSelectionEvent(Car car) {
        for (Listener listener : this.listeners)
            listener.onCarSelected(car);
    }
    
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }
    
    /*
     ***********************************************************************************************
     * Inner Classes
     ***********************************************************************************************
     */
    protected class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> source, View view, int position, long itemId) {
            ListViewFragment self = ListViewFragment.this;
            
            self.fireSelectionEvent(self.cars.get(position));
        }
    }
    
    /*
     ***********************************************************************************************
     * Interfaces
     ***********************************************************************************************
     */
    public interface Listener {
        void onCarSelected(Car car);
    }
}
