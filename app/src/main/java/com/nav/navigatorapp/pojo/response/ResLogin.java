package com.nav.navigatorapp.pojo.response;

import android.os.Parcel;
import android.os.Parcelable;

public class ResLogin implements Parcelable {
    String id;
    String first_name;
    String gender;
    String gender_name;
    String last_name;
    String middle_name;
    String password;
    String state_name;
    String zipcode;

    protected ResLogin(Parcel in) {
        id = in.readString();
        first_name = in.readString();
        gender = in.readString();
        gender_name = in.readString();
        last_name = in.readString();
        middle_name = in.readString();
        password = in.readString();
        state_name = in.readString();
        zipcode = in.readString();
    }

    public static final Creator<ResLogin> CREATOR = new Creator<ResLogin>() {
        @Override
        public ResLogin createFromParcel(Parcel in) {
            return new ResLogin(in);
        }

        @Override
        public ResLogin[] newArray(int size) {
            return new ResLogin[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender_name() {
        return gender_name;
    }

    public void setGender_name(String gender_name) {
        this.gender_name = gender_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(first_name);
        parcel.writeString(gender);
        parcel.writeString(gender_name);
        parcel.writeString(last_name);
        parcel.writeString(middle_name);
        parcel.writeString(password);
        parcel.writeString(state_name);
        parcel.writeString(zipcode);
    }
}
