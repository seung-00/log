import axios from "axios";
import {API_URL} from "./constant";

export const axiosInstance = axios.create({
  baseURL: API_URL,
  timeout: 20000,
  headers: {'content-type': 'application/json'}
});
