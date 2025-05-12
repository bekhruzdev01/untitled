import {Outlet} from 'react-router-dom'
import './style.css'
import { Sidebar } from '../Component/Sidebar'

export const DashboardLayout = () => {
  
  return (
    <div>
      <header>
        <Sidebar/>
      </header>

      <main style={{ marginTop: '58px' }}>
        <div class="container pt-4">
          <Outlet/>
        </div>
      </main>
    </div>
  )
}