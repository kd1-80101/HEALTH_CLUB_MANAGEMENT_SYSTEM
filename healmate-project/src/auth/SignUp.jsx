import React from "react";
import axios from "axios";
// import './SignUpForm.css';


function SignUpForm() {
  const [state, setState] = React.useState({
    firstName: "",
    lastName: "",
    email: "",
    password: ""
  });

  const handleChange = evt => {
    const { name, value } = evt.target;
    setState(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleOnSubmit = evt => {
    evt.preventDefault();

    const formData = {
      firstName: state.firstName,
      lastName: state.lastName,
      email: state.email,
      password: state.password
    };

    axios.post("https://localhost:8080/users/signup", formData)
      .then(response => {
        console.log("Sign up successful:", response.data);
        // Do something with the sign-up response, such as redirecting the user or displaying a success message
        setState({
          firstName: "",
          lastName: "",
          email: "",
          password: ""
        });
      })
      .catch(error => {
        console.error("Error signing up:", error);
        // Handle sign-up errors, such as displaying an error message to the user
      });
  };

  return (
    <div className="form-container sign-up-container justify-content-center align-items-center h-100">
      <form onSubmit={handleOnSubmit}>
        <h1>Create Account</h1>
        {/* <div className="social-container">
          <a href="https://www.google.com" className="social">
            <i className="fab fa-google-plus-g" />
            <img
              src="public\google_logo_new_icon.png"
              alt="Google"
              style={{ width: "40px", height: "40px", marginRight: "0.5px" }}
            />
          </a>
          <a href="https://www.facebook.com" className="social">
            <i className="fab fa-facebook-f" /> 
            <img
              src="public\facebook_facebook logo_icon.png"
              alt="Facebook"
              style={{ width: "40px", height: "40px", marginRight: "0.5px" }}
            /> 
          </a>
          <a href="https://www.linkedin.com" className="social">
            <i className="fab fa-linkedin-in" /> 
            <img
              src="public\linkedin_icon.png"
              alt="LinkedIn"
              style={{ width: "40px", height: "40px", marginRight: "0.1px" }}
            /> 
          </a>
        </div>
        <span>or use your email for registration</span> */}
        <input
          type="text"
          name="firstName"
          value={state.firstName}
          onChange={handleChange}
          placeholder="First Name"
        />
        <input
          type="text"
          name="lastName"
          value={state.lastName}
          onChange={handleChange}
          placeholder="Last Name"
        />
        <input
          type="email"
          name="email"
          value={state.email}
          onChange={handleChange}
          placeholder="Email"
        />
        <input
          type="password"
          name="password"
          value={state.password}
          onChange={handleChange}
          placeholder="Password"
        />
        <button type="submit">Sign Up</button>
      </form>
    </div>
  );
}

export default SignUpForm;
