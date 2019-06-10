package com.fundata.varena.fundatajavasdk.fundata;

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
    /**
     * 域名
     */
    private static final String VARENA_HOST = "api.varena.com";
    protected HttpClientTemplate clientOperation;

    public FunDataExector(String key, String secret, String rootPath) {
        this.clientOperation = new HttpClientTemplate(VARENA_HOST, rootPath, key, secret);
    }

    protected Form makeMatchForm(int matchId) {
        return new Form().add("match_id", matchId);
    }

    protected Form makeMatchForm(String matchId) {
        return new Form().add("match_id", matchId);
    }

    protected Form makeScheduleForm(String scheduleId) {
        return new Form().add("schedule_id", scheduleId);
    }

    protected Form makePageByPageSize(int pageSize, int page) {
        return new Form().add("page_size", pageSize)
                .add("page", page);
    }

    protected Form makePageByLimit(int page, int limit) {
        return new Form().add("page", page).add("limit", limit);
    }

    protected Form makeLeagueForm(int leagueId) {
        return new Form().add("league_id", leagueId);
    }

    protected Form makePlayerForm(int playerId) {
        return new Form().add("player_id", playerId);
    }

    public FunDataResult commonForm(String url, Form form) throws ClientException {
        return this.clientOperation.get(url, form);
    }

    public FunDataResult commonJson(String url, Json json) throws ClientException {
        return this.clientOperation.get(url, json);
    }

}
