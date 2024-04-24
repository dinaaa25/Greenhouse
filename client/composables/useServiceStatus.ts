import urls from "~~/urls.json";

const services = [
  "temperature",
  "greenhouse",
  "ventilation",
  "humidity",
  "deviceManager",
];

export const useServiceStatus = () => {
  const statuses = useState<
    Set<{ status: boolean; name: string; link: string }>
  >("status", () => new Set());
  const date = ref();

  if (statuses.value.size === 0) {
    for (let service of services) {
      let status = false;
      let link = `${urls[service]}/actuator/health`;
      fetch(link).then((response) => {
        if (response.status === 200) {
          status = true;
        }
        statuses.value.add({ status: status, name: service, link: link });
      });
    }
    date.value = new Date();
  }

  setInterval(() => {
    statuses.value = new Set();
    for (let service of services) {
      let status = false;
      let link = `${urls[service]}/actuator/health`;
      fetch(link).then((response) => {
        if (response.status === 200) {
          status = true;
        }
        statuses.value.add({ status: status, name: service, link: link });
      });
    }
    date.value = new Date();
  }, 50000);

  return { statuses: statuses, refreshedAt: date };
};
