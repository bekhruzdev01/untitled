import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Country } from "./pages/Country";
import CountryList from "./pages/CountryList";

export default function App(){
  return(
    <BrowserRouter>
      <Routes>
        <Route path="/country" element={<CountryList/>} />
      </Routes>
  </BrowserRouter>
  )
}