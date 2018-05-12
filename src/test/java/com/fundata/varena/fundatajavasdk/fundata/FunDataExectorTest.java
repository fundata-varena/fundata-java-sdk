package com.fundata.varena.fundatajavasdk.fundata;

import org.junit.Test;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;

/**
 * @author baoyl
 * @created 2018/5/9
 */
public class FunDataExectorTest {

    private FunDataExector funDataExector = new FunDataExector("5d7be3c85c204d5", "e4d2dc9b161447c68579df94bb4d58c");

    @Test
    public void getPublicMatch() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPublicMatchBanPicks(3765833999L);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getPublicMatchBanPicks() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPublicMatchBanPicks(3765833999L);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getPublicMatchPlayers() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPublicMatchPlayers(3765833999L);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getPublicMatchPlayersAbilityUpgrades() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPublicMatchPlayersAbilityUpgrades(3765833999L);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getPublicMatchGeneralInfo() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPublicMatchGeneralInfo(3765833999L);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getBatchMatchBasicInfo() throws ClientException {
        FunDataResult funDataResult = funDataExector.getBatchMatchBasicInfo(System.currentTimeMillis(), null, 1);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getBatchMatchBanPicks() throws ClientException {
        FunDataResult funDataResult = funDataExector.getBatchMatchBanPicks(System.currentTimeMillis(), null, 1);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getBatchMatchPlayers() throws ClientException {
        FunDataResult funDataResult = funDataExector.getBatchMatchPlayers(System.currentTimeMillis(), null, 1);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getBatchMatchPlayersAbilityUpgrades() throws ClientException {
        FunDataResult funDataResult = funDataExector.getBatchMatchPlayersAbilityUpgrades(System.currentTimeMillis(), null, 1);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getPlayerBasicStats() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPlayBasicStats(100058342L);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getPlayHeroesCombineUsage() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPlayHeroesCombineUsage(100058342L);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getPlayHeroesUsage() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPlayHeroesUsage(100058342L);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getPlayWeeklyStats() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPlayWeeklyStats(100058342L, System.currentTimeMillis());
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void getPlayWeeklyHeroesUsage() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPlayWeeklyHeroesUsage(100058342L, System.currentTimeMillis());
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

}