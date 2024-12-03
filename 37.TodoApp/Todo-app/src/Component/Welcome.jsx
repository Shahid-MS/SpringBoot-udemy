import { Link, useParams } from "react-router-dom";

const Welcome = () => {
  //   const params = useParams();
  const { username } = useParams();

  return (
    <>
      <div className="container">
        <h1>Welcome {username}</h1>
        <div className="">
          Manage Your <Link to="/todos"> Todos</Link>
        </div>
      </div>
    </>
  );
};

export default Welcome;
Welcome;
