/*
 * This file is generated by jOOQ.
 */
package org.oagi.score.entity.jooq.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;
import org.oagi.score.entity.jooq.Indexes;
import org.oagi.score.entity.jooq.Keys;
import org.oagi.score.entity.jooq.Oagi;
import org.oagi.score.entity.jooq.tables.records.BccRecord;


/**
 * A BCC represents a relationship/association between an ACC and a BCCP. 
 * It creates a data element for an ACC. 
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bcc extends TableImpl<BccRecord> {

    private static final long serialVersionUID = 1989684504;

    /**
     * The reference instance of <code>oagi.bcc</code>
     */
    public static final Bcc BCC = new Bcc();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BccRecord> getRecordType() {
        return BccRecord.class;
    }

    /**
     * The column <code>oagi.bcc.bcc_id</code>. A internal, primary database key of an BCC.
     */
    public final TableField<BccRecord, ULong> BCC_ID = createField(DSL.name("bcc_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "A internal, primary database key of an BCC.");

    /**
     * The column <code>oagi.bcc.guid</code>. A globally unique identifier (GUID) of BCC. Per OAGIS, a GUID is of the form "oagis-id-" followed by a 32 Hex character sequence.',
     */
    public final TableField<BccRecord, String> GUID = createField(DSL.name("guid"), org.jooq.impl.SQLDataType.VARCHAR(41).nullable(false), this, "A globally unique identifier (GUID) of BCC. Per OAGIS, a GUID is of the form \"oagis-id-\" followed by a 32 Hex character sequence.',");

    /**
     * The column <code>oagi.bcc.cardinality_min</code>. Minimum cardinality of the TO_BCCP_ID. The valid values are non-negative integer.
     */
    public final TableField<BccRecord, Integer> CARDINALITY_MIN = createField(DSL.name("cardinality_min"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Minimum cardinality of the TO_BCCP_ID. The valid values are non-negative integer.");

    /**
     * The column <code>oagi.bcc.cardinality_max</code>. Maximum cardinality of the TO_BCCP_ID. The valid values are integer -1 and up. Specifically, -1 means unbounded. 0 means prohibited or not to use.',
     */
    public final TableField<BccRecord, Integer> CARDINALITY_MAX = createField(DSL.name("cardinality_max"), org.jooq.impl.SQLDataType.INTEGER, this, "Maximum cardinality of the TO_BCCP_ID. The valid values are integer -1 and up. Specifically, -1 means unbounded. 0 means prohibited or not to use.',");

    /**
     * The column <code>oagi.bcc.to_bccp_id</code>. TO_BCCP_ID is a foreign key to an BCCP table record. It is basically pointing to a child data element of the FROM_ACC_ID. 

Note that for the BCC history records, this column always points to the BCCP_ID of the current record of a BCCP.',
     */
    public final TableField<BccRecord, ULong> TO_BCCP_ID = createField(DSL.name("to_bccp_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "TO_BCCP_ID is a foreign key to an BCCP table record. It is basically pointing to a child data element of the FROM_ACC_ID. \n\nNote that for the BCC history records, this column always points to the BCCP_ID of the current record of a BCCP.',");

    /**
     * The column <code>oagi.bcc.from_acc_id</code>. FROM_ACC_ID is a foreign key pointing to an ACC record. It is basically pointing to a parent data element (type) of the TO_BCCP_ID. 

Note that for the BCC history records, this column always points to the ACC_ID of the current record of an ACC.
     */
    public final TableField<BccRecord, ULong> FROM_ACC_ID = createField(DSL.name("from_acc_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "FROM_ACC_ID is a foreign key pointing to an ACC record. It is basically pointing to a parent data element (type) of the TO_BCCP_ID. \n\nNote that for the BCC history records, this column always points to the ACC_ID of the current record of an ACC.");

    /**
     * The column <code>oagi.bcc.seq_key</code>. This indicates the order of the associations among other siblings. A valid value is positive integer. The SEQ_KEY at the CC side is localized. In other words, if an ACC is based on another ACC, SEQ_KEY of ASCCs or BCCs of the former ACC starts at 1 again. 
     */
    public final TableField<BccRecord, Integer> SEQ_KEY = createField(DSL.name("seq_key"), org.jooq.impl.SQLDataType.INTEGER, this, "This indicates the order of the associations among other siblings. A valid value is positive integer. The SEQ_KEY at the CC side is localized. In other words, if an ACC is based on another ACC, SEQ_KEY of ASCCs or BCCs of the former ACC starts at 1 again. ");

    /**
     * The column <code>oagi.bcc.entity_type</code>. This is a code list: 0 = ATTRIBUTE and 1 = ELEMENT. An expression generator may or may not use this information. This column is necessary because some of the BCCs are xsd:attribute and some are xsd:element in the OAGIS 10.x. 
     */
    public final TableField<BccRecord, Integer> ENTITY_TYPE = createField(DSL.name("entity_type"), org.jooq.impl.SQLDataType.INTEGER, this, "This is a code list: 0 = ATTRIBUTE and 1 = ELEMENT. An expression generator may or may not use this information. This column is necessary because some of the BCCs are xsd:attribute and some are xsd:element in the OAGIS 10.x. ");

    /**
     * The column <code>oagi.bcc.den</code>. DEN (dictionary entry name) of the BCC. This column can be derived from QUALIFIER and OBJECT_CLASS_TERM of the FROM_ACC_ID and DEN of the TO_BCCP_ID as QUALIFIER + "_ " + OBJECT_CLASS_TERM + ". " + DEN. 
     */
    public final TableField<BccRecord, String> DEN = createField(DSL.name("den"), org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "DEN (dictionary entry name) of the BCC. This column can be derived from QUALIFIER and OBJECT_CLASS_TERM of the FROM_ACC_ID and DEN of the TO_BCCP_ID as QUALIFIER + \"_ \" + OBJECT_CLASS_TERM + \". \" + DEN. ");

    /**
     * The column <code>oagi.bcc.definition</code>. This is a documentation or description of the BCC. Since BCC is business context independent, this is a business context independent description of the BCC. Since there are definitions also in the BCCP (as referenced by TO_BCCP_ID column) and the BDT under that BCCP, the definition in the BCC is a specific description about the relationship between the ACC (as in FROM_ACC_ID) and the BCCP.
     */
    public final TableField<BccRecord, String> DEFINITION = createField(DSL.name("definition"), org.jooq.impl.SQLDataType.CLOB, this, "This is a documentation or description of the BCC. Since BCC is business context independent, this is a business context independent description of the BCC. Since there are definitions also in the BCCP (as referenced by TO_BCCP_ID column) and the BDT under that BCCP, the definition in the BCC is a specific description about the relationship between the ACC (as in FROM_ACC_ID) and the BCCP.");

    /**
     * The column <code>oagi.bcc.definition_source</code>. This is typically a URL identifying the source of the DEFINITION column.
     */
    public final TableField<BccRecord, String> DEFINITION_SOURCE = createField(DSL.name("definition_source"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "This is typically a URL identifying the source of the DEFINITION column.");

    /**
     * The column <code>oagi.bcc.created_by</code>. Foreign key to the APP_USER table referring to the user who creates the entity.

This column never change between the history and the current record. The history record should have the same value as that of its current record.
     */
    public final TableField<BccRecord, ULong> CREATED_BY = createField(DSL.name("created_by"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Foreign key to the APP_USER table referring to the user who creates the entity.\n\nThis column never change between the history and the current record. The history record should have the same value as that of its current record.");

    /**
     * The column <code>oagi.bcc.owner_user_id</code>. Foreign key to the APP_USER table. This is the user who owns the entity, is allowed to edit the entity, and who can transfer the ownership to another user.

The ownership can change throughout the history, but undoing shouldn't rollback the ownership.
     */
    public final TableField<BccRecord, ULong> OWNER_USER_ID = createField(DSL.name("owner_user_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Foreign key to the APP_USER table. This is the user who owns the entity, is allowed to edit the entity, and who can transfer the ownership to another user.\n\nThe ownership can change throughout the history, but undoing shouldn't rollback the ownership.");

    /**
     * The column <code>oagi.bcc.last_updated_by</code>. Foreign key to the APP_USER table referring to the last user who has updated the record. 

In the history record, this should always be the user who is editing the entity (perhaps except when the ownership has just been changed).
     */
    public final TableField<BccRecord, ULong> LAST_UPDATED_BY = createField(DSL.name("last_updated_by"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Foreign key to the APP_USER table referring to the last user who has updated the record. \n\nIn the history record, this should always be the user who is editing the entity (perhaps except when the ownership has just been changed).");

    /**
     * The column <code>oagi.bcc.creation_timestamp</code>. Timestamp when the revision of the BCC was created. 

This never change for a revision.
     */
    public final TableField<BccRecord, Timestamp> CREATION_TIMESTAMP = createField(DSL.name("creation_timestamp"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "Timestamp when the revision of the BCC was created. \n\nThis never change for a revision.");

    /**
     * The column <code>oagi.bcc.last_update_timestamp</code>. The timestamp when the record was last updated.

The value of this column in the latest history record should be the same as that of the current record. This column keeps the record of when the change has occurred.
     */
    public final TableField<BccRecord, Timestamp> LAST_UPDATE_TIMESTAMP = createField(DSL.name("last_update_timestamp"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "The timestamp when the record was last updated.\n\nThe value of this column in the latest history record should be the same as that of the current record. This column keeps the record of when the change has occurred.");

    /**
     * The column <code>oagi.bcc.state</code>. 1 = EDITING, 2 = CANDIDATE, 3 = PUBLISHED. This is the revision life cycle state of the entity.

State change can't be undone. But the history record can still keep the records of when the state was changed.
     */
    public final TableField<BccRecord, Integer> STATE = createField(DSL.name("state"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "1 = EDITING, 2 = CANDIDATE, 3 = PUBLISHED. This is the revision life cycle state of the entity.\n\nState change can't be undone. But the history record can still keep the records of when the state was changed.");

    /**
     * The column <code>oagi.bcc.revision_num</code>. REVISION_NUM is an incremental integer. It tracks changes in each component. If a change is made to a component after it has been published, the component receives a new revision number. Revision number can be 0, 1, 2, and so on. A record with zero revision number reflects the current record of the component (the identity of a component in this case is its GUID or the primary key).
     */
    public final TableField<BccRecord, Integer> REVISION_NUM = createField(DSL.name("revision_num"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "REVISION_NUM is an incremental integer. It tracks changes in each component. If a change is made to a component after it has been published, the component receives a new revision number. Revision number can be 0, 1, 2, and so on. A record with zero revision number reflects the current record of the component (the identity of a component in this case is its GUID or the primary key).");

    /**
     * The column <code>oagi.bcc.revision_tracking_num</code>. REVISION_TRACKING_NUM supports the ability to undo changes during a revision (life cycle of a revision is from the component's EDITING state to PUBLISHED state). Once the component has transitioned into the PUBLISHED state for its particular revision, all revision tracking records are deleted except the latest one. REVISION_TRACKING_NUM can be 0, 1, 2, and so on. The zero value is assign to the record with REVISION_NUM = 0 as a default.
     */
    public final TableField<BccRecord, Integer> REVISION_TRACKING_NUM = createField(DSL.name("revision_tracking_num"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "REVISION_TRACKING_NUM supports the ability to undo changes during a revision (life cycle of a revision is from the component's EDITING state to PUBLISHED state). Once the component has transitioned into the PUBLISHED state for its particular revision, all revision tracking records are deleted except the latest one. REVISION_TRACKING_NUM can be 0, 1, 2, and so on. The zero value is assign to the record with REVISION_NUM = 0 as a default.");

    /**
     * The column <code>oagi.bcc.revision_action</code>. This indicates the action associated with the record. The action can be 1 = INSERT, 2 = UPDATE, and 3 = DELETE. This column is null for the current record.
     */
    public final TableField<BccRecord, Byte> REVISION_ACTION = createField(DSL.name("revision_action"), org.jooq.impl.SQLDataType.TINYINT.defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.TINYINT)), this, "This indicates the action associated with the record. The action can be 1 = INSERT, 2 = UPDATE, and 3 = DELETE. This column is null for the current record.");

    /**
     * The column <code>oagi.bcc.release_id</code>. RELEASE_ID is an incremental integer. It is an unformatted counterpart of the RELEASE_NUMBER in the RELEASE table. RELEASE_ID can be 1, 2, 3, and so on. RELEASE_ID indicates the release point when a particular component revision is released. A component revision is only released once and assumed to be included in the subsequent releases unless it has been deleted (as indicated by the REVISION_ACTION column).

Not all component revisions have an associated RELEASE_ID because some revisions may never be released.

Unpublished components cannot be released.

This column is NULLl for the current record.
     */
    public final TableField<BccRecord, ULong> RELEASE_ID = createField(DSL.name("release_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "RELEASE_ID is an incremental integer. It is an unformatted counterpart of the RELEASE_NUMBER in the RELEASE table. RELEASE_ID can be 1, 2, 3, and so on. RELEASE_ID indicates the release point when a particular component revision is released. A component revision is only released once and assumed to be included in the subsequent releases unless it has been deleted (as indicated by the REVISION_ACTION column).\n\nNot all component revisions have an associated RELEASE_ID because some revisions may never be released.\n\nUnpublished components cannot be released.\n\nThis column is NULLl for the current record.");

    /**
     * The column <code>oagi.bcc.current_bcc_id</code>. This is a self-foreign-key. It points from a revised record to the current record. The current record is denoted by the record whose REVISION_NUM is 0. Revised records (a.k.a. history records) and their current record must have the same GUID.

It is noted that although this is a foreign key by definition, we don't specify a foreign key in the data model. This is because when an entity is deleted the current record won't exist anymore.

The value of this column for the current record should be left NULL.
     */
    public final TableField<BccRecord, ULong> CURRENT_BCC_ID = createField(DSL.name("current_bcc_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "This is a self-foreign-key. It points from a revised record to the current record. The current record is denoted by the record whose REVISION_NUM is 0. Revised records (a.k.a. history records) and their current record must have the same GUID.\n\nIt is noted that although this is a foreign key by definition, we don't specify a foreign key in the data model. This is because when an entity is deleted the current record won't exist anymore.\n\nThe value of this column for the current record should be left NULL.");

    /**
     * The column <code>oagi.bcc.is_deprecated</code>. Indicates whether the CC is deprecated and should not be reused (i.e., no new reference to this record should be created).
     */
    public final TableField<BccRecord, Byte> IS_DEPRECATED = createField(DSL.name("is_deprecated"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "Indicates whether the CC is deprecated and should not be reused (i.e., no new reference to this record should be created).");

    /**
     * The column <code>oagi.bcc.is_nillable</code>. Indicate whether the field can have a NULL This is corresponding to the nillable flag in the XML schema.
     */
    public final TableField<BccRecord, Byte> IS_NILLABLE = createField(DSL.name("is_nillable"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "Indicate whether the field can have a NULL This is corresponding to the nillable flag in the XML schema.");

    /**
     * The column <code>oagi.bcc.default_value</code>. This set the default value at the association level. 
     */
    public final TableField<BccRecord, String> DEFAULT_VALUE = createField(DSL.name("default_value"), org.jooq.impl.SQLDataType.CLOB, this, "This set the default value at the association level. ");

    /**
     * The column <code>oagi.bcc.fixed_value</code>. This column captures the fixed value constraint. Default and fixed value constraints cannot be used at the same time.
     */
    public final TableField<BccRecord, String> FIXED_VALUE = createField(DSL.name("fixed_value"), org.jooq.impl.SQLDataType.CLOB, this, "This column captures the fixed value constraint. Default and fixed value constraints cannot be used at the same time.");

    /**
     * Create a <code>oagi.bcc</code> table reference
     */
    public Bcc() {
        this(DSL.name("bcc"), null);
    }

    /**
     * Create an aliased <code>oagi.bcc</code> table reference
     */
    public Bcc(String alias) {
        this(DSL.name(alias), BCC);
    }

    /**
     * Create an aliased <code>oagi.bcc</code> table reference
     */
    public Bcc(Name alias) {
        this(alias, BCC);
    }

    private Bcc(Name alias, Table<BccRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bcc(Name alias, Table<BccRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("A BCC represents a relationship/association between an ACC and a BCCP. It creates a data element for an ACC. "));
    }

    public <O extends Record> Bcc(Table<O> child, ForeignKey<O, BccRecord> key) {
        super(child, key, BCC);
    }

    @Override
    public Schema getSchema() {
        return Oagi.OAGI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BCC_BCC_CREATED_BY_FK, Indexes.BCC_BCC_CURRENT_BCC_ID_FK, Indexes.BCC_BCC_FROM_ACC_ID_FK, Indexes.BCC_BCC_LAST_UPDATED_BY_FK, Indexes.BCC_BCC_OWNER_USER_ID_FK, Indexes.BCC_BCC_RELEASE_ID_FK, Indexes.BCC_BCC_TO_BCCP_ID_FK, Indexes.BCC_PRIMARY);
    }

    @Override
    public Identity<BccRecord, ULong> getIdentity() {
        return Keys.IDENTITY_BCC;
    }

    @Override
    public UniqueKey<BccRecord> getPrimaryKey() {
        return Keys.KEY_BCC_PRIMARY;
    }

    @Override
    public List<UniqueKey<BccRecord>> getKeys() {
        return Arrays.<UniqueKey<BccRecord>>asList(Keys.KEY_BCC_PRIMARY);
    }

    @Override
    public List<ForeignKey<BccRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BccRecord, ?>>asList(Keys.BCC_TO_BCCP_ID_FK, Keys.BCC_FROM_ACC_ID_FK, Keys.BCC_CREATED_BY_FK, Keys.BCC_OWNER_USER_ID_FK, Keys.BCC_LAST_UPDATED_BY_FK, Keys.BCC_RELEASE_ID_FK, Keys.BCC_CURRENT_BCC_ID_FK);
    }

    public Bccp bccp() {
        return new Bccp(this, Keys.BCC_TO_BCCP_ID_FK);
    }

    public Acc acc() {
        return new Acc(this, Keys.BCC_FROM_ACC_ID_FK);
    }

    public AppUser bccCreatedByFk() {
        return new AppUser(this, Keys.BCC_CREATED_BY_FK);
    }

    public AppUser bccOwnerUserIdFk() {
        return new AppUser(this, Keys.BCC_OWNER_USER_ID_FK);
    }

    public AppUser bccLastUpdatedByFk() {
        return new AppUser(this, Keys.BCC_LAST_UPDATED_BY_FK);
    }

    public Release release() {
        return new Release(this, Keys.BCC_RELEASE_ID_FK);
    }

    public org.oagi.score.entity.jooq.tables.Bcc bcc() {
        return new org.oagi.score.entity.jooq.tables.Bcc(this, Keys.BCC_CURRENT_BCC_ID_FK);
    }

    @Override
    public Bcc as(String alias) {
        return new Bcc(DSL.name(alias), this);
    }

    @Override
    public Bcc as(Name alias) {
        return new Bcc(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bcc rename(String name) {
        return new Bcc(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bcc rename(Name name) {
        return new Bcc(name, null);
    }
}
