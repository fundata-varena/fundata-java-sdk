package com.fundata.varena.fundatajavasdk.fundata.csgo.v2.pub;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/26
 */
public class CsgoLeagueExector extends FunDataExector {
    public CsgoLeagueExector(String key, String secret) {
        super(key, secret, "/fundata-csgo-free/v2/league");
    }

    public FunDataResult getLeagueList(int pageSize, int page) throws ClientException {
        return clientOperation.get("/list", makePageByPageSize(pageSize, page));
    }

    public FunDataResult getLeagueDetail(int leagueId) throws ClientException {
        return clientOperation.get("/detail", makeLeagueForm(leagueId));
    }

}
