<div>
  <img style="margin: auto" height="80" src="logo.png" />
</div>


# Greenhouse Manager

This project is a service that autonomously controls greenhouses for horticulture farmers.


## Demo

coming soon


## Authors

- [@dinaaa25](https://github.com/dinaaa25)
- [@masterkram](https://github.com/masterkram)

## Installation

To run the project, run the following command.
This will build all docker containers required and start them with the correct options.
```
docker compose -f docker-compose.yml up --build
```
(also contained in `run.sh`).
After running it should be possible to open [localhost:3000](http://localhost:3000/).

Run individual microservices with:

```bash
gradlew bootRun
```

Run the dashboard:
```bash
yarn dev
```
