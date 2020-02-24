package model;

public class Job {
	private int jobID;
	private String jobName;

	public Job() {
		super();
	}

	public Job(int jobID, String jobName) {
		super();
		this.jobID = jobID;
		this.jobName = jobName;
	}

	public int getjobID() {
		return jobID;
	}

	public void setjobID(int jobID) {
		this.jobID = jobID;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}
