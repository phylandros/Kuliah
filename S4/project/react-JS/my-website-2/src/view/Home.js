import React from "react";
import CardProducts from "../components/CardProducts";
import Footer from "../components/Footer";
import Introduction from "../components/Introduction";
import NavigationBar from "../components/NavigationBar";
import "../styles/LandingPage.css";

function Home(props) {
  return (
    <div className="mybg">
      <NavigationBar />
      <div>
        <Introduction />
        <div className="container">
          <div className="row">
            <div className="col-12 text-center my-5">
              <h1>Layanan</h1>
            </div>
          </div>
          <div>
            <CardProducts />
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default Home;
