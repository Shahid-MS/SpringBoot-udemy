import axios from "axios";

// export function retrieveHelloWorld() {
//   return axios.get("http://localhost:8080/hello-world");
// }

// export const retrieveHelloWorldBean = () =>
//   axios.get("http://localhost:8080/hello-world-bean");

// export const retrieveHelloWorldPathvariable = (username) =>
//   axios.get(`http://localhost:8080/hello-world-bean/path-variable/${username}`);

const apiClient = axios.create({
  baseURL: "http://localhost:8080",
});

export function retrieveHelloWorld() {
  return apiClient.get("/hello-world");
}

export const retrieveHelloWorldBean = () => apiClient.get("/hello-world-bean");

export const retrieveHelloWorldPathvariable = (username) =>
  apiClient.get(`/hello-world-bean/path-variable/${username}`);
