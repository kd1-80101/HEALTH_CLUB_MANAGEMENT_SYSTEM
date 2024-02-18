import { useEffect,  } from 'react'; //usestate
import AOS from 'aos'; // Import AOS library
import 'aos/dist/aos.css'; // Import AOS CSS
import Navbar from './NavBar';
import Footer from './Footer';
import Header from './Header';
import About from './About';
import Classes from './Classes';
import Contact from './Contact';
import Membership from './Membership';
// import Schedules from './Schedules'; // Import the Schedules component
// Import authentication-related functions or states from your authentication context or Redux store

const Home = () => {
  // State to track whether the user is authenticated
  // const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    // Placeholder logic for authentication checks (replace with actual authentication logic)
    // const checkAuthentication = () => {
    //   // Simulate authentication checks (e.g., checking for a token in sessionStorage)
    //   const token = sessionStorage.getItem('jwtToken');
    //   if (token) {
    //     setIsAuthenticated(true); // Set isAuthenticated to true if token exists
    //   }
    // };

    // // Call the authentication check function
    // checkAuthentication();

    // AOS ANIMATION
    AOS.init({
      disable: 'mobile',
      duration: 800,
      anchorPlacement: 'center-bottom'
    });

    // SMOOTHSCROLL NAVBAR
    document.querySelectorAll('.navbar a, .hero-text a').forEach(item => {
      item.addEventListener('click', event => {
        const target = document.querySelector(event.target.getAttribute('href'));
        if (target) {
          event.preventDefault();
          window.scrollTo({
            top: target.offsetTop - 49,
            behavior: 'smooth'
          });
        }
      });
    });
  }, []);

  return (
    <>
      <Navbar />
      <Header />
      <About/>
      <Classes/>
      {/* {isAuthenticated && <Schedules />} Render Schedules component only if user is authenticated */}
      <Contact/>
      <Membership/>
      <Footer />
    </>
  );
}

export default Home;
