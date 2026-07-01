package com.eis_project.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * packageName   : com.eis_project.config
 * fileName      : MybatisConfig
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Configuration
@MapperScan(basePackages = "com.eis_project.**.repository")
public class MybatisConfig {
}
