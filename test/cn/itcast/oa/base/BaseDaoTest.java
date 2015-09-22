package cn.itcast.oa.base;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.itcast.oa.dao.RoleDao;
import cn.itcast.oa.dao.UserDao;
import cn.itcast.oa.dao.impl.UserDaoImpl;
import cn.itcast.oa.domain.User;

public class BaseDaoTest {

//	private BaseDao dao = new BaseDaoImpl();
	
	@Test
	public void testSave() {
//		UserDao userDao = null;
//		RoleDao roleDao = null;
		
		UserDao userDao = new UserDaoImpl();
		
//		User user = new User();
//		user.setName("test");
//		dao.save(user);
//		System.out.println("增加user成功");
	}

//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetByIds() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindAll() {
//		fail("Not yet implemented");
//	}

}
