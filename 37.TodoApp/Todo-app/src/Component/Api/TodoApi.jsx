import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8080",
});

export const retrieveTodoByUsername = (username) =>
  apiClient.get(`/users/${username}/todos`);

export const deleteById = (username, id) =>
  apiClient.delete(`/users/${username}/todos/${id}`);
