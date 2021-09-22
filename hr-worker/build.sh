mvn clean package -Dmaven.test.skip
sudo docker build -t hr-worker:v1 .
sudo docker run -P --network rh-rede-principal hr-worker:v1  &