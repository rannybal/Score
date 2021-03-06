/*
 * This file is generated by jOOQ.
 */
package org.oagi.score.entity.jooq.tables;


import java.math.BigDecimal;
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
import org.jooq.Row17;
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
import org.oagi.score.entity.jooq.tables.records.AsbieRecord;


/**
 * An ASBIE represents a relationship/association between two ABIEs through 
 * an ASBIEP. It is a contextualization of an ASCC.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Asbie extends TableImpl<AsbieRecord> {

    private static final long serialVersionUID = -1690797890;

    /**
     * The reference instance of <code>oagi.asbie</code>
     */
    public static final Asbie ASBIE = new Asbie();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AsbieRecord> getRecordType() {
        return AsbieRecord.class;
    }

    /**
     * The column <code>oagi.asbie.asbie_id</code>. A internal, primary database key of an ASBIE.
     */
    public final TableField<AsbieRecord, ULong> ASBIE_ID = createField(DSL.name("asbie_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "A internal, primary database key of an ASBIE.");

    /**
     * The column <code>oagi.asbie.guid</code>. A globally unique identifier (GUID) of an ASBIE. GUID of an ASBIE is different from its based ASCC. Per OAGIS, a GUID is of the form "oagis-id-" followed by a 32 Hex character sequence.
     */
    public final TableField<AsbieRecord, String> GUID = createField(DSL.name("guid"), org.jooq.impl.SQLDataType.VARCHAR(41).nullable(false), this, "A globally unique identifier (GUID) of an ASBIE. GUID of an ASBIE is different from its based ASCC. Per OAGIS, a GUID is of the form \"oagis-id-\" followed by a 32 Hex character sequence.");

    /**
     * The column <code>oagi.asbie.from_abie_id</code>. A foreign key pointing to the ABIE table. FROM_ABIE_ID is basically  a parent data element (type) of the TO_ASBIEP_ID. FROM_ABIE_ID must be based on the FROM_ACC_ID in the BASED_ASCC_ID except when the FROM_ACC_ID refers to an SEMANTIC_GROUP ACC or USER_EXTENSION_GROUP ACC.
     */
    public final TableField<AsbieRecord, ULong> FROM_ABIE_ID = createField(DSL.name("from_abie_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A foreign key pointing to the ABIE table. FROM_ABIE_ID is basically  a parent data element (type) of the TO_ASBIEP_ID. FROM_ABIE_ID must be based on the FROM_ACC_ID in the BASED_ASCC_ID except when the FROM_ACC_ID refers to an SEMANTIC_GROUP ACC or USER_EXTENSION_GROUP ACC.");

    /**
     * The column <code>oagi.asbie.to_asbiep_id</code>. A foreign key to the ASBIEP table. TO_ASBIEP_ID is basically a child data element of the FROM_ABIE_ID. The TO_ASBIEP_ID must be based on the TO_ASCCP_ID in the BASED_ASCC_ID. the ASBIEP is reused with the OWNER_TOP_LEVEL_ASBIEP is different after joining ASBIE and ASBIEP tables
     */
    public final TableField<AsbieRecord, ULong> TO_ASBIEP_ID = createField(DSL.name("to_asbiep_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "A foreign key to the ASBIEP table. TO_ASBIEP_ID is basically a child data element of the FROM_ABIE_ID. The TO_ASBIEP_ID must be based on the TO_ASCCP_ID in the BASED_ASCC_ID. the ASBIEP is reused with the OWNER_TOP_LEVEL_ASBIEP is different after joining ASBIE and ASBIEP tables");

    /**
     * The column <code>oagi.asbie.based_ascc_id</code>. The BASED_ASCC_ID column refers to the ASCC record, which this ASBIE contextualizes.
     */
    public final TableField<AsbieRecord, ULong> BASED_ASCC_ID = createField(DSL.name("based_ascc_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "The BASED_ASCC_ID column refers to the ASCC record, which this ASBIE contextualizes.");

    /**
     * The column <code>oagi.asbie.definition</code>. Definition to override the ASCC definition. If NULL, it means that the definition should be derived from the based CC on the UI, expression generation, and any API.
     */
    public final TableField<AsbieRecord, String> DEFINITION = createField(DSL.name("definition"), org.jooq.impl.SQLDataType.CLOB, this, "Definition to override the ASCC definition. If NULL, it means that the definition should be derived from the based CC on the UI, expression generation, and any API.");

    /**
     * The column <code>oagi.asbie.cardinality_min</code>. Minimum occurence constraint of the TO_ASBIEP_ID. A valid value is a non-negative integer.
     */
    public final TableField<AsbieRecord, Integer> CARDINALITY_MIN = createField(DSL.name("cardinality_min"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Minimum occurence constraint of the TO_ASBIEP_ID. A valid value is a non-negative integer.");

    /**
     * The column <code>oagi.asbie.cardinality_max</code>. Maximum occurrence constraint of the TO_ASBIEP_ID. A valid value is an integer from -1 and up. Specifically, -1 means unbounded. 0 means prohibited or not to use.
     */
    public final TableField<AsbieRecord, Integer> CARDINALITY_MAX = createField(DSL.name("cardinality_max"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Maximum occurrence constraint of the TO_ASBIEP_ID. A valid value is an integer from -1 and up. Specifically, -1 means unbounded. 0 means prohibited or not to use.");

    /**
     * The column <code>oagi.asbie.is_nillable</code>. Indicate whether the TO_ASBIEP_ID is allowed to be null.
     */
    public final TableField<AsbieRecord, Byte> IS_NILLABLE = createField(DSL.name("is_nillable"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "Indicate whether the TO_ASBIEP_ID is allowed to be null.");

    /**
     * The column <code>oagi.asbie.remark</code>. This column allows the user to specify very context-specific usage of the BIE. It is different from the DEFINITION column in that the DEFINITION column is a description conveying the meaning of the associated concept. Remarks may be a very implementation specific instruction or others. For example, BOM BOD, as an ACC, is a generic BOM structure. In a particular context, a BOM ABIE can be a Super BOM. Explanation of the Super BOM concept should be captured in the Definition of the ABIE. A remark about that ABIE may be "Type of BOM should be recognized in the BOM/typeCode."
     */
    public final TableField<AsbieRecord, String> REMARK = createField(DSL.name("remark"), org.jooq.impl.SQLDataType.VARCHAR(225), this, "This column allows the user to specify very context-specific usage of the BIE. It is different from the DEFINITION column in that the DEFINITION column is a description conveying the meaning of the associated concept. Remarks may be a very implementation specific instruction or others. For example, BOM BOD, as an ACC, is a generic BOM structure. In a particular context, a BOM ABIE can be a Super BOM. Explanation of the Super BOM concept should be captured in the Definition of the ABIE. A remark about that ABIE may be \"Type of BOM should be recognized in the BOM/typeCode.\"");

    /**
     * The column <code>oagi.asbie.created_by</code>. A foreign key referring to the user who creates the ASBIE. The creator of the ASBIE is also its owner by default. ASBIEs created as children of another ABIE have the same CREATED_BY.
     */
    public final TableField<AsbieRecord, ULong> CREATED_BY = createField(DSL.name("created_by"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A foreign key referring to the user who creates the ASBIE. The creator of the ASBIE is also its owner by default. ASBIEs created as children of another ABIE have the same CREATED_BY.");

    /**
     * The column <code>oagi.asbie.last_updated_by</code>. A foreign key referring to the user who has last updated the ASBIE record. 
     */
    public final TableField<AsbieRecord, ULong> LAST_UPDATED_BY = createField(DSL.name("last_updated_by"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A foreign key referring to the user who has last updated the ASBIE record. ");

    /**
     * The column <code>oagi.asbie.creation_timestamp</code>. Timestamp when the ASBIE record was first created. ASBIEs created as children of another ABIE have the same CREATION_TIMESTAMP.
     */
    public final TableField<AsbieRecord, Timestamp> CREATION_TIMESTAMP = createField(DSL.name("creation_timestamp"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "Timestamp when the ASBIE record was first created. ASBIEs created as children of another ABIE have the same CREATION_TIMESTAMP.");

    /**
     * The column <code>oagi.asbie.last_update_timestamp</code>. The timestamp when the ASBIE was last updated.
     */
    public final TableField<AsbieRecord, Timestamp> LAST_UPDATE_TIMESTAMP = createField(DSL.name("last_update_timestamp"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "The timestamp when the ASBIE was last updated.");

    /**
     * The column <code>oagi.asbie.seq_key</code>. This indicates the order of the associations among other siblings. The SEQ_KEY for BIEs is decimal in order to accomodate the removal of inheritance hierarchy and group. For example, children of the most abstract ACC will have SEQ_KEY = 1.1, 1.2, 1.3, and so on; and SEQ_KEY of the next abstraction level ACC will have SEQ_KEY = 2.1, 2.2, 2.3 and so on so forth.
     */
    public final TableField<AsbieRecord, BigDecimal> SEQ_KEY = createField(DSL.name("seq_key"), org.jooq.impl.SQLDataType.DECIMAL(10, 2).nullable(false), this, "This indicates the order of the associations among other siblings. The SEQ_KEY for BIEs is decimal in order to accomodate the removal of inheritance hierarchy and group. For example, children of the most abstract ACC will have SEQ_KEY = 1.1, 1.2, 1.3, and so on; and SEQ_KEY of the next abstraction level ACC will have SEQ_KEY = 2.1, 2.2, 2.3 and so on so forth.");

    /**
     * The column <code>oagi.asbie.is_used</code>. Flag to indicate whether the field/component is used in the content model. It signifies whether the field/component should be generated.
     */
    public final TableField<AsbieRecord, Byte> IS_USED = createField(DSL.name("is_used"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "Flag to indicate whether the field/component is used in the content model. It signifies whether the field/component should be generated.");

    /**
     * The column <code>oagi.asbie.owner_top_level_asbiep_id</code>. This is a foreign key to the top-level ASBIEP.
     */
    public final TableField<AsbieRecord, ULong> OWNER_TOP_LEVEL_ASBIEP_ID = createField(DSL.name("owner_top_level_asbiep_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "This is a foreign key to the top-level ASBIEP.");

    /**
     * Create a <code>oagi.asbie</code> table reference
     */
    public Asbie() {
        this(DSL.name("asbie"), null);
    }

    /**
     * Create an aliased <code>oagi.asbie</code> table reference
     */
    public Asbie(String alias) {
        this(DSL.name(alias), ASBIE);
    }

    /**
     * Create an aliased <code>oagi.asbie</code> table reference
     */
    public Asbie(Name alias) {
        this(alias, ASBIE);
    }

    private Asbie(Name alias, Table<AsbieRecord> aliased) {
        this(alias, aliased, null);
    }

    private Asbie(Name alias, Table<AsbieRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("An ASBIE represents a relationship/association between two ABIEs through an ASBIEP. It is a contextualization of an ASCC."));
    }

    public <O extends Record> Asbie(Table<O> child, ForeignKey<O, AsbieRecord> key) {
        super(child, key, ASBIE);
    }

    @Override
    public Schema getSchema() {
        return Oagi.OAGI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ASBIE_ASBIE_BASED_ASCC_ID_FK, Indexes.ASBIE_ASBIE_CREATED_BY_FK, Indexes.ASBIE_ASBIE_FROM_ABIE_ID_FK, Indexes.ASBIE_ASBIE_LAST_UPDATED_BY_FK, Indexes.ASBIE_ASBIE_OWNER_TOP_LEVEL_ASBIEP_ID_FK, Indexes.ASBIE_ASBIE_TO_ASBIEP_ID_FK, Indexes.ASBIE_PRIMARY);
    }

    @Override
    public Identity<AsbieRecord, ULong> getIdentity() {
        return Keys.IDENTITY_ASBIE;
    }

    @Override
    public UniqueKey<AsbieRecord> getPrimaryKey() {
        return Keys.KEY_ASBIE_PRIMARY;
    }

    @Override
    public List<UniqueKey<AsbieRecord>> getKeys() {
        return Arrays.<UniqueKey<AsbieRecord>>asList(Keys.KEY_ASBIE_PRIMARY);
    }

    @Override
    public List<ForeignKey<AsbieRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AsbieRecord, ?>>asList(Keys.ASBIE_FROM_ABIE_ID_FK, Keys.ASBIE_TO_ASBIEP_ID_FK, Keys.ASBIE_BASED_ASCC_ID_FK, Keys.ASBIE_CREATED_BY_FK, Keys.ASBIE_LAST_UPDATED_BY_FK, Keys.ASBIE_OWNER_TOP_LEVEL_ASBIEP_ID_FK);
    }

    public Abie abie() {
        return new Abie(this, Keys.ASBIE_FROM_ABIE_ID_FK);
    }

    public Asbiep asbiep() {
        return new Asbiep(this, Keys.ASBIE_TO_ASBIEP_ID_FK);
    }

    public Ascc ascc() {
        return new Ascc(this, Keys.ASBIE_BASED_ASCC_ID_FK);
    }

    public AppUser asbieCreatedByFk() {
        return new AppUser(this, Keys.ASBIE_CREATED_BY_FK);
    }

    public AppUser asbieLastUpdatedByFk() {
        return new AppUser(this, Keys.ASBIE_LAST_UPDATED_BY_FK);
    }

    public TopLevelAsbiep topLevelAsbiep() {
        return new TopLevelAsbiep(this, Keys.ASBIE_OWNER_TOP_LEVEL_ASBIEP_ID_FK);
    }

    @Override
    public Asbie as(String alias) {
        return new Asbie(DSL.name(alias), this);
    }

    @Override
    public Asbie as(Name alias) {
        return new Asbie(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Asbie rename(String name) {
        return new Asbie(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Asbie rename(Name name) {
        return new Asbie(name, null);
    }

    // -------------------------------------------------------------------------
    // Row17 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row17<ULong, String, ULong, ULong, ULong, String, Integer, Integer, Byte, String, ULong, ULong, Timestamp, Timestamp, BigDecimal, Byte, ULong> fieldsRow() {
        return (Row17) super.fieldsRow();
    }
}
