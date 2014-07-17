package app.dao.impl;

import org.springframework.stereotype.Repository;

import app.dao.RoleDao;
import app.model.Role;
import core.dao.impl.SupportDaoImpl;

@Repository("roleDao")
public class RoleDaoImpl extends SupportDaoImpl<Role> implements RoleDao{

}
