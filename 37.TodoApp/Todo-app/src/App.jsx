import "./App.css";
import Error from "./Component/ErrorMessage";
import Footer from "./Component/Footer";
import Header from "./Component/Header";

import Login from "./Component/Login";
import Logout from "./Component/Logout";
import NewTodo from "./Component/NewTodo";
import AuthProvider, { useAuth } from "./Component/Security/AuthContext";
import Todo from "./Component/Todo";
import Todos from "./Component/Todos";
import Welcome from "./Component/Welcome";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";

function AuthenticatedRoute({ children }) {
  const authContext = useAuth();
  if (authContext.isAuthenticated) {
    return children;
  }
  return <Navigate to="/" />;
}

function App() {
  return (
    <>
      <AuthProvider>
        <BrowserRouter>
          <Header />
          <div className="main-content">
            <Routes>
              <Route path="/" element={<Login />} />
              <Route path="/login" element={<Login />} />
              <Route
                path="/todos"
                element={
                  <AuthenticatedRoute>
                    <Todos />
                  </AuthenticatedRoute>
                }
              />
              <Route
                path="/welcome/:username"
                element={
                  <AuthenticatedRoute>
                    <Welcome />
                  </AuthenticatedRoute>
                }
              />
              <Route
                path="/logout"
                element={
                  <AuthenticatedRoute>
                    <Logout />
                  </AuthenticatedRoute>
                }
              />

              <Route
                path="/todos/:id"
                element={
                  <AuthenticatedRoute>
                    <Todo />
                  </AuthenticatedRoute>
                }
              />

              <Route
                path="/todos/new"
                element={
                  <AuthenticatedRoute>
                    <NewTodo />
                  </AuthenticatedRoute>
                }
              />

              <Route path="*" element={<Error />} />
            </Routes>
          </div>
          <Footer />
        </BrowserRouter>
      </AuthProvider>
    </>
  );
}

export default App;
