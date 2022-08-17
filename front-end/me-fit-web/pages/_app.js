import '../styles/globals.css'
import Navbar from '../src/components/NavbarComponent'
import FooterMeFit from '../src/components/FooterMeFit'

function MyApp({ Component, pageProps }) {
  return (
    <div>  
      <Navbar/>
      <Component {...pageProps} />
     <FooterMeFit/>
    </div>)
}

export default MyApp
