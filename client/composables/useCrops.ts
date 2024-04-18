import type { Crop } from "~/types/greenhouse";
import urls from "~~/urls.json";

export const useCrops = () => {
    const crops = useState<Crop[]>("crops");

    if (!crops.value || crops.value.length === 0) {
        useFetch(`${urls.greenhouse}/crop`, {async onResponse({request, response}) {
            if (response.status === 200) {
                crops.value = await response._data;
            }
            }});
    }

}