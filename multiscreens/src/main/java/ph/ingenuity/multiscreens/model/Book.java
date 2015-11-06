package ph.ingenuity.multiscreens.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;


/**
 * @author aeroheart-c6
 * @since 11/6/15
 */
public class Book implements Parcelable {
    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel parcel) {
            Book book;
            
            book = new Book();
            book.readFromParcel(parcel);
            
            return book;
        }
        
        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
    
    public String title;
    public String author;
    public int publishYear;
    public int pageCount;
    public List<String> chapters;
    
    public Book() {
        this.chapters = new ArrayList<>();
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
        parcel.writeString(this.title);
        parcel.writeString(this.author);
        parcel.writeInt(this.publishYear);
        parcel.writeInt(this.pageCount);
        
        parcel.writeList(this.chapters);
    }

    public void readFromParcel(Parcel parcel) {
        this.title = parcel.readString();
        this.author = parcel.readString();
        this.publishYear = parcel.readInt();
        this.pageCount = parcel.readInt();
        
        parcel.readList(this.chapters, List.class.getClassLoader());
    }
}
