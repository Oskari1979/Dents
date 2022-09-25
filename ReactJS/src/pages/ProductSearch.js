import { Link, useParams } from 'react-router-dom';

import { useEffect, useState } from 'react';


const ProductSearch = () => {
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
   
}, []);

    const searchById=async()=>{
    await fetch("http://localhost:8080/rest/service/oneById/"+query)
    .then(response=>response.json())
    .then(json=>setDent(Object.values(json)))
    .catch(error=>console.log("Ei toiminut"))
    }

  return (
    <section className='section product'>
        <div>
        <div className="searchField">
        <input type="text" placeholder="Search by ID..." onChange={(e)=> setQuery(e.target.value)} ></input>
        <button onClick={searchById}>Search</button>
        </div>


        {
        dent.map((user, index) =>
        <div key={index}>
        <h5>Product ID: {user.product_id} </h5>
        <h5>Name: {user.name}</h5>
        <h5>Weight: {user.weight}g</h5>
        <h5>Energy: {user.energy} kcal/100g</h5>
        </div>
         )}
      
      </div>
  
  </section>
    
    
  );
};

export default ProductSearch;