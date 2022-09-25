import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';


const LoginCheck = ({ user }) => {

    const [login, setLogin] = useState([]);
    const [name, setName] = useState(user.name);
    const [pass, setPass] = useState(user.pass);
    const navigate = useNavigate();

    useEffect(() => {

        async function checkUser(){
            await fetch("http://localhost:8080/rest/loginservice/check/"+name+"/"+pass)
            .then(response=>response.json())
            .then(json=>setLogin(Object.values(json)))
            .catch(error=>console.log("Ei toiminut"))          
       }

       checkUser();
    }, []);

   

    return (
      <section className='section'>
        <h4>Hello, {user?.name}. </h4>
        <h5>Login status: {login}</h5>
        </section>
    );
    };
    
  export default LoginCheck;