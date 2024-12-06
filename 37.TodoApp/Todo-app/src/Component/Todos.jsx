import { useState } from "react";
import { deleteById, retrieveTodoByUsername } from "./Api/TodoApi";
import { useEffect } from "react";
import { useAuth } from "./Security/AuthContext";

const Todos = () => {
  const [todosList, setTodosList] = useState([]);
  const [message, setMessage] = useState();
  const authContext = useAuth();
  const username = authContext.username;

  const refreshTodos = () => {
    retrieveTodoByUsername(username)
      .then((res) => {
        setTodosList(res.data);
        console.log(res);
      })
      .catch((err) => console.log(err));
  };

  const deleteTodo = (username, id) => {
    deleteById(username, id)
      .then(() => {
        setMessage("Delete Todo with id " + id);
        refreshTodos();
      })
      .catch((err) => {
        console.log(err);
        setMessage("Something went wrong");
      });
  };

  useEffect(() => {
    refreshTodos();
  }, []);
  setTimeout(() => {
    setMessage(null);
  }, 5000);

  return (
    <div className="container">
      <h1>Thing you have To do!</h1>
      {message && <div className="alert alert-warning">{message}</div>}

      <table className="table">
        <thead>
          <tr>
            <th scope="col">#id</th>
            <th scope="col">Description</th>
            <th scope="col">Target date</th>
            <th scope="col">is Done ?</th>
          </tr>
        </thead>
        <tbody>
          {todosList.map((todo) => {
            return (
              <tr key={todo.id}>
                <th scope="row">{todo.id}</th>
                <td>{todo.description}</td>
                <td>{todo.targetDate.toString()}</td>
                <td>{todo.done ? "Yes" : "No"}</td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={() => deleteTodo(username, todo.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default Todos;
