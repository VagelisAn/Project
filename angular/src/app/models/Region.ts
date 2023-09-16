import { Continent } from "./Continent";

export interface Region {
    id?: number,
    name: string,
    continents: Continent
}