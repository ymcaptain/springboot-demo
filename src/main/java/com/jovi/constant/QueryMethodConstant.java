/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jovi.constant;

/**
  * mybatis plus常用的查询方式
  */

public interface QueryMethodConstant {
    /**
     * 相同
     */
    String EQ = "EQ";

    /**
     * 不相同
     */
    String NE = "NE";

    /**
     * 相似，左右模糊(like '%值%')
     */
    String LIKE = "LIKE";

    /**
     * 相似，左模糊(like '%值')
     */
    String LIKE_LIFT = "LIKE_LIFT";

    /**
     * 相似，右模糊(like '值%')
     */
    String LIKE_RIGHT = "LIKE_RIGHT";

    /**
     * 不相似 (not like '%值%')
     */
    String NOT_LIKE = "NOT_LIKE";

    /**
     * 大于
     */
    String GT = "GT";

    /**
     * 大于等于
     */
    String GE = "GE";

    /**
     * 小于
     */
    String LT = "LT";

    /**
     * 小于等于
     */
    String LE = "LE";
}