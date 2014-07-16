package core.model;


import org.junit.Test;

public class EntryPageTest {


	@Test
	public void test() {
		
		EntryPage page = new EntryPage();
		
		page.setCurrentPage(0);
		page.setPageSize(20);
		page.setAllRow(100);
		page.init();
		System.out.println(page.getAllRow());
		System.out.println(page.getCurrentPage());
		System.out.println(page.getPageSize());
		System.out.println(page.getTotalPage());
		System.out.println(page.isFirstPage());
		System.out.println(page.isHasNextPage());
		System.out.println(page.isLastPage());
	}

}
