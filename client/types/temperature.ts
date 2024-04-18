export interface TemperatureMeasurement {
    id?: number,
    measuredDateTime: string,
    insideTemp: number,
    outsideTemp?: number,
    greenhouseId: number,
}