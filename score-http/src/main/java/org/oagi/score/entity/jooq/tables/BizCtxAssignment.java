/*
 * This file is generated by jOOQ.
 */
package org.oagi.score.entity.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
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
import org.oagi.score.entity.jooq.tables.records.BizCtxAssignmentRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BizCtxAssignment extends TableImpl<BizCtxAssignmentRecord> {

    private static final long serialVersionUID = -339923264;

    /**
     * The reference instance of <code>oagi.biz_ctx_assignment</code>
     */
    public static final BizCtxAssignment BIZ_CTX_ASSIGNMENT = new BizCtxAssignment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BizCtxAssignmentRecord> getRecordType() {
        return BizCtxAssignmentRecord.class;
    }

    /**
     * The column <code>oagi.biz_ctx_assignment.biz_ctx_assignment_id</code>.
     */
    public final TableField<BizCtxAssignmentRecord, ULong> BIZ_CTX_ASSIGNMENT_ID = createField(DSL.name("biz_ctx_assignment_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>oagi.biz_ctx_assignment.biz_ctx_id</code>.
     */
    public final TableField<BizCtxAssignmentRecord, ULong> BIZ_CTX_ID = createField(DSL.name("biz_ctx_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>oagi.biz_ctx_assignment.top_level_asbiep_id</code>. This is a foreign key to the top-level ASBIEP.
     */
    public final TableField<BizCtxAssignmentRecord, ULong> TOP_LEVEL_ASBIEP_ID = createField(DSL.name("top_level_asbiep_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "This is a foreign key to the top-level ASBIEP.");

    /**
     * Create a <code>oagi.biz_ctx_assignment</code> table reference
     */
    public BizCtxAssignment() {
        this(DSL.name("biz_ctx_assignment"), null);
    }

    /**
     * Create an aliased <code>oagi.biz_ctx_assignment</code> table reference
     */
    public BizCtxAssignment(String alias) {
        this(DSL.name(alias), BIZ_CTX_ASSIGNMENT);
    }

    /**
     * Create an aliased <code>oagi.biz_ctx_assignment</code> table reference
     */
    public BizCtxAssignment(Name alias) {
        this(alias, BIZ_CTX_ASSIGNMENT);
    }

    private BizCtxAssignment(Name alias, Table<BizCtxAssignmentRecord> aliased) {
        this(alias, aliased, null);
    }

    private BizCtxAssignment(Name alias, Table<BizCtxAssignmentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> BizCtxAssignment(Table<O> child, ForeignKey<O, BizCtxAssignmentRecord> key) {
        super(child, key, BIZ_CTX_ASSIGNMENT);
    }

    @Override
    public Schema getSchema() {
        return Oagi.OAGI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BIZ_CTX_ASSIGNMENT_BIZ_CTX_ASSIGNMENT_TOP_LEVEL_ASBIEP_ID_FK, Indexes.BIZ_CTX_ASSIGNMENT_BIZ_CTX_ASSIGNMENT_UK, Indexes.BIZ_CTX_ASSIGNMENT_BIZ_CTX_ID, Indexes.BIZ_CTX_ASSIGNMENT_PRIMARY);
    }

    @Override
    public Identity<BizCtxAssignmentRecord, ULong> getIdentity() {
        return Keys.IDENTITY_BIZ_CTX_ASSIGNMENT;
    }

    @Override
    public UniqueKey<BizCtxAssignmentRecord> getPrimaryKey() {
        return Keys.KEY_BIZ_CTX_ASSIGNMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<BizCtxAssignmentRecord>> getKeys() {
        return Arrays.<UniqueKey<BizCtxAssignmentRecord>>asList(Keys.KEY_BIZ_CTX_ASSIGNMENT_PRIMARY, Keys.KEY_BIZ_CTX_ASSIGNMENT_BIZ_CTX_ASSIGNMENT_UK);
    }

    @Override
    public List<ForeignKey<BizCtxAssignmentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BizCtxAssignmentRecord, ?>>asList(Keys.BIZ_CTX_ASSIGNMENT_BIZ_CTX_ID_FK, Keys.BIZ_CTX_ASSIGNMENT_TOP_LEVEL_ASBIEP_ID_FK);
    }

    public BizCtx bizCtx() {
        return new BizCtx(this, Keys.BIZ_CTX_ASSIGNMENT_BIZ_CTX_ID_FK);
    }

    public TopLevelAsbiep topLevelAsbiep() {
        return new TopLevelAsbiep(this, Keys.BIZ_CTX_ASSIGNMENT_TOP_LEVEL_ASBIEP_ID_FK);
    }

    @Override
    public BizCtxAssignment as(String alias) {
        return new BizCtxAssignment(DSL.name(alias), this);
    }

    @Override
    public BizCtxAssignment as(Name alias) {
        return new BizCtxAssignment(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BizCtxAssignment rename(String name) {
        return new BizCtxAssignment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BizCtxAssignment rename(Name name) {
        return new BizCtxAssignment(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<ULong, ULong, ULong> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
