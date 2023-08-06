import axios from 'axios';

const BASE_URL = process.env.REACT_APP_BASE_BACKEND_URL;

const axiosInstance = axios.create({
  baseURL: BASE_URL,
  headers: {
    'Content-Type': 'application/json',
    'Custom-User-Agent': process.env.REACT_APP_ALLOWED_CLIENT
  },
});

axiosInstance.interceptors.response.use(
  (response) => response.data,
  (error) => {
    const errorMessage =
      (error.response && error.response.data.message) || 'Ha ocurrido un error en la petición.';
    return Promise.reject(new Error(errorMessage));
  }
);

export default axiosInstance;
