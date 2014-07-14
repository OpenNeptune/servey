package core.service.impl;

import org.springframework.stereotype.Service;

import core.model.BusinessLog;
import core.service.BusinessLogService;

@Service("businessLogService")
public class BusinessLogServiceImpl extends SupportServiceImpl<BusinessLog> implements BusinessLogService {

	@Override
	public void save(BusinessLog log) {
		this.saveEntry(log);
	}
	
}
