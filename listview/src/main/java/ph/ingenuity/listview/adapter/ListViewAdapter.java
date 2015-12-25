package ph.ingenuity.listview.adapter;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.model.Car;


/**
 * @author aeroheart-c6
 * @since 12/17/15
 */
public class ListViewAdapter extends BaseAdapter {
    protected List<Car> cars;
    
    public ListViewAdapter(List<Car> cars) {
        super();
        
        if (cars == null)
            cars = new ArrayList<>();
        
        this.cars = cars;
    }
    
    @Override
    public int getCount() {
        return this.cars.size();
    }
    
    @Override
    public long getItemId(int position) {
        return 0;
    }
    
    @Override
    public Car getItem(int position) {
        return this.cars.get(position);
    }
    
    @Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @Override
    public View getView(int position, View view, ViewGroup container) {
        Context context = container.getContext();
        Resources res = context.getResources();
        View root = LayoutInflater.from(context).inflate(
            R.layout.adapter__list__car,
            container,
            false
        );
        TextView label;
        
        Car car = this.getItem(position);
        
        label = (TextView)root.findViewById(R.id.model);
        label.setText(car.model);
        
        label = (TextView)root.findViewById(R.id.brand);
        label.setText(car.brand);
        
        label = (TextView)root.findViewById(R.id.weight);
        label.setText(res.getString(
            R.string.car__weight,
            String.format("%.2f", (float)car.grams / 2.0)
        ));
        
        label = (TextView)root.findViewById(R.id.horsepower);
        label.setText(res.getString(
            R.string.car__power,
            car.horsepower
        ));
        
        label = (TextView)root.findViewById(R.id.price);
        label.setText(String.format("%.2f", (float)car.price));

        return root;
    }
}
