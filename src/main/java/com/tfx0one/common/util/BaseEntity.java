package com.tfx0one.common.util;

/*
 * Create by 2fx0one on 2/6/18
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
}
