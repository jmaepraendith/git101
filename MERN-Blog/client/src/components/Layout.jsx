import React from 'react'
import Header from './Header'
import Footer from './Footer'

function Layout() {
  return (
    <div>
        <header></header>
            <Outlet/>
        <Footer></Footer>
    </div>
  )
}

export default Layout