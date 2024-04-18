export interface Crop {
    name: string,
    image:string,
    minTemp:number,
    maxTemp:number
}

export interface Greenhouse {
    id: number,
    name: string,
    description: string,
    areas: [{crop: Crop}]
}