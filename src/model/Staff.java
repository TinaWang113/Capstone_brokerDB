package model;


/**
 * Staff
 * 	Containing all information for Staff object
 * @author 730693
 *
 */
public class Staff {

	private int sID;
	private String pin;
	private String isActive;
	private String fName;
	private String lName;
	private String contactNum;
	private String jobName;

	public Staff() {
		super();
	}
	/**
	 * 
	 * @param sID staff id, 4 digits, int
	 * @param pin pin Code, String
	 * @param isActive isActive, String, Y or N
	 * @param fName first name, String
	 * @param lName last name, String
	 * @param contactNum phone number, String 
	 * @param jobName job title or type, String
	 */

	public Staff(int sID, String pin, String isActive, String fName, String lName, String contactNum, String jobName) {
		super();
		this.sID = sID;
		this.pin = pin;
		this.isActive = isActive;
		this.fName = fName;
		this.lName = lName;
		this.contactNum = contactNum;
		this.jobName = jobName;
	}
	

	/**
	 * @return the sID
	 */
	public int getsID() {
		return sID;
	}
	/**
	 * @param sID the sID to set
	 */
	public void setsID(int sID) {
		this.sID = sID;
	}
	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return the contactNum
	 */
	public String getContactNum() {
		return contactNum;
	}
	/**
	 * @param contactNum the contactNum to set
	 */
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	@Override
	public String toString() {
		return "Staff [sID=" + sID + ", pin=" + pin + ", isActive=" + isActive + ", fName=" + fName + ", lName=" + lName
				+ ", contactNum=" + contactNum + ", jobName=" + jobName + "]";
	}


		

}
