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
        
        ViewHolder holder;
        
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                R.layout.adapter__list__car,
                container,
                false
            );
            
            holder = new ViewHolder();
            holder.model = (TextView)view.findViewById(R.id.model);
            holder.brand = (TextView)view.findViewById(R.id.brand);
            holder.weight = (TextView)view.findViewById(R.id.weight);
            holder.horsepower = (TextView)view.findViewById(R.id.horsepower);
            holder.price = (TextView)view.findViewById(R.id.price);
            
            view.setTag(holder);
        }
        else
            holder = (ViewHolder)view.getTag();
        
        Car car = this.getItem(position);
        
        holder.model.setText(car.model);
        holder.brand.setText(car.brand);
        holder.weight.setText(res.getString(
            R.string.car__weight,
            String.format("%.2f", (float)car.grams / 2.0)
        ));
        holder.horsepower.setText(res.getString(
            R.string.car__power,
            car.horsepower
        ));
        holder.price.setText(String.format("%.2f", (float)car.price));
        
        return view;
    }

    /*
     ***********************************************************************************************
     * Inner Classes
     *********************************************************************************************** 
     */
    protected static class ViewHolder {
        public TextView model;
        public TextView brand;
        public TextView price;
        public TextView weight;
        public TextView horsepower;
    }
}
