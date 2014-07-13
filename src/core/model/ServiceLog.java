package core.model;

import java.util.Date;

public class ServiceLog {
	private Integer id;
	
	private String  userName;
	
	private Date  startTime = new Date();
	
	private String uri;
	
	private String operationName;
	
	private String operationParam;
	
	private String result;
	
	private String msg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationParam() {
		return operationParam;
	}

	public void setOperationParam(String operationParam) {
		this.operationParam = operationParam;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ServiceLog [id=" + id + ", userName=" + userName + ", startTime=" + startTime + ", uri=" + uri + ", operationName=" + operationName + ", operationParam=" + operationParam + ", result=" + result + ", msg=" + msg + "]";
	}
	
}
