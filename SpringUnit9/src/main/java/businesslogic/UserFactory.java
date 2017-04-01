package businesslogic;

import java.util.Random;

import com.edu.mum.dao.model.Group;
import com.edu.mum.dao.model.User;

public final class UserFactory {
	
	private UserFactory(){};
	
	public static User generate(Integer index, Group group) {
		User user = new User();
		Random random = new Random();
		user.setUserName("username-random" + index);
		user.setPassWord("password" + random.nextInt() + 1);
		user.setEmail("name" + random.nextInt() + 1 + "@gmail.com");
		user.setAge(random.nextInt(100) + 1);
		user.setGroup(group);
		return user;
	}
}
