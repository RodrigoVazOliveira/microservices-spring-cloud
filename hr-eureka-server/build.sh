mvn clean package -Dmaven.test.skip
sudo docker build -t hr-eureka-server:v1 .
sudo docker rm hr-eureka-server
sudo docker run -p 8761:8761 --name hr-eureka-server --network rh-rede-principal hr-eureka-server:v1  &