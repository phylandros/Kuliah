import { Navbar, Container, Nav } from "react-bootstrap";
import React from "react";

const NavigationBar = () => {
  return (
    <div className="bg-dark">
      <Navbar variant="dark">
        <Container>
          <Navbar.Brand>BGES WITEL BEKASI</Navbar.Brand>
          <Nav>
            <Nav.Link>Home</Nav.Link>
            <Nav.Link>About</Nav.Link>
            <Nav.Link>Contact Us</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </div>
  );
};

export default NavigationBar;
