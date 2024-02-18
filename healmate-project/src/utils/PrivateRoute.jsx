import PropTypes from 'prop-types';
import { useSelector } from 'react-redux';
import { Navigate } from 'react-router-dom';

const PrivateRoute = ({ element, allowedRoles }) => {
  const isAuthenticated = useSelector(state => state.auth.isAuthenticated);
  const userRole = useSelector(state => state.auth.userRole);

  if (!isAuthenticated) {
    return <Navigate to="/signin" replace />;
  }

  if (!allowedRoles.includes(userRole)) {
    // Redirect to unauthorized page or show a message
    return <Navigate to="/" replace />;
  }

  return element;
};

PrivateRoute.propTypes = {
  element: PropTypes.element.isRequired,
  allowedRoles: PropTypes.arrayOf(PropTypes.string).isRequired
};

export default PrivateRoute;
