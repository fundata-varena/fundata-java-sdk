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

}
