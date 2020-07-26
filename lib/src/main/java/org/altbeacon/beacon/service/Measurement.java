package org.altbeacon.beacon.service;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Measurement implements Comparable<Measurement>, Parcelable, Serializable {
    public Integer rssi;
    public long timestamp;

    protected Measurement() {

    }

    protected Measurement(Parcel in) {
        rssi = in.readInt();
        timestamp = in.readLong();
    }

    public static final Creator<Measurement> CREATOR = new Creator<Measurement>() {
        @Override
        public Measurement createFromParcel(Parcel in) {
            return new Measurement(in);
        }

        @Override
        public Measurement[] newArray(int size) {
            return new Measurement[size];
        }
    };

    @Override
    public int compareTo(Measurement arg0) {
        return rssi.compareTo(arg0.rssi);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rssi);
        dest.writeLong(timestamp);
    }
}
