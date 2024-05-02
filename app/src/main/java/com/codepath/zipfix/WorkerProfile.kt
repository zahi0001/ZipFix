package com.codepath.zipfix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import android.widget.TextView
import com.parse.ParseUser

class WorkerProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_profile)

        // Retrieve the user ID passed
        val userId = intent.getStringExtra("userId")

        // Fetch the user object from Back4App using the user ID
        val query = ParseUser.getQuery()
        query.getInBackground(userId) { user, e ->
            if (e == null) {
                // User object fetched successfully
                val firstName = user.getString("firstName")
                val lastName = user.getString("lastName")
                val isWorker = user.getBoolean("worker")
                val rating = user.getNumber("rating")
                val skills = user.getList<String>("skills")

                // Concatenate first and last names
                val fullName = "$firstName $lastName"

                // Update layout elements
                val nameTextView = findViewById<TextView>(R.id.name)
                nameTextView.text = fullName

                val isWorkerTextView = findViewById<TextView>(R.id.isWorker)
                isWorkerTextView.text = if (isWorker) "Worker" else "Not a worker"

                val ratingBar = findViewById<RatingBar>(R.id.rating)
                ratingBar.rating = (rating ?: 0f) as Float

                val skillsTextView = findViewById<TextView>(R.id.skills)
                "Skills: ${skills?.let { displaySkills(it) }}".also { skillsTextView.text = it }

                val filteredSkills = filterSkillsByKeyword(skills ?: emptyList(), "Test")
                Log.d("WorkerProfile", "Filtered Skills: $filteredSkills")
            } else {
                // Error occurred while fetching user object
                e.printStackTrace()
            }
        }
    }

    //Formats a list of skills into a readable string for display
    private fun displaySkills(skills: List<String>): String {
        if (skills.isEmpty()) return "No skills available"
        val stringBuilder = StringBuilder()
        for (skill in skills) {
            stringBuilder.append("• $skill\n")
        }
        return stringBuilder.toString().trim()
    }

    // Filters a list of skills based on a keyword.
    private fun filterSkillsByKeyword(skills: List<String>, keyword: String): List<String> {
        val filteredSkills = mutableListOf<String>()
        for (skill in skills) {
            if (skill.contains(keyword, ignoreCase = true)) {
                filteredSkills.add(skill)
            }
        }
        return filteredSkills
    }
}

/*
val intent = Intent(this, WorkerProfile::class.java)
intent.putExtra("userId", userId)
startActivity(intent)
*/