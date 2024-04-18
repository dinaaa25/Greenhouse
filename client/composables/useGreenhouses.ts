import type { Greenhouse } from "~/types/greenhouse";
import urls from "~~/urls.json";

export const useGreenhouses = () => {
    const greenhouses = useState<Greenhouse[]>("greenhouses", () => []);
    
    if (greenhouses.value.length === 0) {
        useFetch(`${urls.greenhouse}/greenhouse`, {async onResponse({request, response}) {
            if (response.status === 200) {
                console.log("hi made request");
                greenhouses.value = await response._data;
            }
            }});
    }

    return greenhouses;
}