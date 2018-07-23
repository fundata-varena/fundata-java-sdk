package com.fundata.varena.fundatajavasdk.fundata;

import java.util.Calendar;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.domain.http.Json;

/**
 * @author baoyl
 * @created 2018/6/5
 */
public class FunDataProExector extends FunDataExector {

    public FunDataProExector(String key, String secret) {
        super(key, secret, "/data-service/dota2");
    }

    private Json makeProJson(int period, int region, int lowQuality, int highQuality) {
        return new Json().add("period", period)
                .put("region", region)
                .put("low_quality", lowQuality)
                .put("high_quality", highQuality);
    }

    /**
     * /data-service/dota2/pro/player/{player_id}/hero-info
     * @param playerId 职业选手id
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProPlayerHeroInfo(int playerId) throws ClientException {
        return this.clientOperation.get(String.format("/pro/player/%d/hero-info", playerId));
    }

    /**
     * /data-service/dota2/pro/player/{player_id}/stats
     * @param playerId 职业选手id
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProPlayerStats(Integer playerId) throws ClientException {
        return this.clientOperation.get(String.format("/pro/player/%d/stats", playerId));
    }

    /**
     * /data-service/dota2/pro/team/{team_steam_id}/match-stats
     * @param teamSteamId 战队steamId
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProTeamMatchStats(Integer teamSteamId) throws ClientException {
        return this.clientOperation.get(String.format("/pro/team/%d/match-stats", teamSteamId));
    }

    private Form makeOffsetLimit(int offset, int limit) {
        return new Form().add("offset", offset).add("limit", limit);
    }

    /**
     * /data-service/dota2/pro/team/{team_steam_id}/hero-info
     * @param teamSteamId 战队steamId
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProTeamHeroInfo(Integer teamSteamId, Integer limit, Integer offset) throws ClientException {
        return this.clientOperation.get(String.format("/pro/team/%d/hero-info", teamSteamId), makeOffsetLimit(offset, limit));
    }

    /**
     * /data-service/dota2/pro/team/{team_steam_id}/win-rate
     * @param teamSteamId 战队steamId
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProTeamWinRate(Integer teamSteamId) throws ClientException {
        return this.clientOperation.get(String.format("/pro/team/%d/win-rate", teamSteamId));
    }

    /**
     * /data-service/dota2/pro/team/{team_steam_id}/match-stats
     * @param team1SteamId 战队1steamId
     * @param team2SteamId 战队2steamId
     * @return
     * @throws ClientException
     */
    public FunDataResult getProTeamVsStats(Integer team1SteamId, Integer team2SteamId) throws ClientException {
        return this.clientOperation.get(String.format("/pro/team/%d/%d/vs-stats", team1SteamId, team2SteamId));
    }

    /**
     * /data-service/dota2/pro/hero/overview
     * @param period period=[integer, 0: all_time, 1: 7天, 2: 30天]
     * @param region region=[integer, 0: China, 1: CIS and Russia, 2: EU, 3: NA, 4: SA, 5: SEA, 6: Global(all)]
     * @param lowQuality low_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @param highQuality high_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProHeroOverview(int period, int region, int lowQuality, int highQuality) throws ClientException {
        return this.clientOperation.get("/pro/hero/overview", makeProJson(period, region, lowQuality, highQuality));
    }

    /**
     * /data-service/dota2/pro/hero/factions
     * @param period period=[integer, 0: all_time, 1: 7天, 2: 30天]
     * @param region region=[integer, 0: China, 1: CIS and Russia, 2: EU, 3: NA, 4: SA, 5: SEA, 6: Global(all)]
     * @param lowQuality low_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @param highQuality high_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProHeroFactions(int period, int region, int lowQuality, int highQuality) throws ClientException {
        return this.clientOperation.get("/pro/hero/factions", makeProJson(period, region, lowQuality, highQuality));
    }


    /**
     * /data-service/dota2/pro/hero/priority
     * @param period period=[integer, 0: all_time, 1: 7天, 2: 30天]
     * @param region region=[integer, 0: China, 1: CIS and Russia, 2: EU, 3: NA, 4: SA, 5: SEA, 6: Global(all)]
     * @param lowQuality low_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @param highQuality high_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProHeroPriority(int period, int region, int lowQuality, int highQuality) throws ClientException {
        return this.clientOperation.get("/pro/hero/priority", makeProJson(period, region, lowQuality, highQuality));
    }

    /**
     * /data-service/dota2/pro/hero/roles
     * @param period period=[integer, 0: all_time, 1: 7天, 2: 30天]
     * @param region region=[integer, 0: China, 1: CIS and Russia, 2: EU, 3: NA, 4: SA, 5: SEA, 6: Global(all)]
     * @param lowQuality low_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @param highQuality high_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProHeroRoles(int period, int region, int lowQuality, int highQuality) throws ClientException {
        return this.clientOperation.get("/pro/hero/roles", makeProJson(period, region, lowQuality, highQuality));
    }

    /**
     * /data-service/dota2/pro/hero/lanes
     * @param period period=[integer, 0: all_time, 1: 7天, 2: 30天]
     * @param region region=[integer, 0: China, 1: CIS and Russia, 2: EU, 3: NA, 4: SA, 5: SEA, 6: Global(all)]
     * @param lowQuality low_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @param highQuality high_quality=[integer, 0: minor预选赛, 1: major预选赛, 2: minor, 3: major]
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProHeroLanes(int period, int region, int lowQuality, int highQuality) throws ClientException {
        return this.clientOperation.get("/pro/hero/lanes", makeProJson(period, region, lowQuality, highQuality));
    }

    private Form makePageLimit(int page, int limit) {
        return new Form().add("page", page).add("limit", limit);
    }

    /**
     * /data-service/dota2/pro/league/{league_id}/base-info
     * @param leagueId 联赛Id
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProLeagueBaseInfo(int leagueId) throws ClientException {
        return this.clientOperation.get(String.format("/pro/league/%d/base-info", leagueId));
    }

    /**
     * /data-service/dota2/pro/league/ti/rank-player
     * @param page page
     * @param limit limit
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProTiRankPlayer(int page, int limit) throws ClientException {
        return this.clientOperation.get("/pro/league/ti/rank-player", makePageLimit(page, limit));
    }

    /**
     * /data-service/dota2/pro/league/ti/rank-team
     * @param page page
     * @param limit limit
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProTiRankTeam(int page, int limit) throws ClientException {
        return this.clientOperation.get("/pro/league/ti/rank-team", makePageLimit(page, limit));
    }

    /**
     * /data-service/dota2/pro/league/list
     * @param page page
     * @param limit limit
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProLeagueList(int page, int limit) throws ClientException {
        return this.clientOperation.get("/pro/league/list", makePageLimit(page, limit));
    }

    /**
     * /data-service/dota2/pro/league/list
     * @param page page
     * @param limit limit
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProLeagueRank(int page, int limit) throws ClientException {
        return this.clientOperation.get("/pro/league/league-rank", makePageLimit(page, limit));
    }
}
