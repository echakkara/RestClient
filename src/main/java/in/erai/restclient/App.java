package in.erai.restclient;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.erai.quartz.RestCallJob;
/**
 * Hello world!
 *
 */
public class App {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static void main(String[] args) throws SchedulerException {

        // specify the job' s details..
        JobDetail job = JobBuilder.newJob(RestCallJob.class).withIdentity("restClient").build();
        // specify the running period of the job
        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(30).repeatForever()).build();

        // schedule the job
        SchedulerFactory schFactory = new StdSchedulerFactory();
        Scheduler sch = schFactory.getScheduler();
        sch.start();
        sch.scheduleJob(job, trigger);
        //System.out.println("Hello World!");
    }
}
