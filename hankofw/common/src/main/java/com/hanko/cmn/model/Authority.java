package com.hanko.cmn.model;

import lombok.Data;

/**
 * @author Mr.Yangxiufeng
 * @date 2020-10-29
 * @time 14:38
 */
@Data
public class Authority {
    private String authority;

    public Authority(String auth){
        this.authority = auth;
    }
}
