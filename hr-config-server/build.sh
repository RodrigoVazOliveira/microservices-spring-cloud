mvn clean package -Dmaven.test.skip
sudo docker build -t hr-config-server:v1 .
sudo docker rm hr-config-server
sudo docker run -p 8888:8888 --name hr-config-server --network rh-rede-principal hr-config-server:v1  &