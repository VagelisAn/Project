import { CountryStat } from "./CountryStat";

export interface Country {
    id?: number,
    name: string,
    area: number,
    nationalDay: Date,
    countryCode2: string,
    countryCode3: string,
    countryStats: CountryStat[],
    expanded: boolean;
}