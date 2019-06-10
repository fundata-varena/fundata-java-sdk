package com.fundata.varena.fundatajavasdk.fundata.dota2.v2.history;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/25
 */
public class Dota2LeagueStatsExector extends FunDataExector {
    public Dota2LeagueStatsExector(String key, String secret) {
        super(key, secret, "/fundata-dota2-basic/league/stats");
    }

    private Form makeLeagueStatsForm(int leagueId, Integer limit, Integer offset) {
        Form form = makeLeagueForm(leagueId);
        if (limit == null || offset == null) {
            return form;
        } else {
            return form.add("limit", limit)
                    .add("offset", offset);
        }
    }

    public FunDataResult getTeamStats(int leagueId, Integer limit, Integer offset) throws ClientException {
        return clientOperation.get("/team", makeLeagueStatsForm(leagueId, limit, offset));
    }

    public FunDataResult getPlayerStats(int leagueId, Integer limit, Integer offset) throws ClientException {
        return clientOperation.get("/player", makeLeagueStatsForm(leagueId, limit, offset));
    }

    public FunDataResult getHeroStats(int leagueId, Integer limit, Integer offset) throws ClientException {
        return clientOperation.get("/hero", makeLeagueStatsForm(leagueId, limit, offset));
    }

    public FunDataResult getItemStats(int leagueId, Integer limit, Integer offset) throws ClientException {
        //TODO
        return null;
    }

    public FunDataResult getTeamFightAnalysis(int matchId) throws ClientException {
        return clientOperation.get("/team-fight-analysis", makeMatchForm(matchId));
    }

    public FunDataResult getLaneAnalysis(int matchId) throws ClientException {
        return clientOperation.get("/lane-analysis", makeMatchForm(matchId));
    }

    public FunDataResult getPlayerRoleLane(int matchId) throws ClientException {
        return clientOperation.get("/player-role-lane", makeMatchForm(matchId));
    }

    public FunDataResult getRoushanLog(int matchId) throws ClientException {
        return clientOperation.get("/roushan-log", makeMatchForm(matchId));
    }

    public FunDataResult getTowerTracking(int matchId) throws ClientException {
        return clientOperation.get("/tower-tracking", makeMatchForm(matchId));
    }

}
