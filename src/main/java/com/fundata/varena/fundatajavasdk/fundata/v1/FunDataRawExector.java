package com.fundata.varena.fundatajavasdk.fundata.v1;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2018/6/5
 */
public class FunDataRawExector extends FunDataExector {

    public FunDataRawExector(String key, String secret) {
        super(key, secret, "/data-service/dota2");
    }

    /**
     * /data-service/dota2/public/raw/heroes
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getRawHeroes() throws ClientException {
        return this.clientOperation.get("/public/raw/heroes");
    }

    /**
     * /data-service/dota2/public/raw/items
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getRawItems() throws ClientException {
        return this.clientOperation.get("/public/raw/items");
    }
}
