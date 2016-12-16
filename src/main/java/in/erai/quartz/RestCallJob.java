package in.erai.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.client.RestTemplate;

import in.erai.domain.Message;

public class RestCallJob implements Job {

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        RestTemplate restTemplate = new RestTemplate();

        Message message = restTemplate.getForObject
                ("http://localhost:8080/SpringBatchRestService/jobs/importUserJob", Message.class);
        System.out.println(message.getjobId());
        System.out.println(message.getjobExecutionStatus());

    }

}
