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
	private int	RightPos;
	
	//权限码
	private long RightCode;

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

	public int getRightPos() {
		return RightPos;
	}

	public void setRightPos(int rightPos) {
		RightPos = rightPos;
	}

	public long getRightCode() {
		return RightCode;
	}

	public void setRightCode(long rightCode) {
		RightCode = rightCode;
	}

	@Override
	public String toString() {
		return "Right [RightId=" + RightId + ", RightName=" + RightName + ", RightDesc=" + RightDesc + ", uri=" + uri + ", RightPos=" + RightPos + ", RightCode=" + RightCode + "]";
	}
	
	
}
