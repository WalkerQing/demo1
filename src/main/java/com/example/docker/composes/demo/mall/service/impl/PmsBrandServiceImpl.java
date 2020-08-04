package com.example.docker.composes.demo.mall.service.impl;

import com.example.docker.composes.demo.mall.entity.PmsBrand;
import com.example.docker.composes.demo.mall.mapper.PmsBrandMapper;
import com.example.docker.composes.demo.mall.service.IPmsBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author qy
 * @since 2020-08-04
 */
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements IPmsBrandService {

}
