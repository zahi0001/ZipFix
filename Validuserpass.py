
import unittest
from your_web_app_module import is_valid_username, is_valid_password

class RegistrationTestCase(unittest.TestCase):

    def test_successful_registration(self):
        # Test case for successful user registration
        username = "test_user"
        password = "test_password"
        
        result = register_user(username, password)

        self.assertTrue(result)

    def test_duplicate_username_registration(self):
        # Test case for attempting to register with a duplicate username
        existing_username = "existing_user"
        existing_password = "existing_password"
        register_user(existing_username, existing_password)  # Register an existing user first

        # Now, try to register with the same username
        result = register_user(existing_username, "new_password")

        self.assertFalse(result)

    def test_weak_password_registration(self):
        # Test case for attempting to register with a weak password
        username = "test_user"
        weak_password = "weak"

        result = register_user(username, weak_password)

        self.assertFalse(result)

    def test_valid_username(self):
        # Test case for checking the validity of a username
        valid_username = "test_user"

        result = is_valid_username(valid_username)

        self.assertTrue(result)

    def test_invalid_username(self):
        # Test case for checking the validity of an invalid username
        invalid_username = "user@name"  # Invalid due to special character

        result = is_valid_username(invalid_username)

        self.assertFalse(result)

    def test_valid_password(self):
        # Test case for checking the validity of a password
        valid_password = "StrongPass123"

        result = is_valid_password(valid_password)

        self.assertTrue(result)

    def test_invalid_password(self):
        # Test case for checking the validity of an invalid password
        invalid_password = "weakpass"

        result = is_valid_password(invalid_password)

        self.assertFalse(result)
