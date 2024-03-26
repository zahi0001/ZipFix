# ZipFix

## Overview
This web application is designed to connect individuals or businesses with workers available for hire. Much like Uber connects riders with drivers, this platform connects hirers with workers. Whether you need someone to mow your lawn, fix your plumbing, or help with a project, this app facilitates the process.

## Features
Worker Profiles: Workers can create profiles showcasing their skills, experience, and availability.
Job Posting: Hirers can post jobs specifying the task, location, and desired qualifications.

Matching Algorithm: The app matches hirers with suitable workers based on their requirements and availability.

Booking and Scheduling: Once a match is made, hirers can book workers and schedule appointments directly through the app.

Rating and Reviews: Both hirers and workers can rate and review each other based on their experience, ensuring accountability and trust within the community.

## Technologies Used

Frontend: HTML, CSS, JavaScript, React.js

Backend: Node.js

Authentication: JSON Web Tokens (JWT)

Version Control: Git, GitHub

## Getting Started

To get a local copy of the project up and running, follow these steps:

Clone the repository to your local machine:

```
git clone https://github.com/your-username/worker-hire-app.git
```

Navigate to the project directory:

```
cd worker-hire-app
```

## Install dependencies:

```
npm install
```

Set up environment variables:

Create a .env file in the root directory.

Add the following environment variables:

```
makefile
```

## Run the application:

```
npm start
```

## Branches
The project is managed using Git and hosted on GitHub. Here are some of the active branches:

main: Main development branch.

AndrewD-SkillSet-TestCase: Branch for implementing skill set test cases.

This branch implements unit tests for the SkillSet and Professional classes. It ensures the functionality of adding and removing skills, with error detection for invalid inputs. The tests cover scenarios for both valid and invalid skill operations, providing a quick verification of the code's functionality. Further enhancements and additional tests could be added as needed.

joseph: Branch for Joseph's contributions.

This branch contains unit tests for user verification logic. Tests cover successful verification, handling non-existent emails, and incorrect verification codes. Using Python's unittest framework and mocking, it ensures reliable testing of identity verification processes. Further enhancements and tests can be added for edge cases and improved robustness.

SahilTamboli10-ValidUserPass-TestCase: Branch for implementing test cases related to valid user passwords.

Mounir: Branch for Mounir's contributions.

Myka: Branch for Myka's contributions.
