package app.service.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import app.model.Right;
import app.service.RightService;
import core.model.EntryPage;
import core.service.impl.SupportServiceImpl;
import core.util.ExtracActionMethod;
import core.util.validate;

@Service("rightService")
public class RightServiceImpl extends SupportServiceImpl<Right> implements RightService {
	
	@Override
	public void saveOrUpdate(Right model) {
		int rightPos = 0;
		Long rightCode = 1L;
		if(model.getRightId() == null){//新增
			
			//查询最大的权限码
			String hql = "from Right t where t.RightPos = (select max(r.RightPos) from Right r)  order by "
					+ "t.RightPos desc,t.RightCode desc";
			List<Right> list = getListByHQL(hql);
			if(validate.isValid(list)){
				Right right = list.get(0);
				rightPos = right.getRightPos();
				if(right.getRightCode() > (1L << 60)){
					rightPos += 1;
					rightCode = 1L;
				}else{
					rightCode = right.getRightCode() <<1;
				}
			}
		}else{
			//修改(可以在功能表中添加字段以表示該功能是启用，此处不做任何操作，
			//此处的修改不包包括功能的权限组和权限码的修改)
			rightPos = model.getRightPos();
			rightCode = model.getRightCode();
			System.out.println("update....");
		}
		model.setRightPos(rightPos);
		model.setRightCode(rightCode);
		log.info("保存或更新权限:"+model);
		super.saveOrUpdate(model);
	}


	
	@Override
	public EntryPage query(int page, int size) {
		/**
		 * 在业务层实现查询语句的业务逻辑
		 */
		String hql ="from Right a order by a.RightId desc";
		return super.query(hql, page, size);
	}


	@Override
	public void refreshRight() {
		String path="core/struts/Action";
		String path2="app/struts/action";
		try {
			ExtracActionMethod.extract(path,this);
			ExtracActionMethod.extract(path2,this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}



	/**
	 * 通过读取所有的action类，通过反射获取到所有的action方法，
	 * 然后拼接成功能URI,如果已经存在，则不用添加，否则进行添加
	 */
	@Override
	public void appendRightByURL(String url) {
		String hql ="from Right t where t.uri =?";
		List<Right> list = this.getListByHQL(hql,url);
		if(!validate.isValid(list)){
			Right r = new Right();
			r.setUri(url);
			this.saveOrUpdate(r);
		}
	}

	public Set<Right> getByArray(String[] rightId){
		Set<Right> set = new HashSet<Right>();
		if(validate.isValid(rightId)){
			for(int i=0;i<rightId.length;i++){
				Right right = this.get(Integer.parseInt(rightId[i]));
				set.add(right);
			}
		}
		return set;
	}



	@Override
	public int getMaxRightPos() {
		String hql = "select max(r.RightPos) from Right r";
		Integer pos = (Integer) this.uniqueResult(hql);
		return pos == null ? 0 : pos ;
	}
}
