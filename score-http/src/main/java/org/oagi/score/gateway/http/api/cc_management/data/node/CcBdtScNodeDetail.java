package org.oagi.score.gateway.http.api.cc_management.data.node;

import lombok.Data;

@Data
public class CcBdtScNodeDetail implements CcNodeDetail {

    private String type = "bdt_sc";

    private long bdtScId;
    private String guid;
    private String den;
    private int cardinalityMin;
    private int cardinalityMax;
    private String definition;
    private String definitionSource;
    private String defaultValue;
    private String fixedValue;
}
