package il.co.boj.tester;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.File;

/**
 * Created by ofer on 07/09/17.
 */

@Controller
@Log4j
public class controller {

    @Autowired
    EmailTesterConfig config;

    @Autowired
    EmailUtil emailSender;

//    @Autowired
//    Email2 email2;


    @RequestMapping(value={"/testEmail"}, method={RequestMethod.GET})
    @ResponseStatus(value= HttpStatus.OK)
    @ResponseBody
    public String testEmail() {


        File attachmentFile = new File("monster.png");

        log.debug("testing Email send");
        Integer enable =Integer.parseInt(config.getEnableTestEmail());
        if(enable !=null && enable==1){

 //           String saveTo = config.getSaveFileTo() +attachmentFile.getName();
//            try {
//                log.debug("Saving file to: [" +saveTo+"]" );
//                attachmentFile.transferTo(new File(saveTo));
//            } catch (Exception e) {
//                log.error("Could not save test file to location: [" +saveTo+"]" + e.getMessage());
//            }


            boolean send = emailSender.sendEmailWithAttachments(attachmentFile);
            if (send){
                return "Email successfully sent";
            } else {
                return "Email was not sent";
            }
        }else {
            log.debug("test Email service is not enabled. To enable, make sure property k300.email.enableTestEmail=1");
        }
        return "ok";
    }
}
