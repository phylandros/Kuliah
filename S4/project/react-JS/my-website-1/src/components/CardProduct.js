import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import image1 from "./../assets/astinet.png";
import image2 from "./../assets/vpnip.png";
import image3 from "./../assets/metro.png";
import image4 from "./../assets/telin.png";
import { CardGroup } from "react-bootstrap";

const CardProduct = () => {
  return (
    <div>
      <CardGroup className="container">
        <Card className="me-3 shadow p-3 mb-5 bg-body rounded">
          <Card.Img variant="top" src={image1} />
          <Card.Body>
            <Card.Title>ASTINet</Card.Title>
            <Card.Text>
              Layanan akses internet melalui Dedicated Internet selama 24 jam
              sehari dengan jaminan ratio bandwidth 1:1
            </Card.Text>
          </Card.Body>
          <Button variant="primary">Detail</Button>
        </Card>
        <Card className="me-3 shadow p-3 mb-5 bg-body rounded">
          <Card.Img variant="top" src={image2} />
          <Card.Body>
            <Card.Title>VPN IP</Card.Title>
            <Card.Text>
              Menyediakan alamat IP sementara dan menyembunyikan yang alamat IP
              yang asli. Solusi terbaik yang menawarkan keamanan dan privasi
              jaringan untuk jaringan publik dan pribadi
            </Card.Text>
          </Card.Body>
          <Button variant="primary">Detail</Button>
        </Card>
        <Card className="me-3 shadow p-3 mb-5 bg-body rounded">
          <Card.Img variant="top" src={image3} />
          <Card.Body>
            <Card.Title>Metro E</Card.Title>
            <Card.Text>
              Metro Ethernet adalah sebuah solusi untuk mendapatkan jaringan
              dengan kapasitas lebih tinggi yang fleksibel, mudah diakses,
              efektif, dan terpercaya karena didukung QoS yang dapat disesuaikan
              dengan kebutuhan anggaran atau bisnis dan OLO (Operator License
              Lainnya)
            </Card.Text>
          </Card.Body>
          <Button variant="primary">Detail</Button>
        </Card>
        <Card className="me-3 shadow p-3 mb-5 bg-body rounded">
          <Card.Img variant="top" src={image4} />
          <Card.Body>
            <Card.Title>Card title</Card.Title>
            <Card.Text>
              This is a wider card with supporting text below as a natural
              lead-in to additional content. This card has even longer content
              than the first to show that equal height action.
            </Card.Text>
          </Card.Body>
          <Button variant="primary">Detail</Button>
        </Card>
      </CardGroup>
    </div>
  );
};

export default CardProduct;
