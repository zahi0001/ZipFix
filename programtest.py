#Unit testing is below SkillSet and Professional Classes
import unittest

#self is used throughout to ensure data isolation between professionals needing to add and remove skills

class SkillSet:
    #Sample of possible attributes/skills that professionals can have
    possible_skills = ["Plumbing", "Electrical", "Carpentry", "Painting", "Landscaping"]
    #Empty set to initialize 
    def __init__(self):
        self.skills = set()
    #Adding skills to the skillset 
    #Error detection included for empty skill or non-provided skills.
    def add_skill(self, skill):
        #using strip for whitespace characters - should be adjusted later for drop-down menu utilization
        if skill.strip() and skill in self.possible_skills:
            self.skills.add(skill)
        else:
            print("Error: Skill cannot be empty or is not in the list of possible skills.")
    #Removing skill if skill to be removed is in possible_skills, otherwise print error
    def remove_skill(self, skill):
        if skill in self.skills:
            self.skills.remove(skill)
        else:
            print(f"Error: {skill} is not in the skill set.")

class Professional:
    #Constructor for the current instance to allow for modification in Professional and SkillSet class
    def __init__(self, name):
        self.name = name
        self.skill_set = SkillSet()
    #Connects skill_set to add_skill in SkillSet class and is utilized in unit test
    def add_skill(self, skill):
        self.skill_set.add_skill(skill)
    ##Connects skill_set to remove_skill in SkillSet class and is utilized in unit test
    def remove_skill(self, skill):
        self.skill_set.remove_skill(skill)

class TestSkillSet(unittest.TestCase): #Unit test framework for python, similar to Program 9.2 in course textbook
    #setUp comes from TestCase and will start each unit test as a fresh instance with no existing data stored
    def setUp(self):
        self.skill_set = SkillSet()
    #Arrange, Action, Assert is utilized similar to Program 9.2 to define what's happening
    def test_add_skill_valid(self):
        # Arrange - Setting paramaters to be tested for adding a skill
        #
        skill = "Plumbing"
        expected_skills = {"Plumbing"}

        # Action - Performing the adding skill function 
        self.skill_set.add_skill(skill)

        # Assert - Seeing if result is expected
        self.assertEqual(expected_skills, self.skill_set.skills)

    def test_add_skill_invalid(self):
        # Arrange - Setting parameters to be tested for adding non-existing skill
        skill = "Fake Skill"
        initial_skills = self.skill_set.skills.copy()

        # Action - Performing the adding skill function with incorrect skill
        self.skill_set.add_skill(skill)

        # Assert - Making sure 
        self.assertEqual(initial_skills, self.skill_set.skills)

    def test_remove_skill_existing(self):
        # Arrange - Adding a skill that will be removed 
        skill = "Plumbing"
        self.skill_set.skills.add(skill)
        #Should be expecting no skills remaining after removing Plumbing
        expected_skills = set()

        # Action - Performing the remove skill function
        self.skill_set.remove_skill(skill)

        # Assert - Checking if no skills remain after skill removal
        self.assertEqual(expected_skills, self.skill_set.skills)

    def test_remove_skill_nonexistent(self):
        # Arrange - Setting parameters to be tested for removing non-existing skill
        skill = "Fake Skill"
        initial_skills = self.skill_set.skills.copy()

        # Action - Removing the non-existing skill with remove skill function
        self.skill_set.remove_skill(skill)

        # Assert - Making sure the skill was not removed as skill 
        self.assertEqual(initial_skills, self.skill_set.skills)

if __name__ == "__main__":
    #Running the unit test
    unittest.main()

    #Add numbers to indicate which tests are specifically being failed
    #Unit test can be added to further with implementation on user input
    #More tests could be added for multiple additions and removals at once
    #Unit Tests are preformed quickly as seen in output