
const Header = () => {
  const handleBecomeMemberClick = () => {
    const isAuthenticated = sessionStorage.getItem('jwtToken') !== null; // Check if user is authenticated
    if (isAuthenticated) {
      window.location.href = '/payments'; // Redirect to payments page if authenticated
    } else {
      window.location.href = '/signup'; // Redirect to signup page if not authenticated
    }
  };

  return ( 
    <div>
      <section className="hero d-flex flex-column justify-content-center align-items-center" id="home">
        <div className="container-fluid">
          <div className="bg-overlay"></div>
          <div className="row">
            <div className="col-lg-8 col-md-10 mx-auto col-12">
              <div className="hero-text mt-5 text-center">
                <h6 data-aos="fade-up" data-aos-delay="300">new way to build a healthy lifestyle!</h6>
                <h1 className="text-white" data-aos="fade-up" data-aos-delay="500">Upgrade your body with healmate</h1>
                <button className="btn custom-btn mt-3" data-aos="fade-up" data-aos-delay="600" onClick={handleBecomeMemberClick}>Get started</button>
                <a href="#about" className="btn custom-btn bordered mt-3" data-aos="fade-up" data-aos-delay="700">learn more</a>
              </div>
            </div>
          </div>
        </div>
      </section>

      <section className="feature" id="feature">
        <div className="container-fluid">
          <div className="row">
            <div className="d-flex flex-column justify-content-center ml-lg-auto mr-lg-5 col-lg-5 col-md-6 col-12">
              <h2 className="mb-3 text-white" data-aos="fade-up">New to the healmate?</h2>
              <h6 className="mb-4 text-white" data-aos="fade-up">Your membership is up to 2 months FREE (₹1000 per month)</h6>
              <button className="btn custom-btn bg-color mt-3" data-aos="fade-up" data-aos-delay="300" onClick={handleBecomeMemberClick}>Become a member today</button>
            </div>
            <div className="mr-lg-auto mt-3 col-lg-4 col-md-6 col-12">
              <div className="about-working-hours">
                <div>
                  <h2 className="mb-4 text-white" data-aos="fade-up" data-aos-delay="500">Working hours</h2>
                  <strong className="d-block" data-aos="fade-up" data-aos-delay="600">Sunday : Closed</strong>
                  <strong className="mt-3 d-block" data-aos="fade-up" data-aos-delay="700">Monday - Friday</strong>
                  <p data-aos="fade-up" data-aos-delay="800">6:00 AM - 10:00 PM</p>
                  <strong className="mt-3 d-block" data-aos="fade-up" data-aos-delay="700">Saturday</strong>
                  <p data-aos="fade-up" data-aos-delay="800">6:00 AM - 4:00 PM</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Header;
