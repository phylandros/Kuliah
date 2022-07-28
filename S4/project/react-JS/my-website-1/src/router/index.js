// import About from "../view/About";
// import Main from "../view/Main";
// import { Routes, Route } from "react-router-dom";

// const Router = () => {
//   return (
//     <Routes>
//       <Route path="/" elements={<Main />} />
//       <Route path="/about" elements={<About />} />
//     </Routes>
//   );
// };

// export default Router;

import React from "react";
import { Routes, Route } from "react-router-dom";
import About from "../view/About";
import Main from "../view/Main";

function Router(props) {
  return (
    <Routes>
      <Route path="/" elements={<Main />} />
      <Route path="/" elements={<About />} />
    </Routes>
  );
}

export default Router;
