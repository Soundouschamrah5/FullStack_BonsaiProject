package cst;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayoub
 */
public class Constants {
    
    public static String getPreBody(){ 
        return 
            "<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\n" +
            "    <title>Bonsai Sushi Bar</title>\n" +
            "    <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Cookie\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/fonts/font-awesome.min.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/css/Contact-Form-Clean.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.3/css/lightbox.min.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://daneden.github.io/animate.css/animate.min.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/css/Login-Box-En.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/css/PHP-Contact-Form-dark-1.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/css/PHP-Contact-Form-dark.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/css/Pretty-Footer.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/css/Pricing-Table-Item-1.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/css/Pricing-Table-Item.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/css/Projects-Horizontal.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"assets/css/styles.css\">\n" +
            "</head>";
    }
    
    public static String getNavBar(){
            
        StringBuilder navBar = new StringBuilder(""+
                "    <nav class=\"navbar navbar-light navbar-expand-md shadow-sm\">"+ 
                "        <div class=\"container-fluid\"><img id=\"logo\" src=\"assets/img/rouleau-de-sushi.png\"><a class=\"navbar-brand\" href=\"#\"><strong>Bonsai </strong>Sushi Bar</a><button data-toggle=\"collapse\" class=\"navbar-toggler\" data-target=\"#navcol-1\"><span class=\"sr-only\">Toggle navigation</span><span class=\"navbar-toggler-icon\"></span></button>\n" +
                "            <div\n" +
                "                class=\"collapse navbar-collapse\" id=\"navcol-1\">\n" +
                "                <ul class=\"nav navbar-nav\">\n" +
                "                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link active\" href=\"index\">Home</a></li>\n" +
                "                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link\" href=\"Menu.html\">Menu</a></li>\n"
        );
        if(!CurrentAccount.Logged) navBar.append("                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link\" href=\"login\">Log-in</a></li>\n");
        navBar.append("                    <li class=\"nav-item\" role=\"presentation\"><a class=\"nav-link\" href=\"ContactUs.html\">Contact Us</a></li>\n" +
                "                    <li class=\"nav-item\" role=\"presentation\"></li>\n" +
                "                    <li class=\"nav-item\" role=\"presentation\"></li>\n" +
                "                </ul>\n" +
                "                <div class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\" href=\"#\" style=\"color: rgb(127,127,127);\">Our services</a>\n" +
                "                    <div class=\"dropdown-menu\" role=\"menu\"><a class=\"dropdown-item\" role=\"presentation\" href=\"Menu.html\">Dishes to deliver</a><a class=\"dropdown-item\" role=\"presentation\" href=\"Catering.html\">Catering</a></div>\n" +
                "                </div>\n" +
                "        </div>\n"
        );
        if(CurrentAccount.Logged) {
            String fullName = CurrentAccount.firstName + " " + CurrentAccount.lastName;
            navBar.append(""+
                "<form action=\"accountLogout\" id=\"logout\"></form>"+
                "<form action=\"accountProfile\" id=\"account_profile\"></form>"+
                "<div align=\"right\">" + 
                "<input type=\"submit\" class=\"btn btn-info btn-lg\" role=\"button\""+
                "style=\"background-color:white; color: black\"t value="+fullName+" form=\"account_profile\">"+
                "   </div>\n"+
                "       </div>\n" +
                "       <div align=\"right\">"+
                "<input type=\"submit\" class=\"btn btn-info btn-lg\" role=\"button\""+
                "style=\"background-color:red\"t value=\"Log Out\" form=\"logout\">"+
                "</div>\n"               
            );
        }
        navBar.append("   </nav>\n");
        
        
        return navBar.toString();
    }
    
    public static String getPromo(){
        return
                "    <div id=\"promo\">\n" +
                "        <div class=\"jumbotron\">\n" +
                "            <h1>Japanese in the city</h1>\n" +
                "            <p>Craving some japanese or Thai food? Find us in Ifrane's center, or even call us?</p>\n" +
                "            <p><a class=\"btn btn-info btn-lg\" role=\"button\" href=\"order\">Order now!</a></p>\n" +
                "        </div>\n" +
                "    </div>";
    }
    
    public static String getFooter(){
        return
                "    <div class=\"dark-section\"></div>\n" +
                "    <footer>\n" +
                "        <div class=\"container\">\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-sm-6 col-md-4 footer-navigation\">\n" +
                "                    <h3><a href=\"#\">Bonsai Sushi Bar</a></h3>\n" +
                "                    <p class=\"links\"><a href=\"#\">Home</a><strong> · </strong><a href=\"#\">Menu</a><strong> · </strong><a href=\"#\">Order</a><strong> · </strong><a href=\"#\">About</a><strong>&nbsp;· </strong><a href=\"#\">Contact</a></p>\n" +
                "                    <p class=\"company-name\">Bonsai Sushi Bar © 2021</p>\n" +
                "                </div>\n" +
                "                <div class=\"col-sm-6 col-md-4 footer-contacts\">\n" +
                "                    <div><span class=\"fa fa-map-marker footer-contacts-icon\"> </span>\n" +
                "                        <p><span class=\"new-line-span\">Quartier Hay Ryad&nbsp;</span>Ifrane, Morocco</p>\n" +
                "                    </div>\n" +
                "                    <div><i class=\"fa fa-phone footer-contacts-icon\"></i>\n" +
                "                        <p class=\"footer-center-info email text-left\"> +212 6 16 83 03 80</p>\n" +
                "                    </div>\n" +
                "                    <div><i class=\"fa fa-envelope footer-contacts-icon\"></i>\n" +
                "                        <p> <a href=\"#\" target=\"_blank\" style=\"font-size: 15px;\">support@bonsai.com</a></p>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"clearfix\"></div>\n" +
                "                <div class=\"col-md-4 footer-about\">\n" +
                "                    <h4>What is a bonsai?</h4>\n" +
                "                    <p>The word “Bon-sai” (often misspelled as bonzai or banzai) is a Japanese term which, literally translated, means “planted in a container”.&nbsp;<br></p>\n" +
                "                    <div class=\"social-links social-icons\"><a href=\"https://www.facebook.com/bonsaisushibarifrane/\" target=\"_blank\"><i class=\"fa fa-facebook\"></i></a><a href=\"#\"><i class=\"fa fa-twitter\"></i></a><a href=\"#\"><i class=\"fa fa-linkedin\"></i></a><a href=\"#\"><i class=\"fa fa-github\"></i></a></div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </footer>\n";
                
    };
    
    public static String getClosing(){
        return
                "    <script src=\"assets/js/jquery.min.js\"></script>\n" +
                "    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "    <script src=\"assets/js/bs-init.js\"></script>\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js\"></script>\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.3/js/lightbox.min.js\"></script>\n" +
                "    <script src=\"assets/js/PHP-Contact-Form-dark-1.js\"></script>\n" +
                "    <script src=\"assets/js/PHP-Contact-Form-dark.js\"></script>\n" +
                "    <script src=\"assets/js/Pricing-Table-Item-1.js\"></script>\n" +
                "    <script src=\"assets/js/Pricing-Table-Item.js\"></script>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }
    
    public static String getBody(){
        StringBuilder body = new StringBuilder("<Body>\n");
        return body.toString();
    }
}
