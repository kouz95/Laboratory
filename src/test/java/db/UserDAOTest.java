package db;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDAOTest {
	private UserDAO userDao;

	@BeforeEach
	void setUp() {
		userDao = new UserDAO();
	}

	@Test
	void connection() {
		Connection connection = userDao.getConnection();
		assertNotNull(connection);
	}
}