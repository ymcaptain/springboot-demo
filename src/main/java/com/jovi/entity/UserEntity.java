    package com.jovi.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.io.Serializable;

    /**
     * 用户信息实体类
     *
     */

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel(value = "UserEntity", description = "用户实体")
    @TableName("t_user")
    public class UserEntity implements Serializable {

        private static final long serialVersionUID = 6928834261563057243L;

        /**
         * 唯一标识，自增主键
         */
        @ApiModelProperty(value = "id")
        @TableId(value = "id", type = IdType.AUTO)
        private Long id;

        /**
         * 姓名
         */
        @ApiModelProperty(value = "姓名")
        @TableField("name")
        private String name;

        /**
         * 年龄
         */
        @ApiModelProperty(value = "年龄")
        @TableField("age")
        private Integer age;
    }
