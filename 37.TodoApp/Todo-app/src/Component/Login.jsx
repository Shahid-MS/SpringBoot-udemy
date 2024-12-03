import  { useState } from "react";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [showSuccess, setShowSuccess] = useState(false);
  const [showFailure, setShowFailure] = useState(false);

  const navigate = useNavigate();
  const handleSubmit = () => {
    if (username === "MS@gmail.com" && password === "ms") {
      setShowSuccess(true);
      setShowFailure(false);
      console.log("success");
      navigate(`/welcome/${username}`);
    } else {
      setShowFailure(true);
      setShowSuccess(false);
      console.log("Authentication Failed");
    }
  };

  return (
    <div className="container">
      {showSuccess && <div className="success">Authentication Successful</div>}

      {showFailure && (
        <div className="failure">
          Authentication Failed. Check email and Password
        </div>
      )}

      <div>
        <div className="mb-3">
          <label htmlFor="username" className="form-label">
            Username
          </label>
          <input
            type="email"
            className="form-control"
            name="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label className="form-label" htmlFor="password">
            Password
          </label>
          <input
            type="password"
            className="form-control"
            name="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <button
          type="submit"
          className="btn btn-primary"
          onClick={handleSubmit}
        >
          Submit
        </button>
      </div>
    </div>
  );
};

export default Login;
