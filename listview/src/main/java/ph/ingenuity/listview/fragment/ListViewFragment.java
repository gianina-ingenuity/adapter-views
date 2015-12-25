package ph.ingenuity.listview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
    protected List<Car> cars;
    protected ListViewAdapter carsAdapter;
    
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
    }
}
