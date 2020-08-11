package com.nav.navigatorapp.pojo.request;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReqLogin implements Parcelable {
    @SerializedName("username")
    @Expose
    String email;

    @SerializedName("password ")
    @Expose
    String password;

    public ReqLogin(Parcel in) {
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<ReqLogin> CREATOR = new Creator<ReqLogin>() {
        @Override
        public ReqLogin createFromParcel(Parcel in) {
            return new ReqLogin(in);
        }

        @Override
        public ReqLogin[] newArray(int size) {
            return new ReqLogin[size];
        }
    };

    public ReqLogin() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(password);
    }
}
