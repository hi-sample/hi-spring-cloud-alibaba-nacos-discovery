package net.hifor.demo.controller;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IKin <br/>
 * @description 第一个spring cloud alibaba  <br/>
 * @date 2019/11/17 <br/>
 */
@RestController
@RefreshScope
public class HelloController {

    @Resource
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    /**
     * 第一个方法
     *
     * @return
     */
    @GetMapping("/")
    public String hello() {
        return "Hello Spring Cloud Alibaba!";
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/sleep")
    public String sleep() {
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "hello Nacos Discovery " + string;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        if (b == 0) {
            return String.valueOf(0);
        }
        else {
            return String.valueOf(a / b);
        }
    }

    @GetMapping("/zone")
    public String zone() {
        Map<String, String> metadata = nacosDiscoveryProperties.getMetadata();
        return "provider zone " + metadata.get("zone");
    }
}
