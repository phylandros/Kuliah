import React from "react";
import NavigationBar from "../components/NavigationBar";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { Container, Row, Col } from "react-bootstrap";
import CardHeader from "react-bootstrap/esm/CardHeader";
import Footer from "../components/Footer";
import "../styles/AboutPage.css";

function About(props) {
  return (
    <div className="mybg">
      <NavigationBar />
      <Container fluid>
        <div>
          <Card className="text-center">
            <Row classna>
              <Col sm>
                <CardHeader>Profile</CardHeader>
                <Card.Body>
                  <Card.Title>BGES BEKASI</Card.Title>
                </Card.Body>
                <Card.Text>
                  Website ini dikelola oleh divisi BGES Witel Bekasi di bawah PT
                  Telekomunikasi Indonesia wilayah Nelaso. BGES Witel Bekasi
                  mengelola beragam produk dan perangkat internet guna memenuhi
                  kebutuhan para pelanggan yang berasal dari berbagai segmen.
                  Kami melayani permintaan produk dan layanan yang berada di
                  wilayah Kota Bekasi dan Kabupaten Bekasi Produk yang kami
                  sediakan di antaranya yakni High Speed Internet, Astinet,
                  Astinet Lite, VPN IP, Metro, Voice, dan beragam CPE guna
                  memenuhi kebutuhan teknologi Client.
                </Card.Text>
                <Card.Text>
                  Berminat ? Daftarkan diri anda dengan klik tombol di bawah ini
                </Card.Text>
                <Button variant="primary">Daftar</Button>
                <div></div>
              </Col>
            </Row>
          </Card>
        </div>
      </Container>

      <div>
        <Footer />
      </div>
      <div></div>
    </div>
  );
}

export default About;
