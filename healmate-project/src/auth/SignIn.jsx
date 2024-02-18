import React from "react";
import axios from "axios";
import { useDispatch } from 'react-redux'; // Importing useDispatch hook
import { setAuthenticated } from '../utils/authActions'; // Importing setAuthenticated action

function SignInForm() {
  const [state, setState] = React.useState({
    email: "",
    password: ""
  });
  const [error, setError] = React.useState("");
  const dispatch = useDispatch(); // Use useDispatch hook

  const handleChange = (evt) => {
    const { name, value } = evt.target;
    setState((prevState) => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleOnSubmit = (evt) => {
    evt.preventDefault();
  
    const { email, password } = state;
    const formData = {
      email,
      password
    };
  
    axios
      .post("https://localhost:8080/users/signin", formData)
      .then((result) => {
        console.log("Server response:", result.data);
        sessionStorage.setItem("jwtToken", result.data.jwt);

        // Dispatch setAuthenticated action to set isAuthenticated to true
        dispatch(setAuthenticated());

        // Check the user's role and redirect based on it
        const userRole = result.data.role;
        console.log(userRole);
        if (userRole === "ADMIN") {
          window.location.href = "/admin";
        } else if(userRole === "TRAINER") {
          window.location.href = "/trainer";
        } else if(userRole === "CUSTOMER"){
          window.location.href = "/user";
        } else {
          window.location.href = "/user";
        }
  
        // Reset the form fields after successful submission
        setState({
          email: "",
          password: ""
        });
        setError(""); // Clear any previous error messages
      })
      .catch((error) => {
        console.error("Error signing in:", error);
        setError("Invalid email or password");
      });
  };
  

  return (
    <div className="container">
      <div className="d-flex justify-content-center align-items-center h-100">
        <div className="form-container">
          <form onSubmit={handleOnSubmit}>
            <h1>Sign in</h1>
            <div className="social-container">
              <a href="#" className="social">
                <i className="fab fa-facebook-f" />
              </a>
              <a href="#" className="social">
                <i className="fab fa-google-plus-g" />
              </a>
              <a href="#" className="social">
                <i className="fab fa-linkedin-in" />
              </a>
            </div>
            <span>or use your account</span>
            <input
              type="email"
              placeholder="Email"
              name="email"
              value={state.email}
              onChange={handleChange}
            />
            <input
              type="password"
              name="password"
              placeholder="Password"
              value={state.password}
              onChange={handleChange}
            />
            <a href="#">Forgot your password?</a>
            {error && <p className="error-message">{error}</p>} {/* Display error message */}
            <button type="submit">Sign In</button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default SignInForm;
