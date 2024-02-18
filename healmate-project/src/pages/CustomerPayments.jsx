import { useSelector } from 'react-redux';

const PaymentsPage = () => {
  const userRole = useSelector(state => state.auth.userRole); 

  // Render the payments page content only if the user's role is "customer"
  return (
    <>
      {userRole === 'CUSTOMER' ? (
        <div>
          <h1>Payments Page</h1>
          <p>This is the payments page. Only users with the role `customer` can access this page.</p>
        </div>
      ) : (
        <div>
          <h1>Unauthorized Access</h1>
          <p>Sorry, you are not authorized to access this page.</p>
        </div>
      )}
    </>
  );
}

export default PaymentsPage;
