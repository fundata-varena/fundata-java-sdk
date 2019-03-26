package com.fundata.varena.fundatajavasdk.fundata.dota2.v2.pub;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.fundata.FunDataExector;

/**
 * @author baoyl
 * @created 2019/3/25
 */
public class Dota2LeagueExector extends FunDataExector {

    public Dota2LeagueExector(String key, String secret) {
        super(key, secret, "/fundata-dota2-free/v2/league");
    }

    private Form makePageByPageSize(int pageSize, int page) {
        return new Form().add("page_size", pageSize)
                .add("page", page);
    }

    private Form makePageByLimit(int page, int limit) {
        return new Form().add("page", page).add("limit", limit);
    }

    public FunDataResult getLeagueList(int pageSize, int page) throws ClientException {
        return clientOperation.get("/list", makePageByPageSize(pageSize, page));
    }

    public FunDataResult getLeagueDetail(int leagueId) throws ClientException {
        Form form = new Form().add("league_id", leagueId);
        return clientOperation.get("/detail", form);
    }

    public FunDataResult getLeaguePlayer(int playerId) throws ClientException {
        Form form = new Form().add("player_id", playerId);
        return clientOperation.get("/player", form);
    }

    public FunDataResult getLeagueTeam(int page, int limit) throws ClientException {
        return clientOperation.get("/team", makePageByLimit(page, limit));
    }
}
