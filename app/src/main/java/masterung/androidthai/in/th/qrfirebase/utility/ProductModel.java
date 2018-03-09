package masterung.androidthai.in.th.qrfirebase.utility;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 9/3/2561.
 */

public class ProductModel implements Parcelable{

//    Explicit
     private String dataTimeString, codeString;

    public ProductModel() {
    } // Constuctor Setter

    public ProductModel(String dataTimeString, String codeString) {
        this.dataTimeString = dataTimeString;
        this.codeString = codeString;
    } // Constructor Getter

    protected ProductModel(Parcel in) {
        dataTimeString = in.readString();
        codeString = in.readString();
    }

    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel in) {
            return new ProductModel(in);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };

    public String getDataTimeString() {
        return dataTimeString;
    }

    public void setDataTimeString(String dataTimeString) {
        this.dataTimeString = dataTimeString;
    }

    public String getCodeString() {
        return codeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dataTimeString);
        parcel.writeString(codeString);
    }
} // Main Class
