import CardProduct from "../components/CardProduct";
// import FormPelaporan from "../components/FormPelaporan";
import Introduction from "../components/Introduction";

const Main = () => {
  return (
    <div>
      <Introduction />
      <div className="container">
        <div className="row">
          <div className="col-12 text-center my-5">
            <h1>Layanan</h1>
          </div>
        </div>
        <div>
          <CardProduct />
        </div>
        {/* <div className="row">
          <div className="col-12 text-center my-5">
            <h1>Pelaporan</h1>
          </div>
        </div>
        <div className="row justify-content-lg-center ">
          <div className="col-4 m-md-2">
            <FormPelaporan />
          </div>
        </div> */}
      </div>
    </div>
  );
};

export default Main;
