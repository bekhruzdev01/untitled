import React, { useEffect, useState } from 'react';
import {
  getCountries,
  createCountry,
  updateCountry,
  deleteCountry
} from './services/countryService';

function App() {
  const [countries, setCountries] = useState([]);
  const [form, setForm] = useState({ id: null, name: '', code: '' });

  useEffect(() => {
    loadCountries();
  }, []);

  const loadCountries = async () => {
    try {
      const res = await getCountries();
      setCountries(res.data);
    } catch (error) {
      console.error('Error loading countries:', error);
    }
  };

  const handleChange = (e) => {
    setForm({...form, [e.target.name]: e.target.value});
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (form.id) {
        await updateCountry(form.id, form);
      } else {
        await createCountry(form);
      }
      setForm({ id: null, name: '', code: '' });
      loadCountries();
    } catch (error) {
      console.error('Error saving country:', error);
    }
  };

  const handleEdit = (country) => {
    setForm(country);
  };

  const handleDelete = async (id) => {
    try {
      await deleteCountry(id);
      loadCountries();
    } catch (error) {
      console.error('Error deleting country:', error);
    }
  };

  return (
    <div style={{ padding: 20 }}>
      <h1>Country CRUD</h1>
      <form onSubmit={handleSubmit} style={{ marginBottom: 20 }}>
        <input
          name="name"
          placeholder="Name"
          value={form.name}
          onChange={handleChange}
          required
          style={{ marginRight: 10 }}
        />
        <input
          name="code"
          placeholder="Code"
          value={form.code}
          onChange={handleChange}
          required
          style={{ marginRight: 10, width: 60 }}
        />
        <button type="submit">{form.id ? 'Update' : 'Add'}</button>
      </form>

      <ul>
        {countries.map((c) => (
          <li key={c.id} style={{ marginBottom: 8 }}>
            {c.name} ({c.code}){' '}
            <button onClick={() => handleEdit(c)} style={{ marginRight: 5 }}>
              Edit
            </button>
            <button onClick={() => handleDelete(c.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
