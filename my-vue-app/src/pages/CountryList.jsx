import { useState, useEffect } from 'react';
import axios from 'axios';
import CountryModal from './CountryModel';

export default function CountryList() {
  const [countries, setCountries] = useState([]);
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    axios.get('http://localhost:8080/country/list')
      .then(response => setCountries(response.data))
      .catch(error => console.error('Xatolik yuz berdi:', error));
  }, []);

  const handleAddClick = () => {
    setShowModal(true);
  };

  const handleCloseModal = () => {
    setShowModal(false);
  };

  const handleSaveCountry = (newCountry) => {
    setCountries(prevCountries => [...prevCountries, newCountry]);
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center text-success">Davlatlar Ro'yxati</h2>
      <button type="button" className="btn btn-outline-success" onClick={handleAddClick}>
        Yangi Davlat Qo'shish
      </button>

      {showModal && <CountryModal onClose={handleCloseModal} onSave={handleSaveCountry} />}

      <table className="table table-bordered table-striped mt-3">
        <thead className="table-success text-center">
          <tr>
            <th>ID</th>
            <th>Nomi</th>
          </tr>
        </thead>
        <tbody>
          {countries.map(country => (
            <tr key={country.id}>
              <td>{country.id}</td>
              <td>{country.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
