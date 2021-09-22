mvn clean package -Dmaven.test.skip
sudo docker build -t hr-payroll:v1 .
sudo docker rm hr-payroll
sudo docker run -P --name hr-payroll --network rh-rede-principal hr-payroll:v1  &