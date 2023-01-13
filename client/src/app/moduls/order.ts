import { Article } from "./article";

export interface Order {

    id: number,
    reference: string,
    date: string,
    article:Article[]
  }

