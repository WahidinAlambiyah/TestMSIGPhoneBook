import { IContact, NewContact } from './contact.model';

export const sampleWithRequiredData: IContact = {
  id: 805,
  name: 'orX',
  number: 'how whereas',
};

export const sampleWithPartialData: IContact = {
  id: 6600,
  name: 'molasses pita the',
  number: 'why',
};

export const sampleWithFullData: IContact = {
  id: 14044,
  name: 'huzzah',
  number: 'standardization app rove',
};

export const sampleWithNewData: NewContact = {
  name: 'sadly once',
  number: 'inside daintily greedy',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
