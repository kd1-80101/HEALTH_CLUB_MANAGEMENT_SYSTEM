// AdminPage.js
import { useEffect } from 'react';
import PropTypes from 'prop-types'; // Import PropTypes
import { connect } from 'react-redux';
import { setAuthenticated } from '../utils/authActions'; // Import the action creator

const AdminPage = ({ isAuthenticated, userDetails, setAuthenticated }) => {
  // Handle empty userDetails gracefully
  const userFullName = userDetails ? `${userDetails.firstName} ${userDetails.lastName}` : '';

  // Dispatch setAuthenticated action when component mounts
  useEffect(() => {
    setAuthenticated(); // Dispatch setAuthenticated action
  }, [setAuthenticated]);

  return (
    <div>
      <h1>Welcome to the Admin Page</h1>
      <p>This is a protected area accessible only to administrators.</p>
      {/* Render additional admin page content based on authentication status */}
      {isAuthenticated ? (
        <div>
          <p>User is authenticated.</p>
          {/* Display user details if available */}
          {userDetails && (
            <div>
              <p>User Details:</p>
              <p>Name: {userFullName}</p>
              {/* Add more user details as needed */}
            </div>
          )}
        </div>
      ) : (
        <p>User is not authenticated.</p>
      )}
    </div>
  );
};

// Define prop types for AdminPage
AdminPage.propTypes = {
  isAuthenticated: PropTypes.bool.isRequired, // isAuthenticated prop is required and should be a boolean
  userDetails: PropTypes.object, // userDetails prop is optional and should be an object
  setAuthenticated: PropTypes.func.isRequired // setAuthenticated action creator
};

// MapStateToProps function to connect AdminPage to Redux store
const mapStateToProps = state => ({
  isAuthenticated: state.auth.isAuthenticated,
  userDetails: state.user.userDetails
});

// MapDispatchToProps function to connect setAuthenticated action creator to AdminPage
const mapDispatchToProps = {
  setAuthenticated
};

export default connect(mapStateToProps, mapDispatchToProps)(AdminPage);
