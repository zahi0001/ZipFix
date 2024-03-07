# ZipFix

//Sahil - Username/Password Test case file
import unittest
from your_web_app_module import register_user

class RegistrationTestCase(unittest.TestCase):

    def test_successful_registration(self):
        # Test case for successful user registration
        username = "test_user"
        password = "test_password"
        
        result = register_user(username, password)

        self.assertTrue(result)
        # You can add additional assertions based on the expected behavior of your web app

    def test_duplicate_username_registration(self):
        # Test case for attempting to register with a duplicate username
        existing_username = "existing_user"
        existing_password = "existing_password"
        register_user(existing_username, existing_password)  # Register an existing user first

        # Now, try to register with the same username
        result = register_user(existing_username, "new_password")

        self.assertFalse(result)
        # You can add additional assertions based on the expected behavior of your web app

    def test_weak_password_registration(self):
        # Test case for attempting to register with a weak password
        username = "test_user"
        weak_password = "weak"

        result = register_user(username, weak_password)

        self.assertFalse(result)
        # You can add additional assertions based on the expected behavior of your web app
