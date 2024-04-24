import type { TemperatureMeasurement } from "./temperature";
import type { Device } from "./device";

export interface Crop {
  name: string;
  image: string;
  minTemp: number;
  maxTemp: number;
}

export interface Greenhouse {
  id: number;
  name: string;
  description: string;
  areas: [{ crop: Crop }];
  temperature?: TemperatureMeasurement;
  humidity?: number;
  irrigation?: number;
  devices: Device[];
}
