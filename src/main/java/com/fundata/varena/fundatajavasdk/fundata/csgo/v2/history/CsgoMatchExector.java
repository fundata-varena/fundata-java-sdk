package com.fundata.varena.fundatajavasdk.fundata.csgo.v2.history;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/26
 */
public class CsgoMatchExector extends FunDataExector {
    public CsgoMatchExector(String key, String secret) {
        super(key, secret, "/fundata-csgo-basic/v2/league/math");
    }

    public FunDataResult getMatchOverview(String scheduleId) throws ClientException {
        return clientOperation.get("/overview", makeScheduleForm(scheduleId));
    }

    public FunDataResult getMatchDetail(String matchId) throws ClientException {
        return clientOperation.get("/detail", makeMatchForm(matchId));
    }

    public FunDataResult getMatchBP(String scheduleId) throws ClientException {
        return clientOperation.get("/bp", makeScheduleForm(scheduleId));
    }

}
