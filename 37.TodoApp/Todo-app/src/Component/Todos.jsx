

const Todos = () => {
  const today = new Date();
  const todosList = [
    {
      id: 1,
      description: "Learn AWS",
      done: true,
      targetDate: new Date(
        today.getFullYear(),
        today.getMonth() + 4,
        today.getDay() + 3
      ),
    },
    {
      id: 2,
      description: "Learn Spring Boot",
      done: false,
      targetDate: new Date(
        today.getFullYear(),
        today.getMonth() ,
        today.getDay() + 3
      ),
    },
  ];
  return (
    <div className="container">
      <h1>Thing you have To do!</h1>

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
                <td>
                  {todo.targetDate.toDateString()}
                </td>
                <td>{todo.done ? "Yes" : "No"}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default Todos;
