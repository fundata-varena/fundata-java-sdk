package com.fundata.varena.fundatajavasdk.domain.entity;

import com.fundata.varena.fundatajavasdk.domain.BaseBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * fundata dota2请求结果实体
 * @author baoyl
 * @created 2018/5/9
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class FunDataResult extends BaseBean {
    private static final long serialVersionUID = 2839929345094299990L;

    @NonNull
    private Integer retcode;
    @NonNull
    private String message;
    private Object data;

}
