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
import org.jooq.Row13;
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
import org.oagi.score.entity.jooq.tables.records.AbieRecord;


/**
 * The ABIE table stores information about an ABIE, which is a contextualized 
 * ACC. The context is represented by the BUSINESS_CTX_ID column that refers 
 * to a business context. Each ABIE must have a business context and a based 
 * ACC.
 * 
 * It should be noted that, per design document, there is no corresponding 
 * ABIE created for an ACC which will not show up in the instance document 
 * such as ACCs of OAGIS_COMPONENT_TYPE "SEMANTIC_GROUP", "USER_EXTENSION_GROUP", 
 * etc.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Abie extends TableImpl<AbieRecord> {

    private static final long serialVersionUID = 1338161543;

    /**
     * The reference instance of <code>oagi.abie</code>
     */
    public static final Abie ABIE = new Abie();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AbieRecord> getRecordType() {
        return AbieRecord.class;
    }

    /**
     * The column <code>oagi.abie.abie_id</code>. A internal, primary database key of an ABIE.
     */
    public final TableField<AbieRecord, ULong> ABIE_ID = createField(DSL.name("abie_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "A internal, primary database key of an ABIE.");

    /**
     * The column <code>oagi.abie.guid</code>. A globally unique identifier (GUID) of an ABIE. GUID of an ABIE is different from its based ACC. Per OAGIS, a GUID is of the form "oagis-id-" followed by a 32 Hex character sequence.
     */
    public final TableField<AbieRecord, String> GUID = createField(DSL.name("guid"), org.jooq.impl.SQLDataType.VARCHAR(41).nullable(false), this, "A globally unique identifier (GUID) of an ABIE. GUID of an ABIE is different from its based ACC. Per OAGIS, a GUID is of the form \"oagis-id-\" followed by a 32 Hex character sequence.");

    /**
     * The column <code>oagi.abie.based_acc_id</code>. A foreign key to the ACC table refering to the ACC, on which the business context has been applied to derive this ABIE.
     */
    public final TableField<AbieRecord, ULong> BASED_ACC_ID = createField(DSL.name("based_acc_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A foreign key to the ACC table refering to the ACC, on which the business context has been applied to derive this ABIE.");

    /**
     * The column <code>oagi.abie.biz_ctx_id</code>. (Deprecated) A foreign key to the BIZ_CTX table. This column stores the business context assigned to the ABIE.
     */
    public final TableField<AbieRecord, ULong> BIZ_CTX_ID = createField(DSL.name("biz_ctx_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "(Deprecated) A foreign key to the BIZ_CTX table. This column stores the business context assigned to the ABIE.");

    /**
     * The column <code>oagi.abie.definition</code>. Definition to override the ACC's definition. If NULL, it means that the definition should be inherited from the based CC.
     */
    public final TableField<AbieRecord, String> DEFINITION = createField(DSL.name("definition"), org.jooq.impl.SQLDataType.CLOB, this, "Definition to override the ACC's definition. If NULL, it means that the definition should be inherited from the based CC.");

    /**
     * The column <code>oagi.abie.created_by</code>. A foreign key referring to the user who creates the ABIE. The creator of the ABIE is also its owner by default. ABIEs created as children of another ABIE have the same CREATED_BY as its parent.
     */
    public final TableField<AbieRecord, ULong> CREATED_BY = createField(DSL.name("created_by"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A foreign key referring to the user who creates the ABIE. The creator of the ABIE is also its owner by default. ABIEs created as children of another ABIE have the same CREATED_BY as its parent.");

    /**
     * The column <code>oagi.abie.last_updated_by</code>. A foreign key referring to the last user who has updated the ABIE record. This may be the user who is in the same group as the creator.
     */
    public final TableField<AbieRecord, ULong> LAST_UPDATED_BY = createField(DSL.name("last_updated_by"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "A foreign key referring to the last user who has updated the ABIE record. This may be the user who is in the same group as the creator.");

    /**
     * The column <code>oagi.abie.creation_timestamp</code>. Timestamp when the ABIE record was first created. ABIEs created as children of another ABIE have the same CREATION_TIMESTAMP.
     */
    public final TableField<AbieRecord, Timestamp> CREATION_TIMESTAMP = createField(DSL.name("creation_timestamp"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "Timestamp when the ABIE record was first created. ABIEs created as children of another ABIE have the same CREATION_TIMESTAMP.");

    /**
     * The column <code>oagi.abie.last_update_timestamp</code>. The timestamp when the ABIE was last updated.
     */
    public final TableField<AbieRecord, Timestamp> LAST_UPDATE_TIMESTAMP = createField(DSL.name("last_update_timestamp"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "The timestamp when the ABIE was last updated.");

    /**
     * The column <code>oagi.abie.state</code>. 2 = EDITING, 4 = PUBLISHED. This column is only used with a top-level ABIE, because that is the only entry point for editing. The state value indicates the visibility of the top-level ABIE to users other than the owner. In the user group environment, a logic can apply that other users in the group can see the top-level ABIE only when it is in the 'Published' state.
     */
    public final TableField<AbieRecord, Integer> STATE = createField(DSL.name("state"), org.jooq.impl.SQLDataType.INTEGER, this, "2 = EDITING, 4 = PUBLISHED. This column is only used with a top-level ABIE, because that is the only entry point for editing. The state value indicates the visibility of the top-level ABIE to users other than the owner. In the user group environment, a logic can apply that other users in the group can see the top-level ABIE only when it is in the 'Published' state.");

    /**
     * The column <code>oagi.abie.remark</code>. This column allows the user to specify very context-specific usage of the BIE. It is different from the DEFINITION column in that the DEFINITION column is a description conveying the meaning of the associated concept. Remarks may be a very implementation specific instruction or others. For example, BOM BOD, as an ACC, is a generic BOM structure. In a particular context, a BOM ABIE can be a Super BOM. Explanation of the Super BOM concept should be captured in the Definition of the ABIE. A remark about that ABIE may be "Type of BOM should be recognized in the BOM/typeCode."
     */
    public final TableField<AbieRecord, String> REMARK = createField(DSL.name("remark"), org.jooq.impl.SQLDataType.VARCHAR(225), this, "This column allows the user to specify very context-specific usage of the BIE. It is different from the DEFINITION column in that the DEFINITION column is a description conveying the meaning of the associated concept. Remarks may be a very implementation specific instruction or others. For example, BOM BOD, as an ACC, is a generic BOM structure. In a particular context, a BOM ABIE can be a Super BOM. Explanation of the Super BOM concept should be captured in the Definition of the ABIE. A remark about that ABIE may be \"Type of BOM should be recognized in the BOM/typeCode.\"");

    /**
     * The column <code>oagi.abie.biz_term</code>. To indicate what the BIE is called in a particular business context. With this current design, only one business term is allowed per business context.
     */
    public final TableField<AbieRecord, String> BIZ_TERM = createField(DSL.name("biz_term"), org.jooq.impl.SQLDataType.VARCHAR(225), this, "To indicate what the BIE is called in a particular business context. With this current design, only one business term is allowed per business context.");

    /**
     * The column <code>oagi.abie.owner_top_level_asbiep_id</code>. This is a foreign key to the top-level ASBIEP.
     */
    public final TableField<AbieRecord, ULong> OWNER_TOP_LEVEL_ASBIEP_ID = createField(DSL.name("owner_top_level_asbiep_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "This is a foreign key to the top-level ASBIEP.");

    /**
     * Create a <code>oagi.abie</code> table reference
     */
    public Abie() {
        this(DSL.name("abie"), null);
    }

    /**
     * Create an aliased <code>oagi.abie</code> table reference
     */
    public Abie(String alias) {
        this(DSL.name(alias), ABIE);
    }

    /**
     * Create an aliased <code>oagi.abie</code> table reference
     */
    public Abie(Name alias) {
        this(alias, ABIE);
    }

    private Abie(Name alias, Table<AbieRecord> aliased) {
        this(alias, aliased, null);
    }

    private Abie(Name alias, Table<AbieRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("The ABIE table stores information about an ABIE, which is a contextualized ACC. The context is represented by the BUSINESS_CTX_ID column that refers to a business context. Each ABIE must have a business context and a based ACC.\n\nIt should be noted that, per design document, there is no corresponding ABIE created for an ACC which will not show up in the instance document such as ACCs of OAGIS_COMPONENT_TYPE \"SEMANTIC_GROUP\", \"USER_EXTENSION_GROUP\", etc."));
    }

    public <O extends Record> Abie(Table<O> child, ForeignKey<O, AbieRecord> key) {
        super(child, key, ABIE);
    }

    @Override
    public Schema getSchema() {
        return Oagi.OAGI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ABIE_ABIE_BASED_ACC_ID_FK, Indexes.ABIE_ABIE_BIZ_CTX_ID_FK, Indexes.ABIE_ABIE_CREATED_BY_FK, Indexes.ABIE_ABIE_LAST_UPDATED_BY_FK, Indexes.ABIE_ABIE_OWNER_TOP_LEVEL_ASBIEP_ID_FK, Indexes.ABIE_PRIMARY);
    }

    @Override
    public Identity<AbieRecord, ULong> getIdentity() {
        return Keys.IDENTITY_ABIE;
    }

    @Override
    public UniqueKey<AbieRecord> getPrimaryKey() {
        return Keys.KEY_ABIE_PRIMARY;
    }

    @Override
    public List<UniqueKey<AbieRecord>> getKeys() {
        return Arrays.<UniqueKey<AbieRecord>>asList(Keys.KEY_ABIE_PRIMARY);
    }

    @Override
    public List<ForeignKey<AbieRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AbieRecord, ?>>asList(Keys.ABIE_BASED_ACC_ID_FK, Keys.ABIE_BIZ_CTX_ID_FK, Keys.ABIE_CREATED_BY_FK, Keys.ABIE_LAST_UPDATED_BY_FK, Keys.ABIE_OWNER_TOP_LEVEL_ASBIEP_ID_FK);
    }

    public Acc acc() {
        return new Acc(this, Keys.ABIE_BASED_ACC_ID_FK);
    }

    public BizCtx bizCtx() {
        return new BizCtx(this, Keys.ABIE_BIZ_CTX_ID_FK);
    }

    public AppUser abieCreatedByFk() {
        return new AppUser(this, Keys.ABIE_CREATED_BY_FK);
    }

    public AppUser abieLastUpdatedByFk() {
        return new AppUser(this, Keys.ABIE_LAST_UPDATED_BY_FK);
    }

    public TopLevelAsbiep topLevelAsbiep() {
        return new TopLevelAsbiep(this, Keys.ABIE_OWNER_TOP_LEVEL_ASBIEP_ID_FK);
    }

    @Override
    public Abie as(String alias) {
        return new Abie(DSL.name(alias), this);
    }

    @Override
    public Abie as(Name alias) {
        return new Abie(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Abie rename(String name) {
        return new Abie(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Abie rename(Name name) {
        return new Abie(name, null);
    }

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row13<ULong, String, ULong, ULong, String, ULong, ULong, Timestamp, Timestamp, Integer, String, String, ULong> fieldsRow() {
        return (Row13) super.fieldsRow();
    }
}
