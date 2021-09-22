sudo docker rm hr-worker-postgresql
sudo docker rm hr-user-postgresql
sudo docker run -p 5432:5432 --name hr-worker-postgresql --network rh-rede-principal -e POSTGRES_USER=hr_worker -e POSTGRES_PASSWORD=hr_worker -e POSTGRES_DB=hr_worker postgres:12-alpine &
sudo docker run -p 5433:5432 --name hr-user-postgresql --network rh-rede-principal -e POSTGRES_USER=hr_user -e POSTGRES_PASSWORD=hr_user -e POSTGRES_DB=hr_user postgres:12-alpine &