package app.model;
/**
 * 
 * @Summary:
 * 		基于请求地址的权限控制实体
 */
public class Right {
	//权限ID
	private Integer RightId;
	
	//权限名称
	private String RightName;
	
	//权限请求地址
	private String RightDesc;
	
	//请求地址
	private String uri;
	
	//权限组
	private int	RigthPos;
	
	//权限码
	private long RigthCode;



	public Integer getRightId() {
		return RightId;
	}

	public void setRightId(Integer rightId) {
		RightId = rightId;
	}

	public String getRightName() {
		return RightName;
	}

	public void setRightName(String rightName) {
		RightName = rightName;
	}

	public String getRightDesc() {
		return RightDesc;
	}

	public void setRightDesc(String rightDesc) {
		RightDesc = rightDesc;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getRigthPos() {
		return RigthPos;
	}

	public void setRigthPos(int rigthPos) {
		RigthPos = rigthPos;
	}

	public long getRigthCode() {
		return RigthCode;
	}

	public void setRigthCode(long rigthCode) {
		RigthCode = rigthCode;
	}
	
	
}
