package com.exmaple.bulma.model;

import com.prashant.bulma.BulmaBuilder;

@BulmaBuilder
public class Version {
    /**
     * iosLatest : 1
     * androidLatest : 2
     * iosOptionalUpdate : true
     * androidOptionalUpdate : true
     */
    private int androidLatest;
    private boolean androidOptionalUpdate;

    public int getAndroidLatest() {
        return androidLatest;
    }

    public void setAndroidLatest(int androidLatest) {
        this.androidLatest = androidLatest;
    }

    public boolean isOptionalUpdate() {
        return androidOptionalUpdate;
    }

    public void setOptionalUpdate(boolean androidOptionalUpdate) {
        this.androidOptionalUpdate = androidOptionalUpdate;
    }

    public boolean shouldForceUpdate(int appVersion) {
        return appVersion < getAndroidLatest();
    }

    @Override
    public String toString() {
        return "Version{" +
                "androidLatest=" + androidLatest +
                ", androidOptionalUpdate=" + androidOptionalUpdate +
                '}';
    }
}
