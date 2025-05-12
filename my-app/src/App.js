import { BrowserRouter, Route, Routes } from 'react-router-dom'
// import { Main } from './pages/Main';
// import CarList from './pages/car/CarList';
// import Index from './pages/Index';
import { DashboardLayout } from './Layout/DashboardLayout';
import { First } from './pages/First';
import Last from './pages/Last';
import { Cbu } from './pages/Cbu';
import AuthForm from './pages/AuthForm';
import { useEffect } from 'react';
import { onAuthStateChanged } from 'firebase/auth';
import { auth } from './firebase';

function App() {
  useEffect(()=>{
    const checkLogin = onAuthStateChanged(auth, (user)=> {
      user?(
        alert('bor')
      ):(
        alert('yo\'q')
      )
    })
    return ()=>checkLogin();
  }, [])
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<DashboardLayout />}>
          <Route index element={<First />} />
          <Route path='/last' element={<Last />} />
          <Route path='/cbu' element={<Cbu/>}/>
          <Route path='/login' element={<AuthForm/>}/>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
