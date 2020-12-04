package com.alexis.kuku.Breeds;

import android.os.Parcel;
import android.os.Parcelable;

public final class BreedsInfo implements Parcelable {
    private String mImage;
    private  String mBreed;
    private  String mPurpose;
    private  String mExample;
    private  String mCharacteristics;

    public BreedsInfo(String breed, String image, String purpose, String example, String characteristics ){

        mImage = image;
        mBreed = breed;
        mPurpose = purpose;
        mExample = example;
        mCharacteristics = characteristics;
    }

    protected BreedsInfo(Parcel in) {
        mImage = in.readString();
        mBreed = in.readString();
        mPurpose = in.readString();
        mExample = in.readString();
        mCharacteristics = in.readString();
    }

    public static final Creator<BreedsInfo> CREATOR = new Creator<BreedsInfo>() {
        @Override
        public BreedsInfo createFromParcel(Parcel in) {
            return new BreedsInfo(in);
        }

        @Override
        public BreedsInfo[] newArray(int size) {
            return new BreedsInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mImage);
        parcel.writeString(mBreed);
        parcel.writeString(mPurpose);
        parcel.writeString(mExample);
        parcel.writeString(mCharacteristics);
    }

    public String getBreed() {
        return mBreed;
    }

    public void setBreed(String breed) {
        mBreed = breed;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getPurpose() {
        return mPurpose;
    }

    public void setPurpose(String purpose) {mPurpose = purpose;}

    public String getExample() {
        return mExample;
    }

    public void setExample(String example) {
        mExample = example;
    }

    public String getCharacteristics() {
        return mCharacteristics;
    }

    public void setCharacteristics(String characteristics) {
        mCharacteristics = characteristics;
    }
}
