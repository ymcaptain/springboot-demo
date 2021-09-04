package com.jovi.controller;

import com.jovi.model.vo.ResponseVo;
import com.jovi.util.BuildResponseUtils;
import com.jovi.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * redis控制器
 */

@RequestMapping("/redis")
@RestController
@Api(tags = "Redis控制器")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 设置缓存
     *
     * @param key   key
     * @param value value
     * @return ResponseVo
     */
    @ApiOperation("设置缓存")
    @PostMapping("add")
    public ResponseVo<?> add(String key, String value) {
        redisUtils.set(key, value, 600);
        return BuildResponseUtils.success();
    }

    /**
     * 通过key查询
     *
     * @param key key
     * @return ResponseVo
     */
    @ApiOperation("通过key查询")
    @GetMapping("{key}")
    public ResponseVo<Object> getByKey(@PathVariable String key) {
        String value = (String) redisUtils.get(key);
        return BuildResponseUtils.buildResponse(value);
    }

    /**
     * 通过key删除
     *
     * @param key key
     * @return ResponseVo
     */
    @ApiOperation("通过key删除")
    @DeleteMapping("{key}")
    public ResponseVo<?> delete(@PathVariable String key) {
        return redisUtils.delete(key) ? BuildResponseUtils.success() : BuildResponseUtils.error();
    }
}
