package com.fundata.varena.fundatajavasdk.fundata.dota2.v1;

import java.util.Calendar;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Json;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2018/6/5
 */
public class FunDataPlayerExector extends FunDataExector {

    public FunDataPlayerExector(String key, String secret) {
        super(key, secret, "/data-service/dota2");
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
    public FunDataResult getPlayerBasicStats(Long playerId) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/basic_stats", playerId));
    }

    /**
     * /data-service/dota2/analysis/player/{player_id}/heroes_combine_usage
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayerHeroesCombineUsage(Long playerId) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/heroes_combine_usage", playerId));
    }

    /**
     * /data-service/dota2/analysis/player/{player_id}/heroes_usage
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayerHeroesUsage(Long playerId) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/heroes_usage", playerId));
    }

    /**
     * /data-service/dota2/analysis/player/{player_id}/weekly_heroes_usage
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayerWeeklyHeroesUsage(Long playerId, Long time) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/weekly_heroes_usage", playerId), makeWeek(time));
    }

    /**
     * /data-service/dota2/analysis/player/{player_id}/weekly_stats
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayerWeeklyStats(Long playerId, Long time) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/weekly_stats", playerId), makeWeek(time));
    }

    /**
     * /data-service/dota2/public/player/{player_id}/match_ids
     * @param playerId 玩家在 Dota2 上的账户ID
     * @return FunDataResult
     * @throws ClientException
     */
    public FunDataResult getPlayerMatchIds(Long playerId) throws ClientException {
        return this.clientOperation.get(String.format("/analysis/player/%d/match_ids", playerId));
    }
}
