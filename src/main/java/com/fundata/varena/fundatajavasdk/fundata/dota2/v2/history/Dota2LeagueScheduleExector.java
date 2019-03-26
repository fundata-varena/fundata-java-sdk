package com.fundata.varena.fundatajavasdk.fundata.dota2.v2.history;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/25
 */
public class Dota2LeagueScheduleExector extends FunDataExector {
    public Dota2LeagueScheduleExector(String key, String secret) {
        super(key, secret, "/fundata-dota2-basic/league/schedule");
    }

    public FunDataResult getScheduleList() throws ClientException {
        return clientOperation.get("/list");
    }

    public FunDataResult getScheduleDetail(String scheduleId) throws ClientException {
        Form form = new Form().add("schedule_id", scheduleId);
        return clientOperation.get("/detail", form);
    }
}
