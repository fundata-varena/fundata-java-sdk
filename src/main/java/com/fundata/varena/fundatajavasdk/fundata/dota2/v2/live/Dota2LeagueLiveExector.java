package com.fundata.varena.fundatajavasdk.fundata.dota2.v2.live;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/25
 */
public class Dota2LeagueLiveExector extends FunDataExector {
    public Dota2LeagueLiveExector(String key, String secret) {
        super(key, secret, "/fundata-dota2-pro/v2/league/live");
    }

    public FunDataResult getLiveScoreboard(int matchId) throws ClientException {
        return clientOperation.get("/scoreboard", makeMatchForm(matchId));
    }

    public FunDataResult getLivePlayer(int matchId) throws ClientException {
        return clientOperation.get("/player", makeMatchForm(matchId));
    }

    public FunDataResult getLiveNetworth(int matchId) throws ClientException {
        return clientOperation.get("/networth", makeMatchForm(matchId));
    }

    public FunDataResult getLiveEvents(int matchId, int lastLogScore) throws ClientException {
        return clientOperation.get("/events", makeMatchForm(matchId)
                .add("last_log_score", lastLogScore));
    }

}
