import { apiClient } from "./ApiClient";

export const basicAuthApi = (token) => {
  return apiClient.get("/basicauth", {
    headers: {
      Authorization: token,
    },
  });
};
