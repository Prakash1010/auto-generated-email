package edu.loganalyst.shared;

import java.io.Serializable;

public class LogData implements Serializable {
	private String time = "";
	private String part2 = "";
	private String type = "";
	private String part3 = "";
	private String part4 = "";
	private String errorData = "";

	public String getErrorData() {
		return errorData;
	}

	public void setErrorData(String errorData) {
		this.errorData = errorData;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPart2() {
		return part2;
	}

	public void setPart2(String part2) {
		this.part2 = part2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPart3() {
		return part3;
	}

	public void setPart3(String part3) {
		this.part3 = part3;
	}

	public String getPart4() {
		return part4;
	}

	public void setPart4(String part4) {
		this.part4 = part4;
	}

}
