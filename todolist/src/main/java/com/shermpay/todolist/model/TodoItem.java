package com.shermpay.todolist.model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author shermpay on 3/12/14.
 */
public class TodoItem implements Comparable<TodoItem>, Parcelable {
    private String mName;
    private int mPriority;

    public TodoItem(String mName) {
        this.mName = mName;
    }

    public TodoItem(String mName, int mPriority) {
        this.mName = mName;
        this.mPriority = mPriority;
    }

    public void setName(String newName) {
        this.mName = newName;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        if (priority < 0) {
            throw new IllegalArgumentException("Priority < 0. Priority be >= 0");
        } else {
            this.mPriority = priority;
        }
    }

    @Override
    public String toString() {
        return mName;
    }

    @Override
    public int compareTo(TodoItem other) {
        if (this.mPriority != other.mPriority) {
            return this.mPriority - other.mPriority;
        } else {
            return this.mName.compareTo(other.mName);
        }
    }

    public TodoItem(Parcel in) {
        mName = in.readString();
        mPriority = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeInt(mPriority);
    }

    public static final Creator<TodoItem> CREATOR = new Creator<TodoItem>() {
        @Override
        public TodoItem createFromParcel(Parcel parcel) {
            return new TodoItem(parcel);
        }

        @Override
        public TodoItem[] newArray(int size) {
            return new TodoItem[size];
        }
    };
}

