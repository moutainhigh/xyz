package rebue.xyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 这个注解是为了使该包内的过滤器生效。
@ServletComponentScan("rebue.sbs.smx.filter")
@SpringCloudApplication
@EnableFeignClients(basePackages = { "rebue.kdi.svr.feign",  "rebue.suc.svr.feign" })
public class XyzApplication {
    public static void main(final String[] args) {
        SpringApplication.run(XyzApplication.class, args);
    }

}