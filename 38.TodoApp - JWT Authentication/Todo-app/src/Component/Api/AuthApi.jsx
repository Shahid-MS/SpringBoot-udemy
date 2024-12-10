import { apiClient } from "./ApiClient";

export const jwtAuthApi = (username, password) => {
  return apiClient.post("/authenticate", {
    username,
    password,
  });
};
