import { Navbar, Container, Nav } from "react-bootstrap";
import React from "react";

const NavigationBar = () => {
  return (
    <div className="bg-dark">
      <Navbar variant="dark">
        <Container>
          <Navbar.Brand>BGES WITEL BEKASI</Navbar.Brand>
          <Nav>
            <Nav.Link to="/">Home</Nav.Link>
            <Nav.Link to="/About">About</Nav.Link>
            <Nav.Link to="/ContactUs">Contact Us</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </div>
  );
};

export default NavigationBar;
