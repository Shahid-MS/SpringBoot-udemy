import { createContext, useContext, useState } from "react";

// create context
export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);

function AuthProvider({ children }) {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);

  function login(username, password) {
    if (username === "MS@gmail.com" && password === "ms") {
      setIsAuthenticated(true);
      setUsername(username);
      return true;
    } else {
      setIsAuthenticated(false);
      return false;
    }
  }

  function logout() {
    setIsAuthenticated(false);
  }

  return (
    <AuthContext.Provider value={{ isAuthenticated, username, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

export default AuthProvider;
