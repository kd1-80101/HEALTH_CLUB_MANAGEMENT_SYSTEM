function Contact() {
    return ( 
        <section className="contact section" id="contact">
            <div className="container-fluid">
                <div className="row">
                    <div className="ml-auto col-lg-5 col-md-6 col-12">
                        <h2 className="mb-4 pb-2" data-aos="fade-up" data-aos-delay="200">Feel free to ask anything</h2>
                        <form action="#" method="post" className="contact-form webform" data-aos="fade-up" data-aos-delay="400" role="form">
                            <input type="text" className="form-control" name="cf-name" placeholder="Name" />
                            <input type="email" className="form-control" name="cf-email" placeholder="Email" />
                            <textarea className="form-control" rows="5" name="cf-message" placeholder="Message"></textarea>
                            <button type="submit" className="btn custom-btn" id="submit-button" name="submit">Send Message</button>
                        </form>
                    </div>
                    <div className="mx-auto mt-4 mt-lg-0 mt-md-0 col-lg-5 col-md-6 col-12">
                        <h2 className="mb-4" data-aos="fade-up" data-aos-delay="600">Where you can <span>find us</span></h2>
                        <p data-aos="fade-up" data-aos-delay="800"><i className="fa fa-map-marker mr-1"></i>sunbeam karad -shaniwar peth</p>
                        <div className="google-map" data-aos="fade-up" data-aos-delay="900">
                            <iframe title="Google Map" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2236.934415309426!2d74.17990402916983!3d17.283229638066913!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bc18248b7008219%3A0x66a33d8736d2773b!2sSunBeam%20Institute%20of%20Information%20Technology!5e0!3m2!1sen!2sin!4v1708146397466!5m2!1sen!2sin" width="100%" height="250" frameBorder="0" style={{ border: "0" }} allowFullScreen="" loading="lazy" referrerPolicy="no-referrer-when-downgrade"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
}

export default Contact;
