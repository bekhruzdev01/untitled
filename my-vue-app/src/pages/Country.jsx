import { useState, useEffect } from "react";
import axios from "axios";

export const Country = () => {
  const [countries, setCountries] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get("http://localhost:8080/country/list")
      .then(response => {
        setCountries(response.data);
        console.log(response.data);
        setLoading(false);
      })
      .catch(error => {
        setError(error.message || "Xatolik yuz berdi");
        setLoading(false);
      });
  }, []);

  if (loading) {
    return (
      <div className="d-flex justify-content-center mt-5">
        <div className="spinner-border text-success" role="status">
          <span className="visually-hidden">Yuklanmoqda...</span>
        </div>
      </div>
    );
  }

  if (error) {
    return <p className="text-danger">Xatolik: {error}</p>;
  }

  return (
    <div className="container mt-5">
        <div>

            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <form action="post">
                        <input type="form-control" placeholder="Nomi" name="name"/>
                    </form>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-outline-success">Save changes</button>
                  </div>
                </div>
              </div>
            </div>
        </div>
      <h2 className="text-center text-success">Country Ro'yxati</h2>
      <button type="button" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Yaratish</button>
      <table className="table table-bordered table-striped mt-3">
        <thead className="table-success text-center"> 
          <tr>
            <th>ID</th>
            <th>Nomi</th>
            <th>Settings</th>
          </tr>
        </thead>
        <tbody>
          {countries.map(country => (
            <tr key={country.id}>
              <td>{country.id}</td>
              <td>{country.name}</td>
              <td colSpan={2}>
                <button className="btn btn-warning">Edit</button>
                <button className="btn btn-danger">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CountryDelete = async (Id) => {
  const response = await axios.delete(`http://localhost:8080/country/delete/${Id}`);
  response.data ? alert("O'chirildi") : alert("Xatolik yuz berdi");
  window.location.reload();
};

export default CountryEdit = async (Id, Name) => {
  const response = await axios.put(`http://localhost:8080/country/update/${Id}`, { name: Name });
  response.data ? alert("O'zgartirildi") : alert("Xatolik yuz berdi");
  window.location.reload();
};