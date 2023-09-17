import { CountryStat } from "./CountryStat";
import { Region } from "./Region";

export interface Country {
    id?: number,
    name: string,
    area: number,
    nationalDay: Date,
    countryCode2: string,
    countryCode3: string,
    countryStats: CountryStat[],
    regions: Region,
}