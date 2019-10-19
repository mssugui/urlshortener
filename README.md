# urlshortener
A simple URL Shortener

To work correctly within Eclipse, even with Lombok in pom.xml, it is required to install Lombok in Eclipse:
1) Exit Eclipse
2) Find lombok jar in ~/.m2/repository/org/projectlombok/lombok/version.x
3) From shell type: java -jar lombok-x.y.z.jar
4) Point it to your Eclipse installation


**To create a Docker Image, at project root folder type:**

```
./mvnw package 
java -jar target/urlshortener-0.0.1-SNAPSHOT.jar
sudo ./mvnw install dockerfile:build
```

**To start a Docker Container from this image, run:**
```
sudo docker run -p 8080:8080 -t muhamadsugui/urlshortener
```

**To stop container, run:**
```
sudo docker ps
sudo docker stop <CONTAINER_ID>
```
