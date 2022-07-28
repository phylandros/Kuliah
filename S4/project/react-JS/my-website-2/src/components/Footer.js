import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";

const Footer = () => {
  return (
    <div className="bg-dark">
      <Navbar variant="dark">
        <Container>
          {/* <Navbar.Brand href="#home">Footer</Navbar.Brand> */}
          <Navbar.Toggle />
          <Navbar.Collapse className="justify-content-end">
            <Navbar.Text>Copyright © 2022 Ariyansa Yusuf Saputra</Navbar.Text>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
};

export default Footer;
