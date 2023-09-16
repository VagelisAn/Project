import { Country } from "./Country";

export interface CountryStat {
    id?: number,
    year: number,
    population: number,
    gdp: number,
    country: Country;
}