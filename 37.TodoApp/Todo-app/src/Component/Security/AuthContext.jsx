import { createContext, useContext, useState } from "react";
import { basicAuthApi } from "../Api/AuthApi";
import { apiClient } from "../Api/ApiClient";

// create context
export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);

function AuthProvider({ children }) {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);

  // function login(username, password) {
  //   if (username === "MS@gmail.com" && password === "ms") {
  //     setIsAuthenticated(true);
  //     setUsername(username);
  //     return true;
  //   } else {
  //     setIsAuthenticated(false);
  //     return false;
  //   }
  // }

  const [token, setToken] = useState(null);
  async function login(username, password) {
    const basicAuthToken = "Basic " + window.btoa(username + ":" + password);

    try {
      const response = await basicAuthApi(basicAuthToken);
      if (response.status == 200) {
        setIsAuthenticated(true);
        setUsername(username);
        setToken(basicAuthToken);
        apiClient.interceptors.request.use((config) => {
          console.log("Interceptor and adding token");
          config.headers.Authorization = basicAuthToken;
          return config;
        });
        return true;
      } else {
        logout();
        return false;
      }
    } catch (err) {
      logout();
      console.log(err);
    }
  }

  function logout() {
    setUsername(null);
    setToken(null);
    setIsAuthenticated(false);
  }

  return (
    <AuthContext.Provider
      value={{ isAuthenticated, username, login, logout, token }}
    >
      {children}
    </AuthContext.Provider>
  );
}

export default AuthProvider;
