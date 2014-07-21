package core.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @summary:
 * 		业务层的日志
 */
public class BusinessLog {
	private static final SimpleDateFormat sdf = new SimpleDateFormat(core.constant.constant.DATE_FORMAT);
	
	private Integer id;
	
	private String  userName;
	
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private Date  startTime = new Date();
	
	//地址栏请求的数据的地址(此处可将地址栏请请求参数绑定到同一个字段中，
	//当然可以将他们分开，另外也可以通过uri做很多的判断)
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
		return "ServiceLog [id=" + id + ", userName=" + userName + ", startTime=" + sdf.format(startTime) + ", uri=" + uri + ", operationName=" + operationName + ", operationParam=" + operationParam + ", result=" + result + ", msg=" + msg + "]";
	}
	
}
