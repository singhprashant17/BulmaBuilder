package com.exmaple.bulma.model;

import com.prashant.java.bulmabuilder.BulmaBuilder;

@BulmaBuilder
public class AppVersionResponse {

    /**
     * version : {"iosLatest":1,"androidLatest":2,"iosOptionalUpdate":true,
     * "androidOptionalUpdate":true}
     * status : ok
     */

    private Version version;
    private String status;

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AppVersionResponse{" +
                "version=" + version +
                ", status='" + status + '\'' +
                '}';
    }

}
