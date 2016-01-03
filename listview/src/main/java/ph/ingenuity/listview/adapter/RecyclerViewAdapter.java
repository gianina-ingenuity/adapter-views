package ph.ingenuity.listview.adapter;


import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.model.Car;


/**
 * @author aeroheart-c6
 * @since 12/25/15
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    protected List<Car> cars;
    protected List<Listener> listeners;
    
    public RecyclerViewAdapter(List<Car> cars) {
        super();
        
        if (cars == null)
            cars = new ArrayList<>();
        
        this.cars = cars;
        this.listeners = new ArrayList<>();
    }
    
    @Override
    public int getItemCount() {
        return this.cars.size();
    }
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup container, int position) {
        return new ViewHolder(this, LayoutInflater.from(container.getContext()).inflate(
            R.layout.adapter__recycler__car,
            container,
            false
        ));
    }
    
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Resources res = holder.itemView.getResources();
        Car car = this.cars.get(position);
        
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
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }
    
    protected void fireSelectionEvent(View view) {
        for (Listener listener : this.listeners)
            listener.onItemSelected(view);
    }
    
    /*
     ***********************************************************************************************
     * Inner Classes
     ***********************************************************************************************
     */
    protected class ViewHolder extends RecyclerView.ViewHolder
                               implements View.OnClickListener {
        public TextView model;
        public TextView brand;
        public TextView price;
        public TextView weight;
        public TextView horsepower;
        
        protected RecyclerViewAdapter adapter;

        public ViewHolder(RecyclerViewAdapter adapter, View item) {
            super(item);

            this.model = (TextView)item.findViewById(R.id.model);
            this.brand = (TextView)item.findViewById(R.id.brand);
            this.price = (TextView)item.findViewById(R.id.price);
            this.weight = (TextView)item.findViewById(R.id.weight);
            this.horsepower = (TextView)item.findViewById(R.id.horsepower);
            
            this.adapter = adapter;
            
            item.setOnClickListener(this);
        }
        
        @Override
        public void onClick(View source) {
            this.adapter.fireSelectionEvent(this.itemView);
        }
    }
    
    public interface Listener {
        void onItemSelected(View view);
    }
}
