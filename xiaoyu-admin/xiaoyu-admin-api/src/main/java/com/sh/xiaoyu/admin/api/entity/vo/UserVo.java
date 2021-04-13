package com.sh.xiaoyu.admin.api.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sh.xiaoyu.admin.api.entity.bo.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: LHL
 * @ProjectName: sh-xiaoyu
 * @Package: com.sh.xiaoyu.admin.api.entity.vo
 * @ClassName: UserVo
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
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
     * 0无效 1有效
     */
    private Integer status;

    /**
     * 0无效 1有效
     */
    private boolean blStatus;
    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "token")
    private String accessToken;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "公司名称")
    private String compName;


    /**
     * bo转vo
     * @param user
     * @return
     */
    public UserVo buildVo(User user){
        BeanUtils.copyProperties(user,this);
        return this;
    }

    /**
     * bo转vo
     * @param list
     * @return
     */
    public List<UserVo> buildVoList(List<User> list){
        List<UserVo> voList = new ArrayList<>();
        if(CollectionUtils.isEmpty(list)){
            return voList;
        }
        list.forEach(item ->{
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(item,vo);
            voList.add(vo);
        });
        return voList;
    }
}
