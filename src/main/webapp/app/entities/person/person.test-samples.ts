import { IPerson, NewPerson } from './person.model';

export const sampleWithRequiredData: IPerson = {
  id: 7777,
  name: 'which toward heavenly',
};

export const sampleWithPartialData: IPerson = {
  id: 26959,
  name: 'aboard',
};

export const sampleWithFullData: IPerson = {
  id: 12475,
  name: 'juice phew',
};

export const sampleWithNewData: NewPerson = {
  name: 'organic for',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
