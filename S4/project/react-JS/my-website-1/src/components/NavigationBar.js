import {
  Navbar,
  Container,
  Nav,
  Form,
  Button,
  Row,
  Col,
} from "react-bootstrap";
import React from "react";

const NavigationBar = () => {
  return (
    <div className="bg-dark">
      <Navbar variant="dark">
        <Container fluid>
          <Navbar.Brand>BGES WITEL BEKASI</Navbar.Brand>

          <Form>
            <Row>
              <Col>
                <Nav>
                  <Nav.Link className="m-2">Home</Nav.Link>
                  <Nav.Link className="m-2">About</Nav.Link>
                  <Nav.Link className="m-2">Contact Us</Nav.Link>
                  <Form.Group className="m-2" controlId="formBasicUsername">
                    <Form.Control
                      type="username"
                      placeholder="Enter Username"
                    />
                  </Form.Group>
                  <Form.Group className="m-2" controlId="formBasicPassword">
                    <Form.Control
                      type="password"
                      placeholder="Enter password"
                    />
                  </Form.Group>
                  <Button className="m-2" variant="primary">
                    Login
                  </Button>
                  {/* <Button className="m-2" variant="secondary">
                    Sign Up
                  </Button> */}
                </Nav>
              </Col>
            </Row>
          </Form>
        </Container>
      </Navbar>
    </div>
  );
};

export default NavigationBar;
