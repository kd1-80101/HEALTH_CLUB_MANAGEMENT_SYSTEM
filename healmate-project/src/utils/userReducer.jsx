// userReducer.js
const initialState = {
    userDetails: null,
    loading: false,
    error: null
  };
  
  const userReducer = (state = initialState, action) => {
    switch (action.type) {
      case 'FETCH_USER_REQUEST':
        return {
          ...state,
          loading: true,
          error: null
        };
      case 'FETCH_USER_SUCCESS':
        return {
          ...state,
          userDetails: action.payload,
          loading: false,
          error: null
        };
      case 'FETCH_USER_FAILURE':
        return {
          ...state,
          loading: false,
          error: action.payload
        };
      // Add more cases for other actions as needed
      default:
        return state;
    }
  };
  
  export default userReducer;
  