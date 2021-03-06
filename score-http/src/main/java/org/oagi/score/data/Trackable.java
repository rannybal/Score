package org.oagi.score.data;

import java.io.Serializable;

public interface Trackable extends Serializable {

    long getId();

    Long getCurrentId();

    Long getReleaseId();

    int getRevisionNum();

    int getRevisionTrackingNum();

}
