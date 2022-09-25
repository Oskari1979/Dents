import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';


const Products = () => {
    const [products, setProducts]= useState([]);

    useEffect(() => {

        async function readDents() {
         await fetch("http://localhost:8080/rest/service/all")
         .then(response=>response.json())
         .then(json=>setProducts(json))
         .catch(error=>console.log("Ei toiminut"))       
       }

       readDents();
     
    }, []);
    
    
   

  return (
    <section className='section'>
      <div className='products'>
        {products.map((product, index) => {
          return (
            <article key={index}>
              <h5>{product.name}</h5>
              <Link to={`/products/${product.id}`}>more info</Link>
            </article>
          );
        })}
      </div>
    </section>
  );
};

export default Products;