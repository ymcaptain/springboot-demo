package com.jovi.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jovi.entity.UserEntity;
import com.jovi.model.param.UserParam;
import com.jovi.model.vo.ResponseVo;
import com.jovi.service.UserService;
import com.jovi.util.BuildResponseUtils;
import com.jovi.util.CommonQueryPageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器（一个demo用于大家学习参考）
 *
 */

@RestController
@Api(tags = "用户控制器")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增
     * @param entity 实体
     * @return ResponseVo
     */
    @ApiOperation("新增")
    @PostMapping("user")
    public ResponseVo<?> add(UserEntity entity) {
        return userService.save(entity) ? BuildResponseUtils.success() : BuildResponseUtils.error();
    }

    /**
     * 通过id查询
     *
     * @param id 自增主键
     * @return ResponseVo
     */
    @ApiOperation("通过id查询")
    @GetMapping("user/{id}")
    public ResponseVo<UserEntity> getById(@PathVariable String id) {
        return BuildResponseUtils.buildResponse(userService.getById(id));
    }

    /**
     * 更新
     *
     * @param entity 实体
     * @return ResponseVo
     */
    @ApiOperation("更新")
    @PutMapping("user")
    public ResponseVo<?> update(UserEntity entity) {
        return userService.updateById(entity) ? BuildResponseUtils.success() : BuildResponseUtils.error();
    }

    /**
     * 通过id删除
     *
     * @param id 自增主键
     * @return ResponseVo
     */
    @ApiOperation("通过id删除")
    @DeleteMapping("user/{id}")
    public ResponseVo<?> delete(@PathVariable String id) {
        return userService.removeById(id) ? BuildResponseUtils.success() : BuildResponseUtils.error();
    }

    /**
     * 分页查询
     *
     * @param param 请求参数
     * @return ResponseVo
     */
    @ApiOperation("分页查询")
    @GetMapping("userPage")
    public ResponseVo<IPage<UserEntity>> selectPage(UserParam param) {
        return BuildResponseUtils.buildResponse(CommonQueryPageUtils.commonQueryPage(param, userService));
    }

}
