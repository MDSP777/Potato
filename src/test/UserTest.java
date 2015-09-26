package test;

import model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ApplicationContext.xml" })
public class UserTest {
	@Autowired
	private UserService us;
	
	@Test
	public void testAddAndRetrieve(){
		User marc = new User("Marc", "mdsp777@outlook.com", "09989793916", "1234-5678-9012");
		us.add(marc);
		User expected = us.retrieve(marc.getId());
		org.junit.Assert.assertEquals(marc, expected);
	}
}
