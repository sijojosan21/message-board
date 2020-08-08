# message-board

[![Build Status](https://travis-ci.org/sijojosan21/message-board.svg?branch=master)](https://travis-ci.org/sijojosan21/message-board)

<br/>

Application can be accessed at [sijojosan.com]

<br/>

## Technology Stack
  - Spring Boot/Java - for the backend REST API endpoints
  - Reactjs - for the frontend UI
  - PostgreSQL - for data persistence
  - Docker - for containerization
  - [Travis CI] - for build and deployment
  - Amazon Web Services - for hosting
<br/>

## Deploy

### What is Travis CI
Travis CI is a hosted continuous integration service used to build and test software projects hosted at GitHub and Bitbucket. Travis CI provides various paid plan for private projects, and a free plan for open source.

### How to Deploy in AWS
  - Commit changes to the develop branch.
  - Create a pull request to the master branch.
  - Merge the pull request.
  - Changes will be automatically detected and deployed to AWS with the help of Travis CI. (refer .travis.yml)

### How to Deploy in Local
Make the required changes in either the UI or the service backend and run the flowing commands. ([Docker Desktop] is required)
```sh
cd message-board
docker-compose build
docker-compose up
```
<br/>

## API Documentation
  - [Swagger API Documentation]
<br/>

## Testing

### Unit Testing
JUnit test cases are writen to unit test each service method. These test cases are executed before each deployment to AWS. If any of the test cases fail, deployment is aborted.

### Functional Testing
A functional test suite wriiten using [Selenium] Webdriver will test the proper funtioning of the UI. The test case has be exported as a executable jar and can be run using the bellow commands - 
```sh
cd message-board
cd selenium-test
java -jar selenium-test.jar
```
<br/>

## Diagrams

### System Architecture 
![System Architecture](/misc/arch.jpg)


### Docker Container Components
![Docker Container Components](/misc/cont.jpg)


### Deployment Overview
![Deployment Overview](/misc/dplymnt.jpg)
<br/>

## License
Apache License 2.0, see [LICENSE].


[sijojosan.com]: <http://sijojosan.com>
[Travis CI]: <https://travis-ci.org>
[Docker Desktop]: <https://www.docker.com/products/docker-desktop>
[Swagger API Documentation]: <http://sijojosan.com>
[Selenium]: <https://www.selenium.dev>
[LICENSE]: </LICENSE>
