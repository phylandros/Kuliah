import "./App.css";
import Footer from "./components/Footer";
import Main from "./components/Main";
import NavigationBar from "./components/NavigationBar";
import "./styles/LandingPage.css";

function App() {
  return (
    <div>
      <div className="mybg">
        <NavigationBar />
        <Main />
        <Footer />
      </div>
    </div>
  );
}

export default App;
