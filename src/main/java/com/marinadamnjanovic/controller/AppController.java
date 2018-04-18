package com.marinadamnjanovic.controller;

import com.marinadamnjanovic.dao.dto.OdmorDto;
import com.marinadamnjanovic.model.Odmor;
import com.marinadamnjanovic.model.Zahtev;
import com.marinadamnjanovic.service.OdmorService;
import com.marinadamnjanovic.service.ZahtevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    ZahtevService zahtevService;

    @Autowired
    OdmorService odmorService;

    @RequestMapping("/")
    public String backHome(){
        return "index";
    }

    //@PreAuthorize("hasRole('MENADZER')")
    @RequestMapping(value = { "/menadzer" }, method = RequestMethod.GET)
    public String menadzer(ModelMap model){

        List<OdmorDto> zahtevi = zahteviList();

		model.addAttribute("zahtevi", zahtevi);

        return "menadzer";
    }

    @RequestMapping (value = { "/menadzer"}, method = RequestMethod.POST)
    public String menadzerPost(@Valid @ModelAttribute("zahtev") OdmorDto zahtev, BindingResult resulet,
                                     ModelMap model){

        DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

        try {
            Date dateOd = formatter.parse(zahtev.getDatumOd());
            Date dateDo = formatter.parse(zahtev.getDatumDo());

            Zahtev z = zahtevService.getZahtevById(zahtev.getId());

            //z.setStatus();
            z.getOdmor().setDatumOd(dateOd);
            z.getOdmor().setDatumDo(dateDo);
            z.setStatus(1);

            zahtevService.updateZahtev(z);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<OdmorDto> zahtevi = zahteviList();

        model.addAttribute("zahtevi", zahtevi);

        return "menadzer";
    }

    public List<OdmorDto> zahteviList(){
        List<Zahtev> zahteviList = zahtevService.listZahtev();
        List<OdmorDto> zahtevi = new ArrayList<>();

        for(Zahtev z : zahteviList){
            if (z.getStatus() == 0) {
                DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
                String datumDo = formatter.format(z.getOdmor().getDatumDo());
                String datumOd = formatter.format(z.getOdmor().getDatumOd());
                OdmorDto o = new OdmorDto(z.getId(), z.getOdmor().getPovod(), datumOd, datumDo);
                zahtevi.add(o);
            }
        }

        return zahtevi;
    }

    //@PreAuthorize("hasRole('ZAPOSLENI')")
    @RequestMapping(value = { "/zaposleni" }, method = RequestMethod.GET)
    public String zaposleni(ModelMap model){

        model.addAttribute("odmor", new Odmor());

        return "zaposleni";
    }

    @RequestMapping(value = { "/zaposleni" }, method = RequestMethod.POST)
    public ModelAndView zaposleniPost(String povod, String datumOd, String datumDo, ModelAndView model) {

        DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

        try {
            Date dateOd = formatter.parse(datumOd);
            Date dateDo = formatter.parse(datumDo);

            Odmor odmor = new Odmor(dateOd, dateDo, povod);
            Zahtev zahtev = new Zahtev(0, new String(""), new Date());
            zahtev.setOdmor(odmor);
            zahtevService.addZahtev(zahtev);

            model.addObject("successMsg", "Odmor uspesno dodat");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView doLogin(HttpServletRequest request, @RequestParam("username")String  username, @RequestParam("password") String password) throws LoginException {
        if(username.equals("zaposleni") && password.equals("zaposleni")){
            return new ModelAndView("redirect:/zaposleni");
        }
        else if(username.equals("menadzer") && password.equals("menadzer")){
            return new ModelAndView("redirect:/menadzer");
        }

        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


}
