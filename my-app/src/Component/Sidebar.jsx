import { Link, useLocation } from "react-router-dom"

export const Sidebar = ()=>{
    const pathname = useLocation().pathname
  const Branchs = [
    { name: 'Birinchi bo\'lim', link: '/', logo: 'fa-solid fa-house' },
    { name: 'Ikkinchi bo\'lim', link: '/last', logo: 'fa-solid fa-list' },
    { name: 'Kategoriylar', link: '/kategory', logo: 'fa-solid fa-layer-group' },  
    { name: 'Cbu', link: '/cbu', logo: 'fa-solid fa-money-check-dollar' }
  ]
    return(
        <div>
            
        <nav id="sidebarMenu" class="collapse  d-lg-block sidebar collapse bg-white">
          <div class="position-sticky">
            <div class="list-group list-group-flush mx-3 mt-4">
              {Branchs.map(item => (
                <Link
                  to={item.link}
                  class={`list-group-item list-group-item-action py-2 ripple ${pathname === item.link ? "active" : ""}`}
                  aria-current="true"
                >
                 <i class={item.logo}></i><span>{item.name}</span>
                </Link>
              ))}
            </div>
          </div>
        </nav>

        <nav id="main-navbar" class="navbar active navbar-expand-lg bg-white fixed-top">
          <div class="container-fluid">
            <button data-mdb-button-init
              class="navbar-toggler"
              type="button"
              data-mdb-collapse-init
              data-mdb-target="#sidebarMenu"
              aria-controls="sidebarMenu"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <i class="fas fa-bars"></i>
            </button>

            <a class="navbar-brand" href="#">
              <img
                src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
                height="25"
                alt="MDB Logo"
                loading="lazy"
              />
            </a>
            <form class="d-none d-md-flex input-group w-auto my-auto">
              <input
                autocomplete="off"
                type="search"
                class="form-control rounded"
                placeholder='Search (ctrl + "/" to focus)'
                style={{ minWidth: '225px' }}
              />
              <span class="input-group-text border-0"><i class="fas fa-search"></i></span>
            </form>

            <ul class="navbar-nav ms-auto d-flex flex-row">
              <li class="nav-item dropdown">
                <a
                  data-mdb-dropdown-init class="nav-link me-3 me-lg-0 dropdown-toggle hidden-arrow"
                  href="#"
                  id="navbarDropdownMenuLink"
                  role="button"
                  data-mdb-toggle="dropdown"
                  aria-expanded="false"
                >
                  <i class="fas fa-bell"></i>
                  <span class="badge rounded-pill badge-notification bg-danger">1</span>
                </a>
                <ul
                  class="dropdown-menu dropdown-menu-end"
                  aria-labelledby="navbarDropdownMenuLink"
                >
                  <li>
                    <a class="dropdown-item" href="#">Some news</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">Another news</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">Something else here</a>
                  </li>
                </ul>
              </li>

              <li class="nav-item">
                <a class="nav-link me-3 me-lg-0" href="#">
                  <i class="fas fa-fill-drip"></i>
                </a>
              </li>
              <li class="nav-item me-3 me-lg-0">
                <a class="nav-link" href="#">
                  <i class="fab fa-github"></i>
                </a>
              </li>

              <li class="nav-item dropdown">
                <a
                  data-mdb-dropdown-init class="nav-link me-3 me-lg-0 dropdown-toggle hidden-arrow"
                  href="#"
                  id="navbarDropdown"
                  role="button"
                  data-mdb-toggle="dropdown"
                  aria-expanded="false"
                >
                  <i class="flag-united-kingdom flag m-0"></i>
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                  <li>
                    <a class="dropdown-item" href="#"
                    ><i class="flag-united-kingdom flag"></i>English
                      <i class="fa fa-check text-success ms-2"></i
                      ></a>
                  </li>
                  <li><hr class="dropdown-divider" /></li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-poland flag"></i>Polski</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-china flag"></i>中文</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-japan flag"></i>日本語</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-germany flag"></i>Deutsch</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-france flag"></i>Français</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-spain flag"></i>Español</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-russia flag"></i>Русский</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-portugal flag"></i>Português</a>
                  </li>
                </ul>
              </li>

              <li class="nav-item dropdown">
                <a
                  data-mdb-dropdown-init class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center"
                  href="#"
                  id="navbarDropdownMenuLink"
                  role="button"
                  data-mdb-toggle="dropdown"
                  aria-expanded="false"
                >
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img (31).webp"
                    class="rounded-circle"
                    height="22"
                    alt="Avatar"
                    loading="lazy"
                  />
                </a>
                <ul
                  class="dropdown-menu dropdown-menu-end"
                  aria-labelledby="navbarDropdownMenuLink"
                >
                  <li>
                    <a class="dropdown-item" href="#">My profile</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">Settings</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">Logout</a>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </nav>
        </div>
    )
}