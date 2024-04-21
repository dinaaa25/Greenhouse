import urls from "~~/urls.json";

const services = [
  "temperature",
  "greenhouse",
  "ventilation",
  "humidity",
  "deviceManager",
];

export const useServiceStatus = () => {
  const statuses = useState<{ status: boolean; name: string; link: string }[]>(
    "status",
    () => []
  );

  if (statuses.value.length === 0) {
    for (let service of services) {
      console.log(service);
      let status = false;
      let link = `${urls[service]}/actuator/health`;
      fetch(link).then((response) => {
        if (response.status === 200) {
          status = true;
        }
        statuses.value.push({ status: status, name: service, link: link });
      });
    }
  }

  return statuses;
};
