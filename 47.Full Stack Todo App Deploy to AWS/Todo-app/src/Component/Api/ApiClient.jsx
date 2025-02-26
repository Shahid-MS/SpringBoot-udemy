import axios from "axios";

export const apiClient = axios.create({
  // baseURL: "http://localhost:8080",
  // baseURL: "http://localhost:5000",
  baseURL: "http://todoapp-env.eba-emepb48q.us-east-1.elasticbeanstalk.com/",
});
