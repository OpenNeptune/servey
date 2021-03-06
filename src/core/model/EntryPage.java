package core.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @Summary: 
 * 		一个通用的分页信息类实体
 * 
 */

public class EntryPage {
	
	// 要返回的某一页的记录列表
	@Getter @Setter private List<Object> list = new ArrayList<Object>(); 

	// 总记录数
	@Getter @Setter private int allRow =0; 
	
	// 总页数
	@Getter @Setter private int totalPage =0; 
	
	// 当前页
	@Getter @Setter private int currentPage =1;
	
	// 每页记录数
	@Getter @Setter private int pageSize =100;
	
	// 链接增加的字符参数
	@Getter @Setter private String strpage; 

	// 是否为第一页
	@Setter private boolean isFirstPage =false;
	
	// 是否为最后一页
	@Setter private boolean isLastPage = false;
	
	// 是否有前一页
	@Setter private boolean hasPreviousPage =false;
	
	// 是否有下一页
	@Setter private boolean hasNextPage = false;
	
	@Getter @Setter private int offset = 1;
	
    public boolean isFirstPage() {
        return currentPage == 1;    // 如是当前页是第1页
    }
    public boolean isLastPage() {
        return currentPage == totalPage;    //如果当前页是最后一页
    }
    public boolean isHasPreviousPage() {
        return currentPage != 1;        //只要当前页不是第1页
    }
    public boolean isHasNextPage() {
    	if(totalPage == 0){
    		return false;
    	}else{
    		return currentPage != totalPage; 
    	}
    }
    
    public void init(){
        this.isFirstPage = isFirstPage();
        this.isLastPage = isLastPage();
        this.hasPreviousPage = isHasPreviousPage();
        this.hasNextPage = isHasNextPage();
        totalPage = allRow % pageSize == 0 ? allRow/pageSize : allRow/pageSize+1;
        offset = pageSize*(currentPage-1);
    }
    

}
