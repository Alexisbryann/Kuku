package com.alexis.kuku.MainActivity;

import android.os.Parcel;
import android.os.Parcelable;

public class MainInfo implements Parcelable {

    private String mBreeds;
    private String mHousingAndEquipment;
    private String mBrooding;
    private String mPoultryManagement;
    private String mCommonDiseases;
    private String mBadHabits;
    private String mBestPractice;

    public  MainInfo(String breeds, String housingAndEquipment, String brooding, String poultryManagement, String commonDiseases, String badHabits, String bestPractice ){
        mBreeds = breeds;
        mHousingAndEquipment = housingAndEquipment;
        mBrooding = brooding;
        mPoultryManagement = poultryManagement;
        mCommonDiseases = commonDiseases;
        mBadHabits = badHabits;
        mBestPractice = bestPractice;
    }

    protected MainInfo(Parcel in) {
        mBreeds = in.readString();
        mHousingAndEquipment = in.readString();
        mBrooding = in.readString();
        mPoultryManagement = in.readString();
        mCommonDiseases = in.readString();
        mBadHabits = in.readString();
        mBestPractice = in.readString();
    }

    public static final Creator<MainInfo> CREATOR = new Creator<MainInfo>() {
        @Override
        public MainInfo createFromParcel(Parcel in) {
            return new MainInfo(in);
        }

        @Override
        public MainInfo[] newArray(int size) {
            return new MainInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mBreeds);
        parcel.writeString(mHousingAndEquipment);
        parcel.writeString(mBrooding);
        parcel.writeString(mPoultryManagement);
        parcel.writeString(mCommonDiseases);
        parcel.writeString(mBadHabits);
        parcel.writeString(mBestPractice);
    }

    public String getBreeds() {
        return mBreeds;
    }

    public void setBreeds(String breeds) {
        mBreeds = breeds;
    }

    public String getHousingAndEquipment() {
        return mHousingAndEquipment;
    }

    public void setHousingAndEquipment(String housingAndEquipment) {mHousingAndEquipment = housingAndEquipment;}

    public String getBrooding() {
        return mBrooding;
    }

    public void setBrooding(String brooding) {
        mBrooding = brooding;
    }

    public String getPoultryManagement() {
        return mPoultryManagement;
    }

    public void setPoultryManagement(String poultryManagement) {mPoultryManagement = poultryManagement; }

    public String getCommonDiseases() {
        return mCommonDiseases;
    }

    public void setCommonDiseases(String commonDiseases) {
        mCommonDiseases = commonDiseases;
    }

    public String getBadHabits() {
        return mBadHabits;
    }

    public void setBadHabits(String badHabits) {
        mBadHabits = badHabits;
    }

    public String getBestPractice() {
        return mBestPractice;
    }

    public void setBestPractice(String bestPractice) {
        mBestPractice = bestPractice;
    }
}
