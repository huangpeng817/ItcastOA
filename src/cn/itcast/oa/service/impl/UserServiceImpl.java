package cn.itcast.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User>implements UserService {

	@Override
	public User findByLoginNameAndPassword(String loginName, String md5Digest) {
		return (User) getSession().createQuery( //
				"FROM User u WHERE u.loginName=? AND u.password=?")
				.setParameter(0, loginName) //
				.setParameter(1, md5Digest) //
				.uniqueResult();
	}

}
