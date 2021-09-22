mvn clean package -Dmaven.test.skip
sudo docker build -t hr-api-gateway-zuul:v1 .
sudo docker rm hr-api-gateway-zuul
sudo docker run -p 8765:8765 --name hr-api-gateway-zuul --network rh-rede-principal hr-api-gateway-zuul:v1  &