package il.co.boj.tester;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ofer on 07/09/17.
 */
@Configuration
@ConfigurationProperties(prefix = "k300")
@Data
public class EmailTesterConfig {

    String password;
    String userName;
    String host;
    String port;
    String toAddress;
    String subject;
    String message;

    String enableTestEmail;
    String saveFileTo;
    String sentFrom;


}
