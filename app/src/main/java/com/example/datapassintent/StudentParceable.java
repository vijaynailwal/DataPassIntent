package com.example.datapassintent;

import android.os.Parcel;
import android.os.Parcelable;

public class StudentParceable implements Parcelable {

    private Integer age;
    private String name;
    private String className;

    protected StudentParceable(Parcel in) {
        age = in.readInt();
        name = in.readString();
        className = in.readString();
    }

    public StudentParceable(Integer age, String name, String className) {
        this.age = age;
        this.name = name;
        this.name = className;
    }


    public static final Creator<StudentParceable> CREATOR = new Creator<StudentParceable>() {
        @Override
        public StudentParceable createFromParcel(Parcel in) {
            return new StudentParceable(in);
        }

        @Override
        public StudentParceable[] newArray(int size) {
            return new StudentParceable[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    public static Creator<StudentParceable> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(age);
        parcel.writeString(name);
        parcel.writeString(className);
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
