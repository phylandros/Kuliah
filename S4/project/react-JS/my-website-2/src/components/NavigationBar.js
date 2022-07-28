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
    <Navbar bg="dark" variant="dark">
      <Container fluid>
        <Navbar.Brand href="/">BGES WITEL BEKASI</Navbar.Brand>
        <Nav className="me-auto">
          <Nav.Link href="/">Home</Nav.Link>
          <Nav.Link href="/about">About</Nav.Link>
          <Nav.Link href="/contact_us">Contact Us</Nav.Link>
          <Nav.Link href="/barchart">BarChart</Nav.Link>
        </Nav>
        <div>
          <Form>
            <Row className="align-items-center">
              <Col className="my-1">
                <Form.Label
                  htmlFor="inlineFormInputGroupUsername"
                  visuallyHidden
                >
                  Username
                </Form.Label>
                <Form.Control
                  id="inlineFormInputGroupUsername"
                  placeholder="Username"
                />
              </Col>
              <Col className="my-1">
                <Form.Label
                  htmlFor="inlineFormInputGroupPassword"
                  visuallyHidden
                >
                  Password
                </Form.Label>
                <Form.Control
                  id="inlineFormInputGroupPassword"
                  placeholder="Password"
                />
              </Col>
              {/* <Col xs="auto" className="my-1">
                <Form.Check
                  type="checkbox"
                  id="autoSizingCheck2"
                  label="Remember me"
                  className="primary"
                />
              </Col> */}
              <Col xs="auto" className="my-1">
                <Button type="Login">Login</Button>
              </Col>
            </Row>
          </Form>
        </div>
      </Container>
    </Navbar>
  );
};

export default NavigationBar;
