export interface Device {
  name: string;
  type: string;
  status: boolean;
}

export interface DeviceDTO {
  name: string;
  type: { id?: number; name: string };
  status: string;
}
