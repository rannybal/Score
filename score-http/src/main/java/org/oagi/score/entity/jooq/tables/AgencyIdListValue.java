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
import org.jooq.Row5;
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
import org.oagi.score.entity.jooq.tables.records.AgencyIdListValueRecord;


/**
 * This table captures the values within an agency identification list.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AgencyIdListValue extends TableImpl<AgencyIdListValueRecord> {

    private static final long serialVersionUID = 1893002374;

    /**
     * The reference instance of <code>oagi.agency_id_list_value</code>
     */
    public static final AgencyIdListValue AGENCY_ID_LIST_VALUE = new AgencyIdListValue();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AgencyIdListValueRecord> getRecordType() {
        return AgencyIdListValueRecord.class;
    }

    /**
     * The column <code>oagi.agency_id_list_value.agency_id_list_value_id</code>. Primary key column.
     */
    public final TableField<AgencyIdListValueRecord, ULong> AGENCY_ID_LIST_VALUE_ID = createField(DSL.name("agency_id_list_value_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "Primary key column.");

    /**
     * The column <code>oagi.agency_id_list_value.value</code>. A value in the agency identification list.
     */
    public final TableField<AgencyIdListValueRecord, String> VALUE = createField(DSL.name("value"), org.jooq.impl.SQLDataType.VARCHAR(150).nullable(false), this, "A value in the agency identification list.");

    /**
     * The column <code>oagi.agency_id_list_value.name</code>. Descriptive or short name of the value.
     */
    public final TableField<AgencyIdListValueRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(150), this, "Descriptive or short name of the value.");

    /**
     * The column <code>oagi.agency_id_list_value.definition</code>. The meaning of the value.
     */
    public final TableField<AgencyIdListValueRecord, String> DEFINITION = createField(DSL.name("definition"), org.jooq.impl.SQLDataType.CLOB, this, "The meaning of the value.");

    /**
     * The column <code>oagi.agency_id_list_value.owner_list_id</code>. Foreign key to the agency identification list in the AGENCY_ID_LIST table this value belongs to.
     */
    public final TableField<AgencyIdListValueRecord, ULong> OWNER_LIST_ID = createField(DSL.name("owner_list_id"), org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "Foreign key to the agency identification list in the AGENCY_ID_LIST table this value belongs to.");

    /**
     * Create a <code>oagi.agency_id_list_value</code> table reference
     */
    public AgencyIdListValue() {
        this(DSL.name("agency_id_list_value"), null);
    }

    /**
     * Create an aliased <code>oagi.agency_id_list_value</code> table reference
     */
    public AgencyIdListValue(String alias) {
        this(DSL.name(alias), AGENCY_ID_LIST_VALUE);
    }

    /**
     * Create an aliased <code>oagi.agency_id_list_value</code> table reference
     */
    public AgencyIdListValue(Name alias) {
        this(alias, AGENCY_ID_LIST_VALUE);
    }

    private AgencyIdListValue(Name alias, Table<AgencyIdListValueRecord> aliased) {
        this(alias, aliased, null);
    }

    private AgencyIdListValue(Name alias, Table<AgencyIdListValueRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("This table captures the values within an agency identification list."));
    }

    public <O extends Record> AgencyIdListValue(Table<O> child, ForeignKey<O, AgencyIdListValueRecord> key) {
        super(child, key, AGENCY_ID_LIST_VALUE);
    }

    @Override
    public Schema getSchema() {
        return Oagi.OAGI;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.AGENCY_ID_LIST_VALUE_AGENCY_ID_LIST_VALUE_OWNER_LIST_ID_FK, Indexes.AGENCY_ID_LIST_VALUE_PRIMARY);
    }

    @Override
    public Identity<AgencyIdListValueRecord, ULong> getIdentity() {
        return Keys.IDENTITY_AGENCY_ID_LIST_VALUE;
    }

    @Override
    public UniqueKey<AgencyIdListValueRecord> getPrimaryKey() {
        return Keys.KEY_AGENCY_ID_LIST_VALUE_PRIMARY;
    }

    @Override
    public List<UniqueKey<AgencyIdListValueRecord>> getKeys() {
        return Arrays.<UniqueKey<AgencyIdListValueRecord>>asList(Keys.KEY_AGENCY_ID_LIST_VALUE_PRIMARY);
    }

    @Override
    public List<ForeignKey<AgencyIdListValueRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AgencyIdListValueRecord, ?>>asList(Keys.AGENCY_ID_LIST_VALUE_OWNER_LIST_ID_FK);
    }

    public AgencyIdList agencyIdList() {
        return new AgencyIdList(this, Keys.AGENCY_ID_LIST_VALUE_OWNER_LIST_ID_FK);
    }

    @Override
    public AgencyIdListValue as(String alias) {
        return new AgencyIdListValue(DSL.name(alias), this);
    }

    @Override
    public AgencyIdListValue as(Name alias) {
        return new AgencyIdListValue(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AgencyIdListValue rename(String name) {
        return new AgencyIdListValue(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AgencyIdListValue rename(Name name) {
        return new AgencyIdListValue(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<ULong, String, String, String, ULong> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
