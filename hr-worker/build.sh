mvn clean package -Dmaven.test.skip
sudo docker build -t hr-worker:v1 .
sudo docker rm hr-worker
sudo docker run -P --name hr-worker --network rh-rede-principal hr-worker:v1  &