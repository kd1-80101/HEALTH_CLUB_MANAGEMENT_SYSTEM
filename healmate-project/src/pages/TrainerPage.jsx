import { useEffect } from 'react';
import PropTypes from 'prop-types'; // Import PropTypes
import { connect } from 'react-redux';
import { setAuthenticated } from '../utils/authActions'; // Import the action creator

const TrainerPage = ({ isAuthenticated, userDetails, setAuthenticated }) => {
  // Dispatch setAuthenticated action when component mounts
  useEffect(() => {
    setAuthenticated(); // Dispatch setAuthenticated action
  }, [setAuthenticated]);

  return (
    <div>
      <h1>Welcome to the Trainer Page</h1>
      <p>This is a page accessible to trainers.</p>
      {/* Render additional trainer page content based on authentication status */}
      {isAuthenticated ? (
        <div>
          <p>User is authenticated.</p>
          {/* Display user details if available */}
          {userDetails && (
            <div>
              <p>User Details:</p>
              <p>Name: {userDetails.firstName} {userDetails.lastName}</p>
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

// Define prop types for TrainerPage
TrainerPage.propTypes = {
  isAuthenticated: PropTypes.bool.isRequired, // isAuthenticated prop is required and should be a boolean
  userDetails: PropTypes.object, // userDetails prop is optional and should be an object
  setAuthenticated: PropTypes.func.isRequired // setAuthenticated action creator
};

// MapStateToProps function to connect TrainerPage to Redux store
const mapStateToProps = state => ({
  isAuthenticated: state.auth.isAuthenticated,
  userDetails: state.user.userDetails
});

// MapDispatchToProps function to connect setAuthenticated action creator to TrainerPage
const mapDispatchToProps = {
  setAuthenticated
};

export default connect(mapStateToProps, mapDispatchToProps)(TrainerPage);
