package com.example.docker.composes.demo.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品审核记录
 * </p>
 *
 * @author qy
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="PmsProductVertifyRecord对象", description="商品审核记录")
public class PmsProductVertifyRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productId;

    private LocalDateTime createTime;

    @ApiModelProperty(value = "审核人")
    private String vertifyMan;

    private Integer status;

    @ApiModelProperty(value = "反馈详情")
    private String detail;


}
