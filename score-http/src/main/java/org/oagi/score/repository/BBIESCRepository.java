package org.oagi.score.repository;

import org.jooq.DSLContext;
import org.jooq.Record17;
import org.jooq.SelectJoinStep;
import org.jooq.types.ULong;
import org.oagi.score.data.BBIESC;
import org.oagi.score.entity.jooq.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.jooq.impl.DSL.and;

@Repository
public class BBIESCRepository implements SrtRepository<BBIESC> {

    @Autowired
    private DSLContext dslContext;

    private SelectJoinStep<Record17<
            ULong, String, ULong, ULong, ULong,
            ULong, ULong, Integer, Integer, String,
            String, String, String, String, String,
            Byte, ULong>> getSelectJoinStep() {
        return dslContext.select(
                Tables.BBIE_SC.BBIE_SC_ID,
                Tables.BBIE_SC.GUID,
                Tables.BBIE_SC.BBIE_ID,
                Tables.BBIE_SC.DT_SC_ID,
                Tables.BBIE_SC.DT_SC_PRI_RESTRI_ID,
                Tables.BBIE_SC.CODE_LIST_ID,
                Tables.BBIE_SC.AGENCY_ID_LIST_ID,
                Tables.BBIE_SC.CARDINALITY_MIN,
                Tables.BBIE_SC.CARDINALITY_MAX,
                Tables.BBIE_SC.DEFAULT_VALUE,
                Tables.BBIE_SC.FIXED_VALUE,
                Tables.BBIE_SC.DEFINITION,
                Tables.BBIE_SC.REMARK,
                Tables.BBIE_SC.BIZ_TERM,
                Tables.BBIE_SC.EXAMPLE,
                Tables.BBIE_SC.IS_USED.as("used"),
                Tables.BBIE_SC.OWNER_TOP_LEVEL_ASBIEP_ID)
                .from(Tables.BBIE_SC);
    }

    @Override
    public List<BBIESC> findAll() {
        return getSelectJoinStep().fetchInto(BBIESC.class);
    }

    @Override
    public BBIESC findById(long id) {
        if (id <= 0L) {
            return null;
        }
        return getSelectJoinStep()
                .where(Tables.BBIE_SC.BBIE_SC_ID.eq(ULong.valueOf(id)))
                .fetchOptionalInto(BBIESC.class).orElse(null);
    }

    public List<BBIESC> findByOwnerTopLevelAsbiepIdAndUsed(long ownerTopLevelAsbiepId, boolean used) {
        return findByOwnerTopLevelAsbiepIdsAndUsed(Arrays.asList(ownerTopLevelAsbiepId), used);
    }

    public List<BBIESC> findByOwnerTopLevelAsbiepIdsAndUsed(List<Long> ownerTopLevelAsbiepIds, boolean used) {
        return getSelectJoinStep()
                .where(and(
                        (ownerTopLevelAsbiepIds.size() == 1) ?
                                Tables.BBIE_SC.OWNER_TOP_LEVEL_ASBIEP_ID.eq(
                                        ULong.valueOf(ownerTopLevelAsbiepIds.get(0))) :
                                Tables.BBIE_SC.OWNER_TOP_LEVEL_ASBIEP_ID.in(
                                        ownerTopLevelAsbiepIds.stream().map(e -> ULong.valueOf(e)).collect(Collectors.toList())),
                        Tables.BBIE_SC.IS_USED.eq((byte) (used ? 1 : 0))))
                .fetchInto(BBIESC.class);
    }

}
