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
        Form form = makeLeagueForm(leagueId)
                .add("start_date", startDate.getTime() / 1000L)
                .add("interval", interval);
        return clientOperation.get("/list");
    }

    public FunDataResult getScheduleDetail(String scheduleId) throws ClientException {
        return clientOperation.get("/detail", makeScheduleForm(scheduleId));
    }

}
