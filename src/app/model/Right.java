package app.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @Summary:
 * 		基于请求地址的权限控制实体
 */
public class Right {
	//权限ID
	@Getter @Setter private Integer RightId;
	
	//权限名称
	@Getter @Setter private String RightName ="未命名";
	
	//权限请求地址
	@Getter @Setter private String RightDesc;
	
	//是否是公有模块
	@Getter @Setter private boolean isPublic = false;
	
	//请求地址
	@Getter @Setter private String uri;
	
	//权限组
	@Getter @Setter private int	RightPos;
	
	//权限码
	@Getter @Setter private long RightCode;

	@Override
	public String toString() {
		return "Right [RightId=" + RightId + ", RightName=" + RightName + ", RightDesc=" + RightDesc + ", uri=" + uri + ", RightPos=" + RightPos + ", RightCode=" + RightCode + "]";
	}
	
	
}
