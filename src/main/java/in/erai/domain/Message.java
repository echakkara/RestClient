package in.erai.domain;

public class Message {

    String jobId;
    String jobExecutionStatus;
    public Message(String jobId, String jobExecutionStatus) {
        this.jobId = jobId;
        this.jobExecutionStatus = jobExecutionStatus;
    }
public Message() {

}
    public String getJobId() {
    return jobId;
}
public void setJobId(String jobId) {
    this.jobId = jobId;
}

public void setJobExecutionStatus(String jobExecutionStatus) {
    this.jobExecutionStatus = jobExecutionStatus;
}
    public String getjobId() {
        return jobId;
    }

    public String getjobExecutionStatus() {
        return jobExecutionStatus;
    }

}