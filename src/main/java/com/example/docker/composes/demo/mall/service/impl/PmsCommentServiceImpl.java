package com.example.docker.composes.demo.mall.service.impl;

import com.example.docker.composes.demo.mall.entity.PmsComment;
import com.example.docker.composes.demo.mall.mapper.PmsCommentMapper;
import com.example.docker.composes.demo.mall.service.IPmsCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author qy
 * @since 2020-08-05
 */
@Service
public class PmsCommentServiceImpl extends ServiceImpl<PmsCommentMapper, PmsComment> implements IPmsCommentService {

}
