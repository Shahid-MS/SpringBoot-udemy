import { ErrorMessage, Field, Form, Formik } from "formik";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./Security/AuthContext";
import { createTodoApi } from "./Api/TodoApi";
import moment from "moment";

const NewTodo = () => {
  const authContext = useAuth();
  const username = authContext.username;
  const navigate = useNavigate();

  const handleOnSubmit = (res) => {
    // console.log(value);
    const todo = {
      username,
      description: res.description,
      targetDate: res.targetDate,
      done: false,
    };
    console.log(todo);
    createTodoApi(username, todo)
      .then(() => {
        navigate("/todos");
      })
      .catch((err) => console.log(err));
  };

  const handleValidate = (value) => {
    // console.log(value);
    let errors = {};
    if (value.description.length < 5) {
      errors.description = "Enter a valid description";
    }

    if (value.targetDate === null || !moment(value.targetDate).isValid()) {
      errors.targetDate = "Enter Target date";
    }

    return errors;
  };

  const initialValues = {
    description: "", // Default description value
    targetDate: null, // Default targetDate value
  };

  return (
    <div className="Container">
      <h1>Todo Details</h1>
      <div className="text-center">
        <Formik
          initialValues={initialValues}
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
                  Add
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
};

export default NewTodo;
