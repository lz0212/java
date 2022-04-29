package com.cy.store.util;

public class R {
    public Boolean flag;
    public Object data;

    public R(){}

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
