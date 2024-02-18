import { useEffect, useState } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { setAuthenticated } from '../utils/authActions';

const CustomerPage = ({ isAuthenticated, userDetails, setAuthenticated }) => {
  useEffect(() => {
    setAuthenticated(true);
  }, [setAuthenticated]);

  const [editMode, setEditMode] = useState(false);
  const [formData, setFormData] = useState({
    firstName: userDetails?.firstName || '',
    lastName: userDetails?.lastName || '',
    email: userDetails?.email || '',
    profilePicture: userDetails?.profilePicture || ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevData => ({
      ...prevData,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setEditMode(false);
  };

  // Handle redirection if not authenticated
  if (!isAuthenticated) {
    return <p>User is not authenticated.</p>;
  }

  return (
    <div className="container mt-5">
      <h1>Welcome to the Customer Page</h1>
      <p>This is a page accessible to customers.</p>
      {/* Render additional content */}
      <div className="row">
        <div className="col-md-6">
          <div className="card mb-3">
            <div className="card-body">
              <h5 className="card-title">Profile Information</h5>
              {editMode ? (
                <form onSubmit={handleSubmit}>
                  <div className="mb-3">
                    <input type="text" className="form-control" name="firstName" value={formData.firstName} onChange={handleChange} placeholder="First Name" />
                  </div>
                  <div className="mb-3">
                    <input type="text" className="form-control" name="lastName" value={formData.lastName} onChange={handleChange} placeholder="Last Name" />
                  </div>
                  <div className="mb-3">
                    <input type="email" className="form-control" name="email" value={formData.email} onChange={handleChange} placeholder="Email" />
                  </div>
                  <button type="submit" className="btn btn-primary">Save</button>
                </form>
              ) : (
                <div>
                  <p>Name: {userDetails?.firstName} {userDetails?.lastName}</p>
                  <p>Email: {userDetails?.email}</p>
                  <img src={userDetails?.profilePicture} alt="Profile" className="img-fluid rounded-circle" />
                  <button onClick={() => setEditMode(true)} className="btn btn-primary mt-3">Edit Profile</button>
                </div>
              )}
            </div>
          </div>
        </div>
        <div className="col-md-6">
          {/* Render additional content */}
          <div className="mt-5">
            <h2>Progress</h2>
            {/* Display progress data */}
          </div>

          <div className="mt-5">
            <h2>Membership Status</h2>
            {/* Display membership status and payment history */}
          </div>

          <div className="mt-5">
            <h2>Diet Plans</h2>
            {/* Display assigned diet plans */}
          </div>

          <div className="mt-5">
            <h2>Workout Charts</h2>
            {/* Display assigned workout charts */}
          </div>
        </div>
      </div>
    </div>
  );
};

CustomerPage.propTypes = {
  isAuthenticated: PropTypes.bool.isRequired,
  userDetails: PropTypes.object,
  setAuthenticated: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  isAuthenticated: state.auth.isAuthenticated,
  userDetails: state.user.userDetails
});

const mapDispatchToProps = {
  setAuthenticated
};

export default connect(mapStateToProps, mapDispatchToProps)(CustomerPage);
