package com.fundata.varena.fundatajavasdk.fundata;

import java.io.IOException;

import org.apache.http.protocol.HttpRequestExecutor;
import org.junit.Test;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;

/**
 * @author baoyl
 * @created 2018/5/9
 */
public class HttpClientTemplateTest {

    @Test
    public void testGet() throws ClientException, IOException {
        FunDataExector funDataExector = new FunDataExector("5d7be3c85c204d5", "e4d2dc9b161447c68579df94bb4d58c");
    }
}