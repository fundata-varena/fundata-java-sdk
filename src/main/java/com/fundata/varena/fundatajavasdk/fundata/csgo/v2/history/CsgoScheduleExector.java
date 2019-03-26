package com.fundata.varena.fundatajavasdk.fundata.csgo.v2.history;

import java.util.Date;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/26
 */
public class CsgoScheduleExector extends FunDataExector {

    public CsgoScheduleExector(String key, String secret) {
        super(key, secret, "/fundata-csgo-basic/v2/league/schedule");
    }

    public FunDataResult getScheduleList(Date startDate, int interval, int leagueId) throws ClientException {
        Form form = new Form().add("start_date", startDate.getTime() / 1000L)
                .add("interval", interval)
                .add("league_id", leagueId);
        return clientOperation.get("/list");
    }

    public FunDataResult getScheduleDetail(String scheduleId) throws ClientException {
        Form form = new Form().add("schedule_id", scheduleId);
        return clientOperation.get("/detail", form);
    }

}
