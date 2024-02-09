import axios from "axios";
import {API_URL} from "./constant";

export const axiosInstance = axios.create({
  baseURL: API_URL,
  timeout: 20000,
  headers: {'content-type': 'application/json'}
});

axiosInstance.interceptors.response.use(
  (response) => {
    return response;
  },
  (error) => {
    if (error.response?.status === 500) {
      console.error('500 error');
      window.location.href = '/error';
      return
    }

    console.error('error', error);
    return;
  }
);
