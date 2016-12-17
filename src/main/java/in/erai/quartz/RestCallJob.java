package in.erai.quartz;

import java.util.Arrays;
import java.util.Base64;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.erai.domain.Message;

public class RestCallJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobName = dataMap.getString("jobName");
        String appJobsLink = dataMap.getString("appJobsLink");
        String restUrl = appJobsLink + jobName;
        System.out.println("restUrl :: " + restUrl);
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity<Message> response =  restTemplate.exchange(
                restUrl , HttpMethod.GET, request, Message.class);
        Message message = response.getBody();
        //Message message = restTemplate.getForObject
          //      (restUrl, Message.class);
        System.out.println(message.getjobId());
        System.out.println(message.getjobExecutionStatus());

    }
    private static HttpHeaders getHeaders(){
        String plainCredentials="batchadmin:batchadmin";
        String base64Credentials = new String(Base64.getEncoder().encodeToString(plainCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
