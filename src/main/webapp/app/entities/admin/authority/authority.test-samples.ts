import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '2eef2e7b-8a10-4920-8af9-65c9ff1dbe4b',
};

export const sampleWithPartialData: IAuthority = {
  name: '8713406a-0210-433f-9426-e8f429976a57',
};

export const sampleWithFullData: IAuthority = {
  name: 'c04451b1-a425-4919-bd99-341435a3e188',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
