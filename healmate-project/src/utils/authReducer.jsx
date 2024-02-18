// authReducer.js

import {
    LOGIN_REQUEST,
    LOGIN_SUCCESS,
    LOGIN_FAILURE,
    LOGOUT,
    // FETCH_USER_ROLES,
    // SET_USER_ROLES,
    SET_USER_AUTHENTICATED,

  } from './authActions';
  
  const initialState = {
    isAuthenticated: false,
    user: null,
    roles: [], // New state to store user roles
    loading: false,
    error: null
  };
  
  export const authReducer = (state = initialState, action) => {
    switch (action.type) {
      case LOGIN_REQUEST:
        return {
          ...state,
          isAuthenticated: false,
          loading: true,
          error: null
        };
      case LOGIN_SUCCESS:
        return {
          ...state,
          isAuthenticated: true,
          user: action.payload,
          loading: false,
          error: null
        };
      case LOGIN_FAILURE:
        return {
          ...state,
          isAuthenticated: false,
          user: null,
          loading: false,
          error: action.payload // Store error message
        };
      case LOGOUT:
        return {
          ...state,
          isAuthenticated: false,
          user: null,
          roles: [], // Clear user roles upon logout
          loading: false,
          error: null
        };
      case SET_USER_AUTHENTICATED: // Handle SET_USER_AUTHENTICATED action type
        return {
          ...state,
          isAuthenticated: true
        };
      // Other cases...
      default:
        return state;
    }
  };
  
  
  export default authReducer;
  