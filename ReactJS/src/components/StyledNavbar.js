import { NavLink } from 'react-router-dom';

const StyledNavbar = () => {
    return (
      <nav className='navbar'>
       
        <NavLink to='/products'
            style={({ isActive }) => {
            return { color: isActive ? 'red' : 'grey' };
            }}>Products</NavLink>
        <NavLink to='/productsearch'
            style={({ isActive }) => {
            return { color: isActive ? 'red' : 'grey' };
            }}>Product Search</NavLink>
        <NavLink to='/login'
            style={({ isActive }) => {
            return { color: isActive ? 'red' : 'grey' };
            }}>Login</NavLink>
      </nav>
    );
  };
  export default StyledNavbar;
