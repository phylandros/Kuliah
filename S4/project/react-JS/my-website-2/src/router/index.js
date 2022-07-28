import React from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import BarChart from "../components/BarChart";
import About from "../view/About";
import Home from "../view/Home";

function Router(props) {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/barchart" element={<BarChart />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Router;
