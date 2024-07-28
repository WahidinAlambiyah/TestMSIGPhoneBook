import { IPerson } from 'app/entities/person/person.model';

export interface IContact {
  id: number;
  name?: string | null;
  number?: string | null;
  contactperson?: Pick<IPerson, 'id'> | null;
}

export type NewContact = Omit<IContact, 'id'> & { id: null };
