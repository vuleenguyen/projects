package businesslogic;

import java.util.Comparator;

import com.edu.mum.dao.model.User;

public class UserNameComparator implements Comparator<User> {

	@Override
	public int compare(User u1, User u2) {
		return u1.getUserName().compareTo(u2.getUserName());
	}

}
