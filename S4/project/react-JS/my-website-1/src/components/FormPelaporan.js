import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";

const FormPelaporan = () => {
  return (
    <Form>
      <Row className="mb-3">
        <Form.Group as={Col} controlId="formGridFirstname">
          <Form.Label>First Name</Form.Label>
          <Form.Control type="FirstName" placeholder="First Name" />
        </Form.Group>

        <Form.Group as={Col} controlId="formGridLastName">
          <Form.Label>Last Name</Form.Label>
          <Form.Control type="LastName" placeholder="Last Name" />
        </Form.Group>
      </Row>

      <Form.Group className="mb-3" controlId="formGridAddress1">
        <Form.Label>Address</Form.Label>
        <Form.Control placeholder="1234 Main St" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formGridAddress2">
        <Form.Label>Address 2</Form.Label>
        <Form.Control placeholder="Apartment, studio, or floor" />
      </Form.Group>

      <Row className="mb-3">
        <Form.Group as={Col} controlId="formGridCity">
          <Form.Label>City</Form.Label>
          <Form.Control />
        </Form.Group>

        <Form.Group as={Col} controlId="formGridState">
          <Form.Label>State</Form.Label>
          <Form.Select defaultValue="Choose...">
            <option>Choose</option>
            <option>Aceh</option>
            <option>Bali</option>
            <option>Bangka Belitung</option>
            <option>Banten</option>
            <option>Bengkulu</option>
            <option>Gorontalo</option>
            <option>Irian Jaya Barat</option>
            <option>Jakarta</option>
            <option>Jambi</option>
            <option>Jawa Barat</option>
            <option>Jawa Tengah</option>
            <option>Jawa Timur</option>
            <option>Kalimantan Barat</option>
            <option>Kalimantan Selatan</option>
            <option>Kalimantan Tengah</option>
            <option>Kalimantan Timur</option>
            <option>Kepulauan Riau</option>
            <option>Lampung</option>
            <option>Maluku</option>
            <option>Maluku Utara</option>
            <option>Nusa Tenggara Barat</option>
            <option>Nusa Tenggara Timur</option>
            <option>Papua</option>
            <option>Riau</option>
            <option>Sulawesi Barat</option>
            <option>Sulawesi Selatan</option>
            <option>Sulawesi Tengah</option>
            <option>Sulawesi Tenggara</option>
            <option>Sulawesi Utara</option>
            <option>Sulawesi Barat</option>
            <option>Sulawesi Selatan</option>
            <option>Sulawesi Utara</option>
            <option>Yogyakarta</option>
          </Form.Select>
        </Form.Group>

        <Form.Group as={Col} controlId="formGridZip">
          <Form.Label>Zip</Form.Label>
          <Form.Control />
        </Form.Group>
      </Row>

      <Form.Group className="mb-3" id="formGridCheckbox">
        <Form.Check type="checkbox" label="Check me out" />
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default FormPelaporan;
