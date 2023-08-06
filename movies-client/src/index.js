import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
//config de bootstrap
import 'bootstrap/dist/css/bootstrap.min.css';
//config de dotenv


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);