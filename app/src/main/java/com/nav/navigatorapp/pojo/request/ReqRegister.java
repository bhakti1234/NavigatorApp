package com.nav.navigatorapp.pojo.request;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReqRegister implements Parcelable {
    @SerializedName("first_name")
    @Expose
    String fname;
    @SerializedName("middle_name")
    @Expose
    String mname;
    @SerializedName("last_name")
    @Expose
    String lname;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("password")
    @Expose
    String password;

    public ReqRegister(Parcel in) {
        fname = in.readString();
        mname = in.readString();
        lname = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<ReqRegister> CREATOR = new Creator<ReqRegister>() {
        @Override
        public ReqRegister createFromParcel(Parcel in) {
            return new ReqRegister(in);
        }

        @Override
        public ReqRegister[] newArray(int size) {
            return new ReqRegister[size];
        }
    };

    public ReqRegister() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
        parcel.writeString(fname);
        parcel.writeString(mname);
        parcel.writeString(lname);
        parcel.writeString(email);
        parcel.writeString(password);
    }
}
