import "./App.css";
import Error from "./Component/ErrorMessage";
import Footer from "./Component/Footer";
import Header from "./Component/Header";

import Login from "./Component/Login";
import Logout from "./Component/Logout";
import Todos from "./Component/Todos";
import Welcome from "./Component/Welcome";
import { BrowserRouter, Route, Routes } from "react-router-dom";

function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <div className="main-content">
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/login" element={<Login />} />
          <Route path="/todos" element={<Todos />} />
          <Route path="/welcome/:username" element={<Welcome />} />
          <Route path="/logout" element={<Logout />} />
          <Route path="*" element={<Error />} />
        </Routes>
        </div>
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
