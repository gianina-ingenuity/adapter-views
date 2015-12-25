package ph.ingenuity.listview.util;


import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ph.ingenuity.listview.model.Car;


/**
 * @author aeroheart-c6
 * @since 12/17/15
 */
public class AssetUtil {
    private AssetUtil() {}
    
    public static List<Car> loadCars(AssetManager manager) {
        BufferedReader reader;
        StringBuilder builder;
        String line;
        String json;
        JSONArray data;

        try {
            reader = new BufferedReader(new InputStreamReader(manager.open("cars.json")));
            builder = new StringBuilder();

            while ((line = reader.readLine()) != null)
                builder.append(line);

            json = builder.toString();
        }
        catch (IOException exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
        
        try {
            data = new JSONArray(json);
        }
        catch (JSONException exception) {
            return new ArrayList<>();
        }
        
        List<Car> output = new ArrayList<>();
        
        for (int index = 0; index < data.length(); index++)
            output.add(new Car(data.optJSONObject(index)));
        
        return output;
    }
}
