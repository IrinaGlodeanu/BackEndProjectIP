# BackEndProjectIP
Repo echipa Papadiile (backend) FII Documents Flow 

## Build and run DOCKER image
1. Install docker 
2. Open a cmd in the projects directory and run : mvn clean install (probably it will be necessary to skip the tests)
3. After the previous command has finalised with success, run the following cmd :
``sh
mvn docker:build 
``
( this command will create the docker image)
4. In the end, to run the docker image containing our app, just run 
``sh
docker run -p 9666:9666 documents-backend
``
