import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 5161,
  login: '-v@wQFd\\wwObz',
};

export const sampleWithPartialData: IUser = {
  id: 18803,
  login: 'Gq8',
};

export const sampleWithFullData: IUser = {
  id: 19812,
  login: 'LVTmP@',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
