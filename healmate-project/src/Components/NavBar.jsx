function Navbar() {
    return ( 
        <nav className="navbar navbar-expand-lg fixed-top">
            <div className="container-fluid">
                <a className="navbar-brand" href="index.html">healmate</a>

                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav ml-lg-auto">
                        <li className="nav-item">
                            <a href="#home" className="nav-link smoothScroll">Home</a>
                        </li>

                        <li className="nav-item">
                            <a href="#about" className="nav-link smoothScroll">About Us</a>
                        </li>

                        <li className="nav-item">
                            <a href="#class" className="nav-link smoothScroll">Classes</a>
                        </li>

                        {/* <li className="nav-item">
                            <a href="#schedule" className="nav-link smoothScroll">Schedules</a>
                        </li> */}

                        <li className="nav-item">
                            <a href="#contact" className="nav-link smoothScroll">Contact</a>
                        </li>

                        <li className="nav-item">
                            <a href="/signin" className="nav-link smoothScroll">Login</a>
                        </li>

                        <li className="nav-item">
                            <a href="/signup" className="nav-link smoothScroll">Sign Up</a>
                         </li>
                        
                    </ul>

                    <ul className="social-icon ml-lg-3">
                        <li><a href="https://fb.com" className="fa fa-facebook"></a></li>
                        <li><a href="#" className="fa fa-twitter"></a></li>
                        <li><a href="#" className="fa fa-instagram"></a></li>
                    </ul>
                </div>

            </div>
        </nav>
    );
}

export default Navbar;
