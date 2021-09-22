./create-databases-dockers.sh
cd hr-config-server/
./build.sh
cd ../hr-eureka-server/
./build.sh
cd ../hr-worker/
./build.sh
cd ../hr-user/
./build.sh
cd ../hr-payroll/
./build.sh
cd ../hr-oauth/
./build.sh
cd ../hr-api-gateway-zuul/
./build.sh