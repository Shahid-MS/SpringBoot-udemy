import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8080",
});

export const retrieveTodoByUsername = (username) =>
  apiClient.get(`/users/${username}/todos`);

export const deleteById = (username, id) =>
  apiClient.delete(`/users/${username}/todos/${id}`);

export const findById = (username, id) => {
  return apiClient.get(`/users/${username}/todos/${id}`);
};

export const updateTodoApi = (username, id, todo) => {
  return apiClient.put(`/users/${username}/todos/${id}`, todo);
};

export const createTodoApi = (username, todo) => {
  return apiClient.post(`/users/${username}/todos`, todo);
};
