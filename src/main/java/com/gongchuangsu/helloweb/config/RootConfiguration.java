package com.gongchuangsu.helloweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(SecurityConfig.class)
public class RootConfiguration {
}