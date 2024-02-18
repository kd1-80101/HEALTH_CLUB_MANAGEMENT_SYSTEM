import { combineReducers } from 'redux';
import authReducer from './authReducer';
import userReducer from './userReducer';
// Import other reducers as needed

const rootReducer = combineReducers({
  auth: authReducer,
  user: userReducer,
  // Add other reducers here
});

export default rootReducer;
