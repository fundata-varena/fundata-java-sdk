package com.fundata.varena.fundatajavasdk.fundata;

import java.io.IOException;

import org.junit.Test;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;

/**
 * @author baoyl
 * @created 2018/5/9
 */
public class FunDataTest {

    private FunDataExector funDataExector = new FunDataExector("5d7be3c85c204d5", "e4d2dc9b161447c68579df94bb4d58c");

    @Test
    public void testPublicMatch() throws ClientException {
        FunDataResult funDataResult = funDataExector.getPublicMatchBanPicks(3765833999L);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void testBatchMatchBasicInfo() throws ClientException {
        FunDataResult funDataResult = funDataExector.getBatchMatchBasicInfo(System.currentTimeMillis(), null, 1);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void testBatchMatchBanPicks() throws ClientException {
        FunDataResult funDataResult = funDataExector.getBatchMatchBanPicks(System.currentTimeMillis(), null, 1);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void testBatchMatchPlayers() throws ClientException {
        FunDataResult funDataResult = funDataExector.getBatchMatchPlayers(System.currentTimeMillis(), null, 1);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }

    @Test
    public void testBatchMatchPlayersAbilityUpgrades() throws ClientException {
        FunDataResult funDataResult = funDataExector.getBatchMatchPlayersAbilityUpgrades(System.currentTimeMillis(), null, 1);
        System.out.println(funDataResult.getRetcode());
        System.out.println(funDataResult.getMessage());
        System.out.println(funDataResult.getData());
    }
}