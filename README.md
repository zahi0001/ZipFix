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
The project is managed using Git and hosted on GitHub.

release: Release/stable development branch. Only pushed to when main is feature-complete; assumed to be stable.

main: Main development branch.

Other branches are made and managed for individual features, to be pushed to main when ready, and for main to be pushed to release when assumed stable/feature-complete enough for a new release.
