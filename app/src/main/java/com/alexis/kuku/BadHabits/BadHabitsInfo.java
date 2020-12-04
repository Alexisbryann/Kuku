package com.alexis.kuku.BadHabits;

import android.os.Parcel;
import android.os.Parcelable;

public class BadHabitsInfo implements Parcelable {
    private String Image;
    private String Habit;
    private String Description;
    private String Causes;
    private String Prevention;

    public BadHabitsInfo(String image, String habit, String description, String causes, String prevention) {
        Image = image;
        Habit = habit;
        Description = description;
        Causes = causes;
        Prevention = prevention;
    }
    protected BadHabitsInfo(Parcel in) {
        Image = in.readString();
        Habit = in.readString();
        Causes = in.readString();
        Description = in.readString();
        Prevention = in.readString();
    }

    public static final Parcelable.Creator<BadHabitsInfo> CREATOR = new Parcelable.Creator<BadHabitsInfo>() {
        @Override
        public BadHabitsInfo createFromParcel(Parcel in) {
            return new BadHabitsInfo(in);
        }

        @Override
        public BadHabitsInfo[] newArray(int size) {
            return new BadHabitsInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Image);
        parcel.writeString(Habit);
        parcel.writeString(Causes);
        parcel.writeString(Prevention);
        parcel.writeString(Description);
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getHabit() {
        return Habit;
    }

    public void setHabit(String habit) {
        Habit = habit;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCauses() {
        return Causes;
    }

    public void setCauses(String causes) {
        Causes = causes;
    }

    public String getPrevention() {
        return Prevention;
    }

    public void setPrevention(String prevention) {
        Prevention = prevention;
    }
}
