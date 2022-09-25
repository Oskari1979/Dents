import { useState } from 'react';
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import ProtectedRoute from './pages/ProtectedRoute';
import Products from './pages/Products';
import ProductSearch from './pages/ProductSearch';
import NotFound from './pages/NotFound';
import SharedLayout from './pages/SharedLayout';
import SingleProduct from './pages/SingleProduct';
import LoginCheck from './pages/LoginCheck';


function App() {

  const [user, setUser] = useState(null)

  return (
  <BrowserRouter>
  
  <Routes>
    
    <Route path='/' element={<SharedLayout />} >
      <Route index element={<Home />} />
      <Route path='products' element={<Products />} />
      <Route path='products/:productId' element={<SingleProduct />} />
      <Route path='productsearch' element={<ProductSearch />} />
      <Route path='login' element={<Login setUser={setUser}></Login>} />
      <Route 
        path='logincheck' 
        element={
        <ProtectedRoute user={user}>
          
          <LoginCheck user={user}/>
        </ProtectedRoute>
        }/>
      <Route path='*' element={<NotFound />} />
    </Route>

  </Routes>
  
  </BrowserRouter>
  )
}

export default App;