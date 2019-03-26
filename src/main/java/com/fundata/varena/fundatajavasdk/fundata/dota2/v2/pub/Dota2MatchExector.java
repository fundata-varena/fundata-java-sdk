package com.fundata.varena.fundatajavasdk.fundata.dota2.v2.pub;

import java.util.Date;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/25
 */
public class Dota2MatchExector extends FunDataExector {

    public Dota2MatchExector(String key, String secret) {
        super(key, secret, "/fundata-dota2-free/v2/match");
    }

    private Form makeMatchForm(int matchId) {
        return new Form().add("match_id", matchId);
    }

    public FunDataResult getMatchBasicInfo(int matchId) throws ClientException {
        return clientOperation.get("/basic-info", makeMatchForm(matchId));
    }

    public FunDataResult getMatchBanPicks(int matchId) throws ClientException {
        return clientOperation.get("/ban-picks", makeMatchForm(matchId));
    }

    public FunDataResult getMatchGeneralInfo(int matchId) throws ClientException {
        return clientOperation.get("/general-info", makeMatchForm(matchId));
    }

    public FunDataResult getMatchPlayers(int matchId) throws ClientException {
        return clientOperation.get("/players", makeMatchForm(matchId));
    }

    public FunDataResult getMatchPlayersAbilityUpgrades(int matchId) throws ClientException {
        return clientOperation.get("/players-ability-upgrades", makeMatchForm(matchId));
    }

    private Form makeMatchBatchForm(Date startTime, Date startFrom, int limit) {
        limit = limit < 0 ? 0 : limit;
        limit = limit > 200 ? 200 : limit;
        Form form = new Form().add("start_time", startTime.getTime() / 1000L)
                .add("limit", limit);
        if (startFrom != null) {
            form.add("start_from", startFrom.getTime() / 1000L);
        }
        return form;
    }

    public FunDataResult batchMatchBasicInfo(Date startTime, Date startFrom, int limit) throws ClientException {
        return clientOperation.get("/basic-info/batch", makeMatchBatchForm(startTime, startFrom, limit));
    }

    public FunDataResult batchMatchBanPicks(Date startTime, Date startFrom, int limit) throws ClientException {
        return clientOperation.get("/ban-picks/batch", makeMatchBatchForm(startTime, startFrom, limit));
    }

    public FunDataResult batchMatchPlayers(Date startTime, Date startFrom, int limit) throws ClientException {
        return clientOperation.get("/players/batch", makeMatchBatchForm(startTime, startFrom, limit));
    }

    public FunDataResult batchMatchPlayersAbilityUpgrades(Date startTime, Date startFrom, int limit) throws ClientException {
        return clientOperation.get("/players-ability-upgrades/batch", makeMatchBatchForm(startTime, startFrom, limit));
    }
}
