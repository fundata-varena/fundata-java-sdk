package com.fundata.varena.fundatajavasdk.fundata;

import java.util.Calendar;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.domain.http.Json;

/**
 * fundata执行器
 *
 * @author baoyl
 * @created 2018/5/10
 */
public class FunDataExector {
    private HttpClientTemplate clientOperation;

    FunDataExector(String key, String secret) {
        this.clientOperation = new HttpClientTemplate("api.varena.com", "/data-service/dota2", key, secret);
    }

    public FunDataResult commonForm(String url, Form form) throws ClientException {
        return this.clientOperation.get(url, form);
    }

    public FunDataResult commonJson(String url, Json json) throws ClientException {
        return this.clientOperation.get(url, json);
    }

    /**
     * /data-service/dota2/public/match/{match_id}/basic_info
     *
     * @param matchId 比赛编号
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPublicMatchBasicInfo(Long matchId) throws ClientException {
        return this.clientOperation.get(String.format("/public/match/%d/basic_info", matchId));
    }

    /**
     * /data-service/dota2/public/match/{match_id}/ban_picks
     *
     * @param matchId 比赛编号
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPublicMatchBanPicks(Long matchId) throws ClientException {
        return this.clientOperation.get(String.format("/public/match/%d/ban_picks", matchId));
    }

    /**
     * /data-service/dota2/public/match/{match_id}/players
     *
     * @param matchId 比赛编号
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPublicMatchPlayers(Long matchId) throws ClientException {
        return this.clientOperation.get(String.format("/public/match/%d/players", matchId));
    }

    /**
     * /data-service/dota2/public/match/{match_id}/players_ability_upgrades
     *
     * @param matchId 比赛编号
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPublicMatchPlayersAbilityUpgrades(Long matchId) throws ClientException {
        return this.clientOperation.get(String.format("/public/match/%d/players_ability_upgrades", matchId));
    }

    /**
     * /data-service/dota2/public/match/{match_id}/general_info
     *
     * @param matchId 比赛编号
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPublicMatchGeneralInfo(Long matchId) throws ClientException {
        return this.clientOperation.get(String.format("/public/match/%d/general_info", matchId));
    }

    /**
     * 构造批量请求参数
     *
     * @param startTime    开始时间
     * @param startMatchId 开始比赛编号
     * @param limit        结果数量
     * @return Json
     */
    private Json makeBatchQuery(Long startTime, Long startMatchId, int limit) {
        limit = limit < 0 ? 0 : limit;
        limit = limit > 200 ? 200 : limit;
        return new Json().add("start_time", startTime).put("start_from", startMatchId).put("limit", limit);
    }

    /**
     * /data-service/dota2/public/batch/match/basic_info
     *
     * @param startTime    表示取哪个时间之后的数据； 当需要通过某一次的返回结果取之后的比赛信息时需要设置为当前获取的结果的数组的最后一个 match_start_time
     * @param startMatchId 当需要通过某一次的返回结果取之后的比赛信息时需要用到，设置为当前获取的结果的数组的最后一个match_id
     * @param limit        取值范围为 [0,200]，表示返回最多多少结果，limit 不传或者为0时，返回100条数据
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getBatchMatchBasicInfo(Long startTime, Long startMatchId, int limit) throws ClientException {
        return this.clientOperation.get("/public/batch/match/basic_info", makeBatchQuery(startTime, startMatchId, limit));
    }

    /**
     * /data-service/dota2/public/batch/match/ban_picks
     *
     * @param startTime    表示取哪个时间之后的数据； 当需要通过某一次的返回结果取之后的比赛信息时需要设置为当前获取的结果的数组的最后一个 match_start_time
     * @param startMatchId 当需要通过某一次的返回结果取之后的比赛信息时需要用到，设置为当前获取的结果的数组的最后一个match_id
     * @param limit        取值范围为 [0,200]，表示返回最多多少结果，limit 不传或者为0时，返回100条数据
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getBatchMatchBanPicks(Long startTime, Long startMatchId, int limit) throws ClientException {
        return this.clientOperation.get("/public/batch/match/ban_picks", makeBatchQuery(startTime, startMatchId, limit));
    }

    /**
     * /data-service/dota2/public/batch/match/players
     *
     * @param startTime    表示取哪个时间之后的数据； 当需要通过某一次的返回结果取之后的比赛信息时需要设置为当前获取的结果的数组的最后一个 match_start_time
     * @param startMatchId 当需要通过某一次的返回结果取之后的比赛信息时需要用到，设置为当前获取的结果的数组的最后一个match_id
     * @param limit        取值范围为 [0,200]，表示返回最多多少结果，limit 不传或者为0时，返回100条数据
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getBatchMatchPlayers(Long startTime, Long startMatchId, int limit) throws ClientException {
        return this.clientOperation.get("/public/batch/match/players", makeBatchQuery(startTime, startMatchId, limit));
    }

    /**
     * /data-service/dota2/public/batch/match/players_ability_upgrades
     *
     * @param startTime    表示取哪个时间之后的数据； 当需要通过某一次的返回结果取之后的比赛信息时需要设置为当前获取的结果的数组的最后一个 match_start_time
     * @param startMatchId 当需要通过某一次的返回结果取之后的比赛信息时需要用到，设置为当前获取的结果的数组的最后一个match_id
     * @param limit        取值范围为 [0,200]，表示返回最多多少结果，limit 不传或者为0时，返回100条数据
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getBatchMatchPlayersAbilityUpgrades(Long startTime, Long startMatchId, int limit) throws ClientException {
        return this.clientOperation.get("/public/batch/match/players_ability_upgrades", makeBatchQuery(startTime, startMatchId, limit));
    }

    private Json makeWeek(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return new Json().add("week", String.format("%d_%d", Calendar.YEAR, Calendar.WEEK_OF_YEAR));
    }

    /**
     * /data-service/dota2/analysis/player/{player_id}/basic_stats
     *
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayBasicStats(Long playerId) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/basic_stats", playerId));
    }

    /**
     * /data-service/dota2/analysis/player/{player_id}/heroes_combine_usage
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayHeroesCombineUsage(Long playerId) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/heroes_combine_usage", playerId));
    }

    /**
     * /data-service/dota2/analysis/player/{player_id}/heroes_usage
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayHeroesUsage(Long playerId) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/heroes_usage", playerId));
    }

    /**
     * /data-service/dota2/analysis/player/{player_id}/weekly_stats
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayWeeklyStats(Long playerId, Long time) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/weekly_stats", playerId), makeWeek(time));
    }

    /**
     * /data-service/dota2/analysis/player/{player_id}/weekly_heroes_usage
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayWeeklyHeroesUsage(Long playerId, Long time) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/weekly_heroes_usage", playerId), makeWeek(time));
    }

    private Json makeProJson(int period, int region, int lowQuality, int highQuality) {
        return new Json().add("period", period)
                .put("region", region)
                .put("low_quality", lowQuality)
                .put("high_quality", highQuality);
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
     * /data-service/dota2/pro/team/{team_steam_id}/hero-info
     * @param teamSteamId 战队steamId
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProTeamHeroInfo(Integer teamSteamId) throws ClientException {
        return this.clientOperation.get(String.format("/pro/team/%d/hero-info", teamSteamId));
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
     * /data-service/dota2/pro/team/{team_steam_id}/win-rate
     * @param teamSteamId 战队steamId
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getProTeamWinRate(Integer teamSteamId) throws ClientException {
        return this.clientOperation.get(String.format("/pro/team/%d/win-rate", teamSteamId));
    }

    private Form makePageLimit(int page, int limit) {
        return new Form().add("page", page).add("limit", limit);
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
    public FunDataResult getTiRankPlayer(int page, int limit) throws ClientException {
        return this.clientOperation.get("/pro/league/ti/rank-player", makePageLimit(page, limit));
    }

    /**
     * /data-service/dota2/pro/league/ti/rank-team
     * @param page page
     * @param limit limit
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getTiRankTeam(int page, int limit) throws ClientException {
        return this.clientOperation.get("/pro/league/ti/rank-team", makePageLimit(page, limit));
    }
}
