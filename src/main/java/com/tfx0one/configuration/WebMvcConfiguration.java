package com.tfx0one.configuration;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    //关键，将拦截器作为bean写入配置中 废弃的拦截器
//    @Bean
//    public WXAuthInterceptor getWXAuthInterceptor(){
//        return new WXAuthInterceptor();
//    }
//
//    @Bean
//    public AuthInterceptor getAuthInterceptor(){
//        return new AuthInterceptor();
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");//设置访问的IP和端口，此代表所有都可以访问
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getAuthInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(
//                        "/swagger-resources/**",
//                        //给微信使用的
////                        "/api/v1/wechat/**",
//                        "/api/v1/wechat/createSession", //连接到服务器
//                        "/api/v1/wechat/productList", //商品和商品详情
//                        "/api/v1/wechat/productDetail", //商品和商品详情
//
//                        //给后台使用的
//                        "/static/**",
//                        //登录页面
//                        "/login"
////                        "/dark-velvet-css/**",
////                        "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/**/fonts/*", //不拦截静态资源
////                        "/index"
//                ); // 不进行登录拦截的

//        registry.addInterceptor(getWXAuthInterceptor())
//                .addPathPatterns("/api/v1/wechat/**")
//                .excludePathPatterns(
//                        //给微信使用的
//                        "/api/v1/wechat/**",
//                        "/api/v1/wechat/createSession", //连接到服务器
//                        "/api/v1/wechat/productList", //商品和商品详情
//                        "/api/v1/wechat/productDetail", //商品和商品详情
//
//                        //给后台使用的
//                        "/static/**",
//                        //登录页面
//                        "/login"
////                        "/dark-velvet-css/**",
////                        "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/**/fonts/*", //不拦截静态资源
////                        "/index"
//                ); // 不进行登录拦截的
    }

    //fastjson
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        List<MediaType> mediaTypeList = new ArrayList<MediaType>();
        mediaTypeList.add(new MediaType("application", "json", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("application", "json", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("text", "html", Charset.forName("UTF-8")));
        fastConverter.setSupportedMediaTypes(mediaTypeList);

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setFeatures(Feature.AllowArbitraryCommas, Feature.AllowUnQuotedFieldNames, Feature.DisableCircularReferenceDetect);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }
}
