<div>
  <img style="margin: auto" height="80" src="logo.png" />
</div>


# Greenhouse Manager

This project is a service that autonomously controls greenhouses for horticulture farmers.


## Demo

<video width="320" height="240" controls>
  <source src="https://drive.google.com/file/d/13gO0m1ZNcsMzD93XYW85TXIP0UJWDZ2-/view" type="video/mp4">
</video>


## Authors

- [Dina Lazorenko](https://github.com/dinaaa25)
- [Mark Bruderer](https://github.com/masterkram)

## Installation


### With Docker
To run the project, run the following command.
This will build all docker containers required and start them with the correct options.

```
./run.sh
```

There is also a command to develop the application with hot reload for the frontend.

```
./develop
```

This will use docker compose to build and run the services.

After running it should be possible to open [localhost:3000](http://localhost:3000/).

### To run without using docker:
Run individual microservices with:

```bash
gradlew bootRun
```

Run the dashboard:
```bash
cd client
yarn install
yarn dev
```

---

# Running The Kubernetes Cluster

The configuration files for the kubernetes cluster are contained in the `kubernetes` directory. It contains a deployment and a service file for each microservice.

```
cd kubernetes
kubectl apply -f .
```