package ph.ingenuity.listview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ph.ingenuity.listview.R;
import ph.ingenuity.listview.model.Car;


/**
 * @author aeroheart-c6
 * @since 1/1/16
 */
public class DetailFragment extends Fragment {
    protected Car car;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__detail, container, false);
    }
    
    public void setCar(Car car) {
        this.car = car;
    }
    
    public void refresh(View view) {
        if (view == null)
            view = this.getView();
        
        if (view == null)
            return;
        
        ((TextView)view.findViewById(R.id.model)).setText(this.car.model);
    }
    
    public void refresh() {
        this.refresh(null);
    }
}
