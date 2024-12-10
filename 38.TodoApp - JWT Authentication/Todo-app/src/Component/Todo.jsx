import { useEffect, useState } from "react";
import { findById, updateTodoApi } from "./Api/TodoApi";
import { useNavigate, useParams } from "react-router-dom";
import { useAuth } from "./Security/AuthContext";
import { ErrorMessage, Field, Form, Formik } from "formik";

const Todo = () => {
  const { id } = useParams();
  const authContext = useAuth();
  const username = authContext.username;
  const [description, setDescription] = useState("");
  const [targetDate, setTargetdate] = useState("");
  const navigate = useNavigate();
  function retrieveTodo() {
    findById(username, id)
      .then((res) => {
        // console.log(res.data);
        setDescription(res.data.description);
        setTargetdate(res.data.targetDate);
      })
      .catch((e) => console.log(e));
  }

  const handleOnSubmit = (res) => {
    // console.log(value);
    const todo = {
      id,
      username,
      description: res.description,
      targetDate: res.targetDate,
      done: false,
    };
    // console.log(todo);
    updateTodoApi(username, id, todo)
      .then((res) => {
        // console.log(res);
        navigate("/todos");
      })
      .catch((err) => console.log(err));
  };

  const handleValidate = (value) => {
    // console.log(value);
    let errors = {
      // description: "Enter a valid description",
      // targetDate: "Enter a valid targetDate",
    };
    if (value.description.length < 5) {
      errors.description = "Enter a valid description";
    }

    if (value.targetDate == null) {
      errors.targetDate = "Enter Target date";
    }

    return errors;
  };

  useEffect(() => {
    retrieveTodo();
  }, [id]);
  return (
    <div className="Container">
      <h1>Todo Details</h1>
      <div className="text-center">
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={handleOnSubmit}
          validate={handleValidate}
          validateOnChange={false}
          validateOnBlur={false}
        >
          {(props) => (
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-danger"
              />

              <ErrorMessage
                name="targetDate"
                component="div"
                className="alert alert-danger"
              />
              <fieldset className="form-group">
                <label htmlFor="description">Description</label>
                <Field
                  type="text"
                  name="description"
                  className="form-control"
                />
              </fieldset>

              <fieldset className="form-group">
                <label htmlFor="targetDate">Target Date</label>
                <Field type="date" name="targetDate" className="form-control" />
              </fieldset>
              <div className="m-4">
                <button className="btn btn-success" type="submit">
                  Update
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
};

export default Todo;
