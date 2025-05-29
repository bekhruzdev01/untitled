import { useState } from 'react';
import axios from 'axios';

export default function CountryModal({ onClose, onSave }) {
  const [name, setName] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError('');

    try {
      const response = await axios.post('http://localhost:8080/country/add', { name });
      onSave(response.data); // Yangi davlatni ro'yxatga qo'shish
      onClose(); // Modalni yopish
    } catch (err) {
      setError('Xatolik yuz berdi: ' + err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="modal fade" id="countryModal" tabIndex="-1" aria-labelledby="countryModalLabel" aria-hidden="true">
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title" id="countryModalLabel">Yangi Davlat Qo'shish</h5>
            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close" onClick={onClose}></button>
          </div>
          <div className="modal-body">
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <label htmlFor="name" className="form-label">Nomi</label>
                <input
                  type="text"
                  className="form-control"
                  id="name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  required
                />
              </div>
              {error && <div className="alert alert-danger">{error}</div>}
              <button type="submit" className="btn btn-primary" disabled={loading}>
                {loading ? 'Yuborilmoqda...' : 'Saqlash'}
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
