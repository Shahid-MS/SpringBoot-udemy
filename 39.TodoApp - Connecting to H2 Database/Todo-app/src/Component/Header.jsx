// import { useContext } from "react";
import { Link } from "react-router-dom";
import { useAuth } from "./Security/AuthContext";

const Header = () => {
  const authContext = useAuth();
  // console.log(authContext);
  const isAuthenticated = authContext.isAuthenticated;

  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
      <div className="container-fluid">
        <a className="navbar-brand" href="#">
          <b>MS Todo</b>
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            {!isAuthenticated && (
              <li>
                <Link to="/login" className="nav-link">
                  Login
                </Link>
              </li>
            )}
            {isAuthenticated && (
              <li>
                <Link
                  to="/logout"
                  className="nav-link"
                  onClick={authContext.logout}
                >
                  Logout
                </Link>
              </li>
            )}
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Header;
