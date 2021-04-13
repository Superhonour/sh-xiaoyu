package com.sh.xiaoyu.admin.api.entity.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sh.xiaoyu.admin.api.entity.dto.UserDto;
import com.sh.xiaoyu.common.base.bo.BaseBo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.entity.bo
 * @ClassName: User
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@TableName("sys_user")
@ApiModel(value = "User",description = "用户设置")
public class User extends BaseBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 1:男 2:女
     */
    private Integer sex;

    /**
     * 生日
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime birthday;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 住址
     */
    private String address;

    /**
     * 用户类型 1:后台用户 0:前台用户
     */
    private Integer userType;

    /**
     * 后台用户头像
     */
    private String headImage;

    /**
     * 部门id 一个用户只有 一个部门
     */
    private String deptId;

    /**
     * 公司id
     */
    private String compId;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime lastLoginTime;

    /**
     * 是否删除 (1是  0否)
     */
    private Integer isDeleted;

    /**
     * 0无效 1有效
     */
    private Integer status;


    /**
     *   dto转bo
     */
    public User buildBo(UserDto userDto){
        BeanUtils.copyProperties(userDto,this);
        return this;
    }

}
