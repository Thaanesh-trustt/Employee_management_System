import React, { useState } from "react";
import "./Login.css";
import Button from "react-bootstrap/Button";
import { BiHide } from "react-icons/bi";
import login from "../assests/login.png";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [rememberMe, setRememberMe] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Username:", username);
    console.log("Password:", password);
  };

  const togglePasswordVisibility = () => {
    const passwordInput = document.getElementById("password");
    if (passwordInput.type === "password") {
      passwordInput.type = "text";
    } else {
      passwordInput.type = "password";
    }
  };

  return (
    <div className="container" style={{ borderRadius: '50px' ,backgroundColor: '#ffffff', 
    boxShadow: '20px 20px 60px #bebebe, -20px -20px 60px #ffffff' , marginBottom:"20px"}}>
      <div className="row">
        <div className="col-lg-6">
          <div className="login-container">
            <div className="login-form-container">
              <div className="login-form-header">
                <h1>Trustt</h1>
              </div>
              <div className="login-form-body">
                <form onSubmit={handleSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      id="username"
                      name="username"
                      className="form-control"
                      placeholder="Login ID"
                      value={username}
                      onChange={(e) => setUsername(e.target.value)}
                    />
                  </div>
                  <div className="form-group">
                    <div className="password-input">
                      <input
                        type="password"
                        id="password"
                        name="password"
                        className="form-control"
                        placeholder="Enter Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                      />
                      <BiHide
                        className="password-toggle"
                        onClick={togglePasswordVisibility}
                      />
                    </div>
                  </div>
                  <div className="form-check">
                    <input
                      type="checkbox"
                      className="form-check-input"
                      id="rememberMe"
                      checked={rememberMe}
                      onChange={(e) => setRememberMe(!rememberMe)}
                    />
                    <label className="form-check-label" htmlFor="rememberMe">
                      Remember Me
                    </label>
                    <div className="ps">
                      <a href="#">Forgot Password?</a>
                    </div>
                  </div>
                </form>
              </div>
              <div className="login-form-footer">
                <div>
                  <button
                    className="btn btn-primary"
                    size="lg"
                    style={{
                      textAlign: "center",
                      color: "white",
                      fontSize: 14,
                      fontFamily: "Cairo",
                      fontWeight: "700",
                      width: 350,
                      letterSpacing: 0.1,
                      wordWrap: "break-word",
                    }}
                  >
                    Login
                  </button>
                </div>
              </div>
            </div>
          </div>


{/* <div className="w-60 h-50 m-4  ">
            <form className="border p-1">
              <div className="mb-3">
                <label htmlFor="exampleInputEmail1" className="form-label">
                  Email address
                </label>
                <input
                  type="email"
                  className="form-control"
                  id="exampleInputEmail1"
                  aria-describedby="emailHelp"
                />
                <div id="emailHelp" className="form-text">
                  We'll never share your email with anyone else.
                </div>
              </div>
              <div className="mb-3">
                <label htmlFor="exampleInputPassword1" className="form-label">
                  Password
                </label>
                <input
                  type="password"
                  className="form-control"
                  id="exampleInputPassword1"
                />
              </div>
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </form>
          </div> */}



        </div>
        <div className="col-lg-6">
          <img className="img-fluid h-65" src={login} alt="" />
        </div>
      </div>
    </div>
  );
};

export default Login;
