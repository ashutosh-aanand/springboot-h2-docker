# Without docker, to run our program on our system:
# mvn clean install
# in /target : java -jar jar_file_name(springh2docker.jar)
# starts inbuilt tomcat server on port 8080


# Let's dockerize:

FROM openjdk:8

# copy jar file
COPY target/springh2docker.jar springh2docker.jar

# provide entrypoint i.e., java cmd to run the jar file copied
ENTRYPOINT [ "java", "-jar", "springh2docker.jar" ]



# docker build -t springh2dockerproject .
# docker images

# The app will run on port 8080 in the container
# so map the port 8080 to a host port on our system
# so, we can access the app outside the container

# docker run -p 3000:8080 img_name/img_id
# this will run the img in a container

# now use localhost:3000 to access our app

# to start a container
# docker start container_id

# to check logs
# docker logs container_id

# to check live logs
# docker logs -f container_id


# ctrl + c to stop

# docker ps -a => to see all container

# Lets remove the container

# docker rm container_id
# => won't remove as it is running

# stop running container
# docker stop container_id

# now remove it
# docker rm container_id

# docker ps -a
# the container is removed
# But the image will still be there

# docker images

# To remove the image as well
# docker image rm image_id
