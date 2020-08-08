# message-board

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

<br/>

Application can be accessed at http://sijojosan.com

<br/>

### Technology Stack
  - Spring Boot/Java (for Backend REST API Endpoints)
  - Reactjs - (for the frontend UI)
  - PostgreSQL - (for data persistence)
<br/>

### How to Deploy in AWS
  - Commit changes to the develop branch.
  - Create a pull request to the master branch.
  - Merge the pull request.
  - Changes will be automatically detected and deployed to AWS with the help of Travis CI. (refer .travis.yml)
<br/>

### How to Deploy in Local
```sh
cd message-board
docker-compose build
docker-compose up
```
<br/>

### System Architecture 
![System Architecture](/misc/arch.jpg)


### Docker Container Components
![Docker Container Components](/misc/cont.jpg)


### Deployment Overview
![Deployment Overview](/misc/dplymnt.jpg)
