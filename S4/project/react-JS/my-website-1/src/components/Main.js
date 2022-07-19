import CardProduct from "./CardProduct";
import FormPelaporan from "./FormPelaporan";
import Introduction from "./Introduction";

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
        <div className="row">
          <div className="col-12 text-center my-5">
            <h1>Pelaporan</h1>
          </div>
        </div>
        <div className="row justify-content-lg-center ">
          <div className="col-4 m-md-2">
            <FormPelaporan />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Main;
