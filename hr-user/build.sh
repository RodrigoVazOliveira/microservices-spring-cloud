mvn clean package -Dmaven.test.skip
sudo docker build -t hr-user:v1 .
sudo docker rm hr-user
sudo docker run -P --name hr-user --network rh-rede-principal hr-user:v1  &