package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Role;

public interface RoleService {

	List<Role> findAll();

	void delete(Long id);

	void save(Role role);

	void update(Role role);

	Role getById(Long id);

}
