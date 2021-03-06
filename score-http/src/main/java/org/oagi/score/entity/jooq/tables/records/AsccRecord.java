/*
 * This file is generated by jOOQ.
 */
package org.oagi.score.entity.jooq.tables.records;


import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record22;
import org.jooq.Row22;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;
import org.oagi.score.entity.jooq.tables.Ascc;


/**
 * An ASCC represents a relationship/association between two ACCs through 
 * an ASCCP. 
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AsccRecord extends UpdatableRecordImpl<AsccRecord> implements Record22<ULong, String, Integer, Integer, Integer, ULong, ULong, String, String, String, Byte, ULong, ULong, ULong, Timestamp, Timestamp, Integer, Integer, Integer, Byte, ULong, ULong> {

    private static final long serialVersionUID = -826529117;

    /**
     * Setter for <code>oagi.ascc.ascc_id</code>. An internal, primary database key of an ASCC.
     */
    public void setAsccId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>oagi.ascc.ascc_id</code>. An internal, primary database key of an ASCC.
     */
    public ULong getAsccId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>oagi.ascc.guid</code>. A globally unique identifier (GUID) of an ASCC. Per OAGIS, a GUID is of the form "oagis-id-" followed by a 32 Hex character sequence.
     */
    public void setGuid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>oagi.ascc.guid</code>. A globally unique identifier (GUID) of an ASCC. Per OAGIS, a GUID is of the form "oagis-id-" followed by a 32 Hex character sequence.
     */
    public String getGuid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>oagi.ascc.cardinality_min</code>. Minimum occurrence of the TO_ASCCP_ID. The valid values are non-negative integer.
     */
    public void setCardinalityMin(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>oagi.ascc.cardinality_min</code>. Minimum occurrence of the TO_ASCCP_ID. The valid values are non-negative integer.
     */
    public Integer getCardinalityMin() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>oagi.ascc.cardinality_max</code>. Maximum cardinality of the TO_ASCCP_ID. A valid value is integer -1 and up. Specifically, -1 means unbounded. 0 means prohibited or not to use.
     */
    public void setCardinalityMax(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>oagi.ascc.cardinality_max</code>. Maximum cardinality of the TO_ASCCP_ID. A valid value is integer -1 and up. Specifically, -1 means unbounded. 0 means prohibited or not to use.
     */
    public Integer getCardinalityMax() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>oagi.ascc.seq_key</code>. This indicates the order of the associations among other siblings. A valid value is positive integer. The SEQ_KEY at the CC side is localized. In other words, if an ACC is based on another ACC, SEQ_KEY of ASCCs or BCCs of the former ACC starts at 1 again. 
     */
    public void setSeqKey(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>oagi.ascc.seq_key</code>. This indicates the order of the associations among other siblings. A valid value is positive integer. The SEQ_KEY at the CC side is localized. In other words, if an ACC is based on another ACC, SEQ_KEY of ASCCs or BCCs of the former ACC starts at 1 again. 
     */
    public Integer getSeqKey() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>oagi.ascc.from_acc_id</code>. FROM_ACC_ID is a foreign key pointing to an ACC record. It is basically pointing to a parent data element (type) of the TO_ASCCP_ID.
     */
    public void setFromAccId(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>oagi.ascc.from_acc_id</code>. FROM_ACC_ID is a foreign key pointing to an ACC record. It is basically pointing to a parent data element (type) of the TO_ASCCP_ID.
     */
    public ULong getFromAccId() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>oagi.ascc.to_asccp_id</code>. TO_ASCCP_ID is a foreign key to an ASCCP table record. It is basically pointing to a child data element of the FROM_ACC_ID. 
     */
    public void setToAsccpId(ULong value) {
        set(6, value);
    }

    /**
     * Getter for <code>oagi.ascc.to_asccp_id</code>. TO_ASCCP_ID is a foreign key to an ASCCP table record. It is basically pointing to a child data element of the FROM_ACC_ID. 
     */
    public ULong getToAsccpId() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>oagi.ascc.den</code>. DEN (dictionary entry name) of the ASCC. This column can be derived from Qualifier and OBJECT_CLASS_TERM of the FROM_ACC_ID and DEN of the TO_ASCCP_ID as Qualifier + "_ " + OBJECT_CLASS_TERM + ". " + DEN. 
     */
    public void setDen(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>oagi.ascc.den</code>. DEN (dictionary entry name) of the ASCC. This column can be derived from Qualifier and OBJECT_CLASS_TERM of the FROM_ACC_ID and DEN of the TO_ASCCP_ID as Qualifier + "_ " + OBJECT_CLASS_TERM + ". " + DEN. 
     */
    public String getDen() {
        return (String) get(7);
    }

    /**
     * Setter for <code>oagi.ascc.definition</code>. This is a documentation or description of the ASCC. Since ASCC is business context independent, this is a business context independent description of the ASCC. Since there are definitions also in the ASCCP (as referenced by the TO_ASCCP_ID column) and the ACC under that ASCCP, definition in the ASCC is a specific description about the relationship between the ACC (as in FROM_ACC_ID) and the ASCCP.
     */
    public void setDefinition(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>oagi.ascc.definition</code>. This is a documentation or description of the ASCC. Since ASCC is business context independent, this is a business context independent description of the ASCC. Since there are definitions also in the ASCCP (as referenced by the TO_ASCCP_ID column) and the ACC under that ASCCP, definition in the ASCC is a specific description about the relationship between the ACC (as in FROM_ACC_ID) and the ASCCP.
     */
    public String getDefinition() {
        return (String) get(8);
    }

    /**
     * Setter for <code>oagi.ascc.definition_source</code>. This is typically a URL identifying the source of the DEFINITION column.
     */
    public void setDefinitionSource(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>oagi.ascc.definition_source</code>. This is typically a URL identifying the source of the DEFINITION column.
     */
    public String getDefinitionSource() {
        return (String) get(9);
    }

    /**
     * Setter for <code>oagi.ascc.is_deprecated</code>. Indicates whether the CC is deprecated and should not be reused (i.e., no new reference to this record should be created).
     */
    public void setIsDeprecated(Byte value) {
        set(10, value);
    }

    /**
     * Getter for <code>oagi.ascc.is_deprecated</code>. Indicates whether the CC is deprecated and should not be reused (i.e., no new reference to this record should be created).
     */
    public Byte getIsDeprecated() {
        return (Byte) get(10);
    }

    /**
     * Setter for <code>oagi.ascc.created_by</code>. A foreign key to the APP_USER table referring to the user who creates the entity.

This column never change between the history and the current record for a given revision. The history record should have the same value as that of its current record.
     */
    public void setCreatedBy(ULong value) {
        set(11, value);
    }

    /**
     * Getter for <code>oagi.ascc.created_by</code>. A foreign key to the APP_USER table referring to the user who creates the entity.

This column never change between the history and the current record for a given revision. The history record should have the same value as that of its current record.
     */
    public ULong getCreatedBy() {
        return (ULong) get(11);
    }

    /**
     * Setter for <code>oagi.ascc.owner_user_id</code>. Foreign key to the APP_USER table. This is the user who owns the entity, is allowed to edit the entity, and who can transfer the ownership to another user.

The ownership can change throughout the history, but undoing shouldn't rollback the ownership. 
     */
    public void setOwnerUserId(ULong value) {
        set(12, value);
    }

    /**
     * Getter for <code>oagi.ascc.owner_user_id</code>. Foreign key to the APP_USER table. This is the user who owns the entity, is allowed to edit the entity, and who can transfer the ownership to another user.

The ownership can change throughout the history, but undoing shouldn't rollback the ownership. 
     */
    public ULong getOwnerUserId() {
        return (ULong) get(12);
    }

    /**
     * Setter for <code>oagi.ascc.last_updated_by</code>. A foreign key to the APP_USER table referring to the last user who has updated the record. 

In the history record, this should always be the user who is editing the entity (perhaps except when the ownership has just been changed).
     */
    public void setLastUpdatedBy(ULong value) {
        set(13, value);
    }

    /**
     * Getter for <code>oagi.ascc.last_updated_by</code>. A foreign key to the APP_USER table referring to the last user who has updated the record. 

In the history record, this should always be the user who is editing the entity (perhaps except when the ownership has just been changed).
     */
    public ULong getLastUpdatedBy() {
        return (ULong) get(13);
    }

    /**
     * Setter for <code>oagi.ascc.creation_timestamp</code>. Timestamp when the revision of the ASCC was created. 

This never change for a revision.
     */
    public void setCreationTimestamp(Timestamp value) {
        set(14, value);
    }

    /**
     * Getter for <code>oagi.ascc.creation_timestamp</code>. Timestamp when the revision of the ASCC was created. 

This never change for a revision.
     */
    public Timestamp getCreationTimestamp() {
        return (Timestamp) get(14);
    }

    /**
     * Setter for <code>oagi.ascc.last_update_timestamp</code>. The timestamp when the record was last updated.

The value of this column in the latest history record should be the same as that of the current record. This column keeps the record of when the change has occurred.
     */
    public void setLastUpdateTimestamp(Timestamp value) {
        set(15, value);
    }

    /**
     * Getter for <code>oagi.ascc.last_update_timestamp</code>. The timestamp when the record was last updated.

The value of this column in the latest history record should be the same as that of the current record. This column keeps the record of when the change has occurred.
     */
    public Timestamp getLastUpdateTimestamp() {
        return (Timestamp) get(15);
    }

    /**
     * Setter for <code>oagi.ascc.state</code>. 1 = EDITING, 2 = CANDIDATE, 3 = PUBLISHED. This is the revision life cycle state of the entity.

State change can't be undone. But the history record can still keep the records of when the state was changed.
     */
    public void setState(Integer value) {
        set(16, value);
    }

    /**
     * Getter for <code>oagi.ascc.state</code>. 1 = EDITING, 2 = CANDIDATE, 3 = PUBLISHED. This is the revision life cycle state of the entity.

State change can't be undone. But the history record can still keep the records of when the state was changed.
     */
    public Integer getState() {
        return (Integer) get(16);
    }

    /**
     * Setter for <code>oagi.ascc.revision_num</code>. REVISION_NUM is an incremental integer. It tracks changes in each component. If a change is made to a component after it has been published, the component receives a new revision number. Revision number can be 0, 1, 2, and so on. A record with zero revision number reflects the current record of the component (the identity of a component in this case is its GUID or the primary key).
     */
    public void setRevisionNum(Integer value) {
        set(17, value);
    }

    /**
     * Getter for <code>oagi.ascc.revision_num</code>. REVISION_NUM is an incremental integer. It tracks changes in each component. If a change is made to a component after it has been published, the component receives a new revision number. Revision number can be 0, 1, 2, and so on. A record with zero revision number reflects the current record of the component (the identity of a component in this case is its GUID or the primary key).
     */
    public Integer getRevisionNum() {
        return (Integer) get(17);
    }

    /**
     * Setter for <code>oagi.ascc.revision_tracking_num</code>. REVISION_TRACKING_NUM supports the ability to undo changes during a revision (life cycle of a revision is from the component's EDITING state to PUBLISHED state). Once the component has transitioned into the PUBLISHED state for its particular revision, all revision tracking records are deleted except the latest one. REVISION_TRACKING_NUM can be 0, 1, 2, and so on. The zero value is assign to the record with REVISION_NUM = 0 as a default.
     */
    public void setRevisionTrackingNum(Integer value) {
        set(18, value);
    }

    /**
     * Getter for <code>oagi.ascc.revision_tracking_num</code>. REVISION_TRACKING_NUM supports the ability to undo changes during a revision (life cycle of a revision is from the component's EDITING state to PUBLISHED state). Once the component has transitioned into the PUBLISHED state for its particular revision, all revision tracking records are deleted except the latest one. REVISION_TRACKING_NUM can be 0, 1, 2, and so on. The zero value is assign to the record with REVISION_NUM = 0 as a default.
     */
    public Integer getRevisionTrackingNum() {
        return (Integer) get(18);
    }

    /**
     * Setter for <code>oagi.ascc.revision_action</code>. This indicates the action associated with the record. The action can be 1 = INSERT, 2 = UPDATE, and 3 = DELETE. This column is null for the current record.
     */
    public void setRevisionAction(Byte value) {
        set(19, value);
    }

    /**
     * Getter for <code>oagi.ascc.revision_action</code>. This indicates the action associated with the record. The action can be 1 = INSERT, 2 = UPDATE, and 3 = DELETE. This column is null for the current record.
     */
    public Byte getRevisionAction() {
        return (Byte) get(19);
    }

    /**
     * Setter for <code>oagi.ascc.release_id</code>. RELEASE_ID is an incremental integer. It is an unformatted counterpart of the RELEASE_NUMBER in the RELEASE table. RELEASE_ID can be 1, 2, 3, and so on. RELEASE_ID indicates the release point when a particular component revision is released. A component revision is only released once and assumed to be included in the subsequent releases unless it has been deleted (as indicated by the REVISION_ACTION column).

Not all component revisions have an associated RELEASE_ID because some revisions may never be released.

Unpublished components cannot be released.

This column is NULL for the current record.
     */
    public void setReleaseId(ULong value) {
        set(20, value);
    }

    /**
     * Getter for <code>oagi.ascc.release_id</code>. RELEASE_ID is an incremental integer. It is an unformatted counterpart of the RELEASE_NUMBER in the RELEASE table. RELEASE_ID can be 1, 2, 3, and so on. RELEASE_ID indicates the release point when a particular component revision is released. A component revision is only released once and assumed to be included in the subsequent releases unless it has been deleted (as indicated by the REVISION_ACTION column).

Not all component revisions have an associated RELEASE_ID because some revisions may never be released.

Unpublished components cannot be released.

This column is NULL for the current record.
     */
    public ULong getReleaseId() {
        return (ULong) get(20);
    }

    /**
     * Setter for <code>oagi.ascc.current_ascc_id</code>. This is a self-foreign-key. It points from a revised record to the current record. The current record is denoted by the the record whose REVISION_NUM is 0. Revised records (a.k.a. history records) and their current record must have the same GUID.

It is noted that although this is a foreign key by definition, we don't specify a foreign key in the data model. This is because when an entity is deleted the current record won't exist anymore.

The value of this column for the current record should be left NULL.
     */
    public void setCurrentAsccId(ULong value) {
        set(21, value);
    }

    /**
     * Getter for <code>oagi.ascc.current_ascc_id</code>. This is a self-foreign-key. It points from a revised record to the current record. The current record is denoted by the the record whose REVISION_NUM is 0. Revised records (a.k.a. history records) and their current record must have the same GUID.

It is noted that although this is a foreign key by definition, we don't specify a foreign key in the data model. This is because when an entity is deleted the current record won't exist anymore.

The value of this column for the current record should be left NULL.
     */
    public ULong getCurrentAsccId() {
        return (ULong) get(21);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record22 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row22<ULong, String, Integer, Integer, Integer, ULong, ULong, String, String, String, Byte, ULong, ULong, ULong, Timestamp, Timestamp, Integer, Integer, Integer, Byte, ULong, ULong> fieldsRow() {
        return (Row22) super.fieldsRow();
    }

    @Override
    public Row22<ULong, String, Integer, Integer, Integer, ULong, ULong, String, String, String, Byte, ULong, ULong, ULong, Timestamp, Timestamp, Integer, Integer, Integer, Byte, ULong, ULong> valuesRow() {
        return (Row22) super.valuesRow();
    }

    @Override
    public Field<ULong> field1() {
        return Ascc.ASCC.ASCC_ID;
    }

    @Override
    public Field<String> field2() {
        return Ascc.ASCC.GUID;
    }

    @Override
    public Field<Integer> field3() {
        return Ascc.ASCC.CARDINALITY_MIN;
    }

    @Override
    public Field<Integer> field4() {
        return Ascc.ASCC.CARDINALITY_MAX;
    }

    @Override
    public Field<Integer> field5() {
        return Ascc.ASCC.SEQ_KEY;
    }

    @Override
    public Field<ULong> field6() {
        return Ascc.ASCC.FROM_ACC_ID;
    }

    @Override
    public Field<ULong> field7() {
        return Ascc.ASCC.TO_ASCCP_ID;
    }

    @Override
    public Field<String> field8() {
        return Ascc.ASCC.DEN;
    }

    @Override
    public Field<String> field9() {
        return Ascc.ASCC.DEFINITION;
    }

    @Override
    public Field<String> field10() {
        return Ascc.ASCC.DEFINITION_SOURCE;
    }

    @Override
    public Field<Byte> field11() {
        return Ascc.ASCC.IS_DEPRECATED;
    }

    @Override
    public Field<ULong> field12() {
        return Ascc.ASCC.CREATED_BY;
    }

    @Override
    public Field<ULong> field13() {
        return Ascc.ASCC.OWNER_USER_ID;
    }

    @Override
    public Field<ULong> field14() {
        return Ascc.ASCC.LAST_UPDATED_BY;
    }

    @Override
    public Field<Timestamp> field15() {
        return Ascc.ASCC.CREATION_TIMESTAMP;
    }

    @Override
    public Field<Timestamp> field16() {
        return Ascc.ASCC.LAST_UPDATE_TIMESTAMP;
    }

    @Override
    public Field<Integer> field17() {
        return Ascc.ASCC.STATE;
    }

    @Override
    public Field<Integer> field18() {
        return Ascc.ASCC.REVISION_NUM;
    }

    @Override
    public Field<Integer> field19() {
        return Ascc.ASCC.REVISION_TRACKING_NUM;
    }

    @Override
    public Field<Byte> field20() {
        return Ascc.ASCC.REVISION_ACTION;
    }

    @Override
    public Field<ULong> field21() {
        return Ascc.ASCC.RELEASE_ID;
    }

    @Override
    public Field<ULong> field22() {
        return Ascc.ASCC.CURRENT_ASCC_ID;
    }

    @Override
    public ULong component1() {
        return getAsccId();
    }

    @Override
    public String component2() {
        return getGuid();
    }

    @Override
    public Integer component3() {
        return getCardinalityMin();
    }

    @Override
    public Integer component4() {
        return getCardinalityMax();
    }

    @Override
    public Integer component5() {
        return getSeqKey();
    }

    @Override
    public ULong component6() {
        return getFromAccId();
    }

    @Override
    public ULong component7() {
        return getToAsccpId();
    }

    @Override
    public String component8() {
        return getDen();
    }

    @Override
    public String component9() {
        return getDefinition();
    }

    @Override
    public String component10() {
        return getDefinitionSource();
    }

    @Override
    public Byte component11() {
        return getIsDeprecated();
    }

    @Override
    public ULong component12() {
        return getCreatedBy();
    }

    @Override
    public ULong component13() {
        return getOwnerUserId();
    }

    @Override
    public ULong component14() {
        return getLastUpdatedBy();
    }

    @Override
    public Timestamp component15() {
        return getCreationTimestamp();
    }

    @Override
    public Timestamp component16() {
        return getLastUpdateTimestamp();
    }

    @Override
    public Integer component17() {
        return getState();
    }

    @Override
    public Integer component18() {
        return getRevisionNum();
    }

    @Override
    public Integer component19() {
        return getRevisionTrackingNum();
    }

    @Override
    public Byte component20() {
        return getRevisionAction();
    }

    @Override
    public ULong component21() {
        return getReleaseId();
    }

    @Override
    public ULong component22() {
        return getCurrentAsccId();
    }

    @Override
    public ULong value1() {
        return getAsccId();
    }

    @Override
    public String value2() {
        return getGuid();
    }

    @Override
    public Integer value3() {
        return getCardinalityMin();
    }

    @Override
    public Integer value4() {
        return getCardinalityMax();
    }

    @Override
    public Integer value5() {
        return getSeqKey();
    }

    @Override
    public ULong value6() {
        return getFromAccId();
    }

    @Override
    public ULong value7() {
        return getToAsccpId();
    }

    @Override
    public String value8() {
        return getDen();
    }

    @Override
    public String value9() {
        return getDefinition();
    }

    @Override
    public String value10() {
        return getDefinitionSource();
    }

    @Override
    public Byte value11() {
        return getIsDeprecated();
    }

    @Override
    public ULong value12() {
        return getCreatedBy();
    }

    @Override
    public ULong value13() {
        return getOwnerUserId();
    }

    @Override
    public ULong value14() {
        return getLastUpdatedBy();
    }

    @Override
    public Timestamp value15() {
        return getCreationTimestamp();
    }

    @Override
    public Timestamp value16() {
        return getLastUpdateTimestamp();
    }

    @Override
    public Integer value17() {
        return getState();
    }

    @Override
    public Integer value18() {
        return getRevisionNum();
    }

    @Override
    public Integer value19() {
        return getRevisionTrackingNum();
    }

    @Override
    public Byte value20() {
        return getRevisionAction();
    }

    @Override
    public ULong value21() {
        return getReleaseId();
    }

    @Override
    public ULong value22() {
        return getCurrentAsccId();
    }

    @Override
    public AsccRecord value1(ULong value) {
        setAsccId(value);
        return this;
    }

    @Override
    public AsccRecord value2(String value) {
        setGuid(value);
        return this;
    }

    @Override
    public AsccRecord value3(Integer value) {
        setCardinalityMin(value);
        return this;
    }

    @Override
    public AsccRecord value4(Integer value) {
        setCardinalityMax(value);
        return this;
    }

    @Override
    public AsccRecord value5(Integer value) {
        setSeqKey(value);
        return this;
    }

    @Override
    public AsccRecord value6(ULong value) {
        setFromAccId(value);
        return this;
    }

    @Override
    public AsccRecord value7(ULong value) {
        setToAsccpId(value);
        return this;
    }

    @Override
    public AsccRecord value8(String value) {
        setDen(value);
        return this;
    }

    @Override
    public AsccRecord value9(String value) {
        setDefinition(value);
        return this;
    }

    @Override
    public AsccRecord value10(String value) {
        setDefinitionSource(value);
        return this;
    }

    @Override
    public AsccRecord value11(Byte value) {
        setIsDeprecated(value);
        return this;
    }

    @Override
    public AsccRecord value12(ULong value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public AsccRecord value13(ULong value) {
        setOwnerUserId(value);
        return this;
    }

    @Override
    public AsccRecord value14(ULong value) {
        setLastUpdatedBy(value);
        return this;
    }

    @Override
    public AsccRecord value15(Timestamp value) {
        setCreationTimestamp(value);
        return this;
    }

    @Override
    public AsccRecord value16(Timestamp value) {
        setLastUpdateTimestamp(value);
        return this;
    }

    @Override
    public AsccRecord value17(Integer value) {
        setState(value);
        return this;
    }

    @Override
    public AsccRecord value18(Integer value) {
        setRevisionNum(value);
        return this;
    }

    @Override
    public AsccRecord value19(Integer value) {
        setRevisionTrackingNum(value);
        return this;
    }

    @Override
    public AsccRecord value20(Byte value) {
        setRevisionAction(value);
        return this;
    }

    @Override
    public AsccRecord value21(ULong value) {
        setReleaseId(value);
        return this;
    }

    @Override
    public AsccRecord value22(ULong value) {
        setCurrentAsccId(value);
        return this;
    }

    @Override
    public AsccRecord values(ULong value1, String value2, Integer value3, Integer value4, Integer value5, ULong value6, ULong value7, String value8, String value9, String value10, Byte value11, ULong value12, ULong value13, ULong value14, Timestamp value15, Timestamp value16, Integer value17, Integer value18, Integer value19, Byte value20, ULong value21, ULong value22) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        value21(value21);
        value22(value22);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AsccRecord
     */
    public AsccRecord() {
        super(Ascc.ASCC);
    }

    /**
     * Create a detached, initialised AsccRecord
     */
    public AsccRecord(ULong asccId, String guid, Integer cardinalityMin, Integer cardinalityMax, Integer seqKey, ULong fromAccId, ULong toAsccpId, String den, String definition, String definitionSource, Byte isDeprecated, ULong createdBy, ULong ownerUserId, ULong lastUpdatedBy, Timestamp creationTimestamp, Timestamp lastUpdateTimestamp, Integer state, Integer revisionNum, Integer revisionTrackingNum, Byte revisionAction, ULong releaseId, ULong currentAsccId) {
        super(Ascc.ASCC);

        set(0, asccId);
        set(1, guid);
        set(2, cardinalityMin);
        set(3, cardinalityMax);
        set(4, seqKey);
        set(5, fromAccId);
        set(6, toAsccpId);
        set(7, den);
        set(8, definition);
        set(9, definitionSource);
        set(10, isDeprecated);
        set(11, createdBy);
        set(12, ownerUserId);
        set(13, lastUpdatedBy);
        set(14, creationTimestamp);
        set(15, lastUpdateTimestamp);
        set(16, state);
        set(17, revisionNum);
        set(18, revisionTrackingNum);
        set(19, revisionAction);
        set(20, releaseId);
        set(21, currentAsccId);
    }
}
