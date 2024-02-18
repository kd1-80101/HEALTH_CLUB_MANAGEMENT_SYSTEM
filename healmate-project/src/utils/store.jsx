// store.js
import { createStore, combineReducers } from 'redux';
import authReducer from '../utils/authReducer';
import userReducer from '../utils/userReducer';

const rootReducer = combineReducers({
  auth: authReducer,
  user: userReducer
  // Add other reducers here if needed
});

const store = createStore(rootReducer);

export default store;
