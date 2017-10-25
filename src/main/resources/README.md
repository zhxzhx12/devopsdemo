0. Open the terminator in your OS

1. Pull docker image : docker pull zhx12/myjenkins

2. Run docker images:
    docker run -p 9091:8080 -p 50000:50000 --name testmyJenkins -v /var/run/docker.sock:/var/run/docker.sock  zhx12/myjenkins:1.1

3. Login docker container which you just creatted and named by "testmyJenkins" :
    docker exec -it testmyJenkins  /bin/bash

4. You should be have login that container and your terminator prompt should like "root@5301eeff0f8b:/#"

5. Make sure your container can connect to your local host docker sock by run command:
    docker ps
    the container "testmyJenkins" shuld be listed out

6. Make sure your container can get the internet by run : ping www.baidu.com

7. Open your browser. go to <http://localhost:9091>

8. Log it with admin/nimda and you will see project "test_devops_demo"

9. Click "build now" to re-build this project. it will :
    - Pull latest demo web project code for github ;
    - Build
    - Run Junit test;
    - Run Spring web test;
    - Re-build a docker image for this demo web project
    - Re-run this docker image

10. Open your browser. go to <http://localhost:5050/greeting>. you will got "Hello. world!" in your browser page.
this means the demo RUN OK

11. All this demo code are managed by github.com - <https://github.com/zhxzhx12/devopsdemo.git>
  Include:
    - Jenkins pileline script:  /src/main/resources/jenkinsfile/v2.txt
    - Dockerfile for this demo web projct :  /src/main/resources/dockerfile/Dockerfile
    - Gradle Build script :  build.gradle
    - Main java code : src/main/java
    - Junit and spring web test : src/test

12. Checkout the code from github. and update it if you want
