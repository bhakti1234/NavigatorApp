package com.nav.navigatorapp.pojo.request;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nav.navigatorapp.pojo.response.ResLogin;

public class LoginData implements Parcelable {
    @SerializedName("data")
    @Expose
    private ResLogin data;

    protected LoginData(Parcel in) {
        data = in.readParcelable(ResLogin.class.getClassLoader());
    }

    public static final Creator<LoginData> CREATOR = new Creator<LoginData>() {
        @Override
        public LoginData createFromParcel(Parcel in) {
            return new LoginData(in);
        }

        @Override
        public LoginData[] newArray(int size) {
            return new LoginData[size];
        }
    };

    public ResLogin getData() {
        return data;
    }

    public void setData(ResLogin data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(data, i);
    }
}
