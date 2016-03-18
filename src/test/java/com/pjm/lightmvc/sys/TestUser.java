package com.pjm.lightmvc.sys;

import com.pjm.lightmvc.dao.sys.UserDao;
import com.pjm.lightmvc.model.sys.TOrganization;
import com.pjm.lightmvc.model.sys.TUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by PanJM on 2016/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
@Transactional
@WebAppConfiguration
public class TestUser extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext
    private EntityManager entityManager;
    @Resource
    private UserDao userDao;

    @Test
    @Rollback(false)
    public void testSaveUser() throws Exception {
        TUser tUser = new TUser();
        tUser.setLoginName("user2");
        tUser.setUserName("用户2");
        tUser.setPassWord("admin");
        TOrganization tOrganization = new TOrganization();
        tOrganization.setId(1l);
        tUser.settOrganization(tOrganization);
        userDao.save(tUser);
    }

    @Test
    public void testFindUser() {
        TUser tUser = entityManager.find(TUser.class, 1l);
        System.out.println("tUser.getUserName() = " + tUser.getUserName());
    }

    @Test
    public void testDel() {

    }
}

