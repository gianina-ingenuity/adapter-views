package ph.ingenuity.listview.model;


import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;


/**
 * @author aeroheart-c6
 * @since 12/16/15
 */
public class Car implements Parcelable {
    public static final Creator CREATOR = new Creator();
    
    public String brand;
    public String model;
    public int price;
    
    public int horsepower;
    public int grams;
    public boolean manual;
    
    
    public Car() {
        
    }
    
    public Car(Parcel parcel) {
        this.readFromParcel(parcel);
    }
    
    public Car(JSONObject json) {
        this.fromJSON(json);
    }
    
    
    /*
     ***********************************************************************************************
     * Serialization / Deserialization
     ***********************************************************************************************
     */
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.brand);
        parcel.writeString(this.model);
        parcel.writeInt(this.price);
        parcel.writeInt(this.horsepower);
        parcel.writeInt(this.grams);
        parcel.writeInt(this.manual ? 1 : 0);
    }
    
    public void readFromParcel(Parcel parcel) {
        this.brand = parcel.readString();
        this.model = parcel.readString();
        this.price = parcel.readInt();
        this.horsepower = parcel.readInt();
        this.grams = parcel.readInt();
        this.manual = parcel.readInt() == 1;
    }
    
    public void fromJSON(JSONObject json) {
        this.brand = json.optString("brand");
        this.model = json.optString("model");
        this.price = json.optInt("price");
        this.horsepower = json.optInt("horsepower");
        this.grams = json.optInt("grams");
        this.manual = json.optBoolean("manual");
    }
    
    
    /*
     ***********************************************************************************************
     * Inner Clases
     ***********************************************************************************************
     */
    public static class Creator implements Parcelable.Creator<Car> {
        @Override
        public Car createFromParcel(Parcel parcel) {
            return new Car(parcel);
        }
        
        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    }
}
