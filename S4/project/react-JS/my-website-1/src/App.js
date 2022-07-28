import "./App.css";
import Footer from "./components/Footer";
import Main from "./view/Main";
import NavigationBar from "./components/NavigationBar";
import "./styles/LandingPage.css";
import Router from "./router";

function App() {
  return (
    <Router />

    // <div>
    //   <div className="mybg">
    //     <NavigationBar />
    //     <Router />
    //     <Main />
    //     <Footer />
    //   </div>
    // </div>
  );
}

export default App;
