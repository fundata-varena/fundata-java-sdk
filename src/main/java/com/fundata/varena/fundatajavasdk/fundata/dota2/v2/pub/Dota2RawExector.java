package com.fundata.varena.fundatajavasdk.fundata.dota2.v2.pub;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/25
 */
public class Dota2RawExector extends FunDataExector {

    public Dota2RawExector(String key, String secret) {
        super(key, secret, "/fundata-dota2-free/v2/raw");
    }

    public FunDataResult getRawHero() throws ClientException {
        return clientOperation.get("/hero");
    }

    public FunDataResult getRawItem() throws ClientException {
        return clientOperation.get("/item");
    }

    public FunDataResult getRawAbility() throws ClientException {
        return clientOperation.get("/ability");
    }

}
