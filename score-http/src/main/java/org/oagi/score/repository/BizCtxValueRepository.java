package org.oagi.score.repository;

import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.oagi.score.data.BusinessContextValue;
import org.oagi.score.entity.jooq.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BizCtxValueRepository implements SrtRepository<BusinessContextValue> {

    @Autowired
    private DSLContext dslContext;

    @Override
    public List<BusinessContextValue> findAll() {
        return dslContext.select(Tables.BIZ_CTX_VALUE.fields()).from(Tables.BIZ_CTX_VALUE)
                .fetchInto(BusinessContextValue.class);
    }

    @Override
    public BusinessContextValue findById(long id) {
        return dslContext.select(Tables.BIZ_CTX_VALUE.fields()).from(Tables.BIZ_CTX_VALUE)
                .where(Tables.BIZ_CTX_VALUE.BIZ_CTX_VALUE_ID.eq(ULong.valueOf(id)))
                .fetchOneInto(BusinessContextValue.class);
    }

    public List<BusinessContextValue> findByBizCtxId(long bizCtxId) {
        return dslContext.select(Tables.BIZ_CTX_VALUE.fields()).from(Tables.BIZ_CTX_VALUE)
                .where(Tables.BIZ_CTX_VALUE.BIZ_CTX_ID.eq(ULong.valueOf(bizCtxId)))
                .fetchInto(BusinessContextValue.class);
    }

}
