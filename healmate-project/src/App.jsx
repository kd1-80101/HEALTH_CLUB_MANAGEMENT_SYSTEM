import { Provider } from 'react-redux';
import { createBrowserRouter, RouterProvider, Routes, Route, Navigate } from 'react-router-dom';
import Home from './Components/Home';
import SignInForm from './auth/SignIn';
import SignUpForm from './auth/SignUp';
// import Contact from './Components/Contact'; // Import the AdminPage component
import store from './utils/store'; // Import your Redux store
import AdminPage from './pages/AdminPage';
import CustomerPage from './pages/CustomerPage';
import TrainerPage from './pages/TrainerPage';
import CustomerPayments from './pages/CustomerPayments';



const router = createBrowserRouter([
  {
    path: '/',
    element: <Home />
  },
  {
    path: '/signin',
    element: <SignInForm />
  },
  {
    path: '/signup',
    element: <SignUpForm />
  },
  {
    path: '/admin',
    element: <AdminPage /> // Use the AdminPage component here
  },
  {
    path: '/user',
    element: <CustomerPage />
  },
  {
    path: '/trainer',
    element: <TrainerPage />
  },
  {
    path: '/payments',
    element: <CustomerPayments />
  },
  {
    path: '*',
    element: <Navigate to="/" replace />
  }
]);


const AdminRoute = () => {
  // Check if user is authenticated and has admin role
  // You should implement this logic based on your Redux store state
  // For example, you might have isAuthenticated and userRole in your Redux store
  const isAuthenticated = store.getState().auth.isAuthenticated;
  const userRole = store.getState().auth.userRole;
  
  if (isAuthenticated && userRole === 'ADMIN') {
    return <AdminPage />;
  } else if (isAuthenticated && userRole === 'TRAINER') {
    return <TrainerPage />;
  } else if (isAuthenticated && userRole === 'CUSTOMER') {
    return <CustomerPage />;
  } 
  else {
    return <Navigate to="/signin" replace />;
  }
};

const UserRoute = () => {
  // Check if user is authenticated and has user role
  // You should implement this logic based on your Redux store state
  // For example, you might have isAuthenticated and userRole in your Redux store
  const isAuthenticated = store.getState().auth.isAuthenticated;
  const userRole = store.getState().auth.userRole;
  
  if (isAuthenticated && userRole === 'user') {
    return <CustomerPage />;
  } else {
    return <Navigate to="/signin" replace />;
  }
};

function App() {
  return (
    <div className="App">
      <Provider store={store}>
        <RouterProvider router={router}>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/signin" element={<SignInForm />} />
            <Route path="/signup" element={<SignUpForm />} />
            <Route path="/admin" element={<AdminRoute />} />
            <Route path="/user" element={<UserRoute />} />
            <Route path="*" element={<Navigate to="/" replace />} />
          </Routes>
        </RouterProvider>
      </Provider>
    </div>
  );
}

export default App;



// // function Routes() {
// //   return ( 
// //     <>
// //     <Home />
// //     </>
// //    );
// // }



// import { Provider } from 'react-redux';
// import { createBrowserRouter, RouterProvider, Routes, Route, Navigate } from 'react-router-dom';
// import Home from './Components/Home';
// import SignInForm from './auth/SignIn';
// import SignUpForm from './auth/SignUp';
// import store from './utils/store'; // Import your Redux store
// import PrivateRoute from './utils/PrivateRoute'; // Import the PrivateRoute component
// import AdminPage from './pages/AdminPage';
// import CustomerPage from './pages/CustomerPage';
// import TrainerPage from './pages/TrainerPage';
// import CustomerPayments from './pages/CustomerPayments';

// const router = createBrowserRouter([
//   {
//     path: '/',
//     element: <Home />
//   },
//   {
//     path: '/signin',
//     element: <SignInForm />
//   },
//   {
//     path: '/signup',
//     element: <SignUpForm />
//   },
//   {
//     path: '/admin',
//     element: <PrivateRoute element={<AdminPage />} allowedRoles={['ADMIN']} />
//   },
//   {
//     path: '/user',
//     element: <PrivateRoute element={<CustomerPage />} allowedRoles={['CUSTOMER', 'TRAINER']} />
//   },
//   {
//     path: '/trainer',
//     element: <PrivateRoute element={<TrainerPage />} allowedRoles={['TRAINER']} />
//   },
//   {
//     path: '/payments',
//     element: <PrivateRoute element={<CustomerPayments />} allowedRoles={['CUSTOMER', 'TRAINER']} />
//   },
//   {
//     path: '*',
//     element: <Navigate to="/" replace />
//   }
// ]);

// function App() {
//   const isAuthenticated = store.getState().auth.isAuthenticated;

//   return (
//     <div className="App">
//       <Provider store={store}>
//         <RouterProvider router={router}>
//           <Routes>
//             {/* Show home page only if authenticated */}
//             {isAuthenticated && <Route path="/" element={<Home />} />}
//             <Route path="/signin" element={<SignInForm />} />
//             <Route path="/signup" element={<SignUpForm />} />
//             {/* Define your routes using PrivateRoute */}
//             <Route path="/admin" element={<AdminPage />} />
//             <Route path="/user" element={<CustomerPage />} />
//             <Route path="/trainer" element={<TrainerPage />} />
//             <Route path="/payments" element={<CustomerPayments />} />
//             <Route path="*" element={<Navigate to="/" replace />} />
//           </Routes>
//         </RouterProvider>
//       </Provider>
//     </div>
//   );
// }

// export default App;
