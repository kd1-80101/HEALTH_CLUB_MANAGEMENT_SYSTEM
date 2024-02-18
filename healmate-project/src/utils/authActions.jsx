export const LOGIN_REQUEST = 'LOGIN_REQUEST';
export const LOGIN_SUCCESS = 'LOGIN_SUCCESS';
export const LOGIN_FAILURE = 'LOGIN_FAILURE';
export const LOGOUT = 'LOGOUT';
export const FETCH_USER_ROLES = 'FETCH_USER_ROLES';
export const SET_USER_ROLES = 'SET_USER_ROLES';
export const SET_USER_AUTHENTICATED = 'SET_USER_AUTHENTICATED';

export const setAuthenticated = () => {
  return {
    type: 'LOGIN_SUCCESS' // Change action type to LOGIN_SUCCESS
  };
};
