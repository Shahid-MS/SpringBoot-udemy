import { Link, useParams } from "react-router-dom";
import {
  retrieveHelloWorld,
  retrieveHelloWorldBean,
  retrieveHelloWorldPathvariable,
} from "./Api/HelloWorldApiService";

const Welcome = () => {
  //   const params = useParams();
  const { username } = useParams();
  function callHelloWorld() {
    retrieveHelloWorld()
      .then((response) => {
        console.log(response);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("Finally Clean up");
      });

    retrieveHelloWorldBean()
      .then((response) => {
        console.log(response);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("Finally Clean up");
      });

    retrieveHelloWorldPathvariable(username)
      .then((response) => {
        console.log(response);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("Finally Clean up");
      });
  }

  return (
    <>
      <div className="container">
        <h1>Welcome {username}</h1>
        <div className="">
          Manage Your <Link to="/todos"> Todos</Link>
        </div>
        <div className="m-4">
          <button className="btn btn-success" onClick={callHelloWorld}>
            Call Hello World
          </button>
        </div>
      </div>
    </>
  );
};

export default Welcome;
Welcome;
