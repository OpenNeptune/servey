package app.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import app.model.Right;
import app.service.RightService;
import core.model.EntryPage;
import core.service.impl.SupportServiceImpl;
import core.util.validate;

@Service("rightService")
public class RightServiceImpl extends SupportServiceImpl<Right> implements RightService {
	@Override
	public void saveOrUpdate(Right model) {
		int rightPos = 0;
		Long rightCode = 1L;
		if(model.getRightId() == null){//新增
			
			//查询最大的权限码
			String hql = "from Right t  order by t.RightPos desc,t.RightCode desc";
			List<Right> list = getEntryListByHQL(hql);
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
		}
		model.setRightPos(rightPos);
		model.setRightCode(rightCode);
		log.info("保存或更新权限:"+model);
		super.saveOrUpdateEntry(model);
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
	public void delete(Right model) {
		/**
		 * 添加自己的业务逻辑
		 */
		this.deleteEntryById(model);
	}



	@Override
	public Right get(Integer id) {
		return this.getEntry(id);
	}



}
