package com.fundata.varena.fundatajavasdk.fundata.dota2.v1;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Json;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2018/6/5
 */
public class Dota2ItemExector extends FunDataExector {

    public Dota2ItemExector(String key, String secret) {
        super(key, secret, "/data-service/dota2-data");
    }

    private Json makeItemRankQuery(Integer period, Integer offset, Integer limit) {
        return new Json().add("period", period)
                .put("offset", offset)
                .put("limit", limit);
    }

    private Json makeItemHerosQuery(Integer itemId, Integer period, Integer offset, Integer limit) {
        return makeItemRankQuery(period, offset, limit).put("item_id", itemId);
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
