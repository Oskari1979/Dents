import { useState } from 'react';
import { useNavigate } from 'react-router-dom';


const Login = ({ setUser }) => {
  const [name, setName] = useState('');
  const [pass, setPass] = useState('');

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!name || !pass) return;
    setUser({ name: name, pass: pass });

    navigate('/logincheck');
  };

  return (
    <section className='section'>
      <form className='form' onSubmit={handleSubmit}>
        <h5>login</h5>
        <div className='form-row'>
          <label htmlFor='name' className='form-label'>
            name
          </label>
          <input
            type='text'
            className='form-input'
            id='name'
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <div className='form-row'>
          <label htmlFor='email' className='form-label'>
            Password
          </label>
          <input
            type='password'
            className='form-input'
            id='pass'
            value={pass}
            onChange={(e) => setPass(e.target.value)}
          />
        </div>
        <button type='submit' className='btn btn-block'>
          login
        </button>
      </form>
    </section>
  );
};
export default Login;
