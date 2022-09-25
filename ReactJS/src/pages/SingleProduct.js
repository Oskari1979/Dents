import { Link, useParams } from 'react-router-dom';

import { useEffect, useState } from 'react';


const SingleProduct = () => {
  const { productId } = useParams();
  const [dent, setDent] = useState([]);
  const [query, setQuery] = useState('');

 console.log(productId);
 

  useEffect(() => {

    async function readOne(){
        await fetch("http://localhost:8080/rest/service/one/"+productId)
        .then(response=>response.json())
        .then(json=>setDent(Object.values(json)))
        .catch(error=>console.log("Ei toiminut"))       
        
   }

   readOne();
   console.log("UseEffects juoksi yksin...");
}, []);

  return (
    <section className='section product'>
        <div>
      
        {
        dent.map((user, index) =>
        <div key={index}>
        <h2>{user.name}</h2>
        <h5>Product ID: {user.product_id} </h5>
        
        <h5>Weight: {user.weight} grammaa</h5>
        <h5>Energy: {user.energy} kcal/100g</h5>
        </div>
         )}
           
      <Link to='/products'>back to products</Link>
      </div>
  
  </section>
    
    
  );
};

export default SingleProduct;