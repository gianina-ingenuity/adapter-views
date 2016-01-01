package ph.ingenuity.listview.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.adapter.RecyclerViewAdapter;
import ph.ingenuity.listview.model.Car;
import ph.ingenuity.listview.util.AssetUtil;
import ph.ingenuity.listview.widgets.recycler.SpacingDecoration;


/**
 * @author aeroheart-c6
 * @since 12/25/15
 */
public class RecyclerViewFragment extends Fragment {
    protected List<Car> cars;
    protected RecyclerViewAdapter carsAdapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Activity activity = this.getActivity();
        View root = inflater.inflate(R.layout.fragment__recycler, container, false);
        RecyclerView list;
        
        this.cars = AssetUtil.loadCars(activity.getAssets());
        this.carsAdapter = new RecyclerViewAdapter(this.cars);
        
        list = (RecyclerView)root.findViewById(R.id.cars);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        list.setAdapter(this.carsAdapter);
        list.addItemDecoration(new SpacingDecoration(activity, 5, SpacingDecoration.POLICY_INCLUDE_EDGES_ALL));
        
        return root;
    }
}
