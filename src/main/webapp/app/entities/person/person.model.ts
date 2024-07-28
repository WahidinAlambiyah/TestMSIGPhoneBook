export interface IPerson {
  id: number;
  name?: string | null;
}

export type NewPerson = Omit<IPerson, 'id'> & { id: null };
