package ph.ingenuity.listview.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.adapter.ListViewAdapter;
import ph.ingenuity.listview.model.Car;
import ph.ingenuity.listview.util.AssetUtil;


/**
 * @author aeroheart-c6
 * @since 12/17/15
 */
public class ListViewActivity extends AppCompatActivity {
    protected List<Car> cars;
    protected ListViewAdapter carsAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.screen__list);
        
        this.cars = AssetUtil.loadCars(this.getAssets());
        this.carsAdapter = new ListViewAdapter(this.cars);
        
        this.bootstrapViews();
    }
    
    protected void bootstrapViews() {
        ListView cars;
        
        cars = (ListView)this.findViewById(R.id.cars);
        cars.setAdapter(this.carsAdapter);
    }
}
