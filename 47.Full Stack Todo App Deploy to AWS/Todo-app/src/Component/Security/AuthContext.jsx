import { createContext, useContext, useState } from "react";
import { jwtAuthApi } from "../Api/AuthApi";
import { apiClient } from "../Api/ApiClient";

// create context
export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);

function AuthProvider({ children }) {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);

  const [token, setToken] = useState(null);

  async function login(username, password) {
    try {
      const response = await jwtAuthApi(username, password);
      if (response.status == 200) {
        const jwtToken = "Bearer " + response.data.token;
        // console.log("jwtToken" + jwtToken);

        setIsAuthenticated(true);
        setUsername(username);
        setToken(jwtToken);

        apiClient.interceptors.request.use((config) => {
          console.log("Interceptor and adding token");
          config.headers.Authorization = jwtToken;
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
