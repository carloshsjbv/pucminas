import '../styles/globals.css'
import Navbar from '../src/components/NavbarComponent'

function MyApp({ Component, pageProps }) {
  return (
    <div>      
      <Navbar/>
      <Component {...pageProps} />
    </div>)
}

export default MyApp
