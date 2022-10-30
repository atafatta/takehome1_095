/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugastakehome.tugastakehomesatu;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author STRIX
 */
@Controller
public class datacontroller {
 @RequestMapping("/input")
    //@ResponseBody
    public String getData (HttpServletRequest data, Model discountprocess){
        
        String inputname = data.getParameter("var_name");
        
        String inputprice = data.getParameter("var_price");
        
        String inputquantity = data.getParameter("var_quantity");
        
        String total = data.getParameter("var_total");
        
        String diskon = "";
        Double Price = Double.valueOf(inputprice);
        Double Total = Double.valueOf(inputquantity);
        Double PriceTotal = Price * Total;
        Double getTotal = null;
        
        if (PriceTotal < 10000)
        {
            getTotal = PriceTotal - (0 * PriceTotal/100);
            diskon = "0%";
        }
        else if (PriceTotal >= 10000 && PriceTotal < 50000)
        {
            getTotal = PriceTotal - (5 * PriceTotal/100);
            diskon = "5%";
        }
        else if (PriceTotal >= 50000 && PriceTotal <= 100000)
        {
            getTotal = PriceTotal - (10 * PriceTotal/100);
            diskon = "10%";
        }
        else if (PriceTotal > 100000)
        {
            getTotal = PriceTotal - (15 * PriceTotal/100);
            diskon = "15%";
        }
        
        discountprocess.addAttribute("name", inputname);
        discountprocess.addAttribute("price", inputprice);
        discountprocess.addAttribute("quantity", inputquantity);
        discountprocess.addAttribute("diskon", diskon);
        discountprocess.addAttribute("Hasil", getTotal);
      
        return "output";
    }
}