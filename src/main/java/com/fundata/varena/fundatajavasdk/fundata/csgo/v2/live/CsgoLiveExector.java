package com.fundata.varena.fundatajavasdk.fundata.csgo.v2.live;

import java.util.Date;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/26
 */
public class CsgoLiveExector extends FunDataExector {
    public CsgoLiveExector(String key, String secret) {
        super(key, secret, "/fundata-csgo-pro/v2/league/live");
    }

    private Form makeScheduleForm(String scheduleId) {
        return new Form().add("schedule_id", scheduleId);
    }

    public FunDataResult getLiveScoreboard(String scheduleId) throws ClientException {
        return clientOperation.get("/scoreboard", makeScheduleForm(scheduleId));
    }

    public FunDataResult getLiveScore(String scheduleId) throws ClientException {
        return clientOperation.get("/score", makeScheduleForm(scheduleId));
    }

    public FunDataResult getLiveEvents(String scheduleId, Date startTime, Date endTime) throws ClientException {
        Form form = makeScheduleForm(scheduleId)
                .add("start_time", startTime.getTime() / 1000L)
                .add("end_time", endTime.getTime() / 1000L);
        return clientOperation.get("/score", form);
    }
}
