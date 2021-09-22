mvn clean package -Dmaven.test.skip
sudo docker build -t hr-oauth:v1 .
sudo docker rm hr-oauth
sudo docker run -P --name hr-oauth --network rh-rede-principal hr-oauth:v1  &