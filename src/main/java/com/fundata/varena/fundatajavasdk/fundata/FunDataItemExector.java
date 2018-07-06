package com.fundata.varena.fundatajavasdk.fundata;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;

/**
 * @author baoyl
 * @created 2018/6/5
 */
public class FunDataItemExector extends FunDataExector {

    public FunDataItemExector(String key, String secret) {
        super(key, secret);
    }

    private Form makeItemRankQuery(Integer period, Integer offset, Integer limit) {
        return new Form().add("period", period)
                .add("offset", offset)
                .add("limit", limit);
    }

    private Form makeItemHerosQuery(Integer itemId, Integer period, Integer offset, Integer limit) {
        return makeItemRankQuery(period, offset, limit).add("item_id", itemId);
    }

    /**
     * /data-service/dota2/analysis/item/rank
     * @param period  1: 7天，2: 30天
     * @param offset
     * @param limit
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getItemRank(Integer period, Integer offset, Integer limit) throws ClientException {
        return this.clientOperation.get("/analysis/item/rank", makeItemRankQuery(period, offset, limit));
    }

    /**
     * /data-service/dota2/analysis/item/heroes
     * @param itemId 道具id
     * @param period  1: 7天，2: 30天
     * @param offset
     * @param limit
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getItemHeroes(Integer itemId, Integer period, Integer offset, Integer limit) throws ClientException {
        return this.clientOperation.get("/analysis/item/heroes", makeItemHerosQuery(itemId, period, offset, limit));
    }
}
